package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.OrdersService;
import com.accenture.flowershop.be.business.UserService;
import com.accenture.flowershop.be.enitity.Bucket;
import com.accenture.flowershop.be.enitity.Orders;
import com.accenture.flowershop.be.enitity.Users;
import com.accenture.flowershop.fe.dto.BucketDTO;
import com.accenture.flowershop.fe.dto.OrderDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderPayServlet extends HttpServlet {


    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;

    @Autowired
    private Mapper mapper;

    private ServletConfig config;


    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void destroy() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doBuy(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doBuy(req, resp);
    }

    public void doBuy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double sum = 0;
        String login = (String) req.getSession().getAttribute("login");
        Users user = userService.getUserByLogin(login);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        List<BucketDTO> bucketDTOList = new ArrayList<>();
        for (Orders o : ordersService.findOrderByUser(user.getId())) {
            orderDTOList.add(mapper.map(o, OrderDTO.class));
        }
        for (Bucket b : orderDTOList.get(orderDTOList.size() - 1).getBucket()) {
            bucketDTOList.add(mapper.map(b, BucketDTO.class));
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<style>");
        printWriter.println("body { background: url(images/5.jpg); }");
        printWriter.println("</style>");
        printWriter.println("<body>");
        printWriter.println("<h1 align=center>Привет " + login + " ваш баланс составляет " + user.getBalance() + "</h1>");
        printWriter.println("<h1>ващ заказ номер " + orderDTOList.get(orderDTOList.size() - 1).getId() + "</h1>");
        printWriter.println("<h3 align=center> КОРЗИНА </h3>");
        printWriter.println("<table align=center border='1' bgcolor=#87CEFA");
        printWriter.println("<tr>");
        printWriter.println("<td align=center> Цветы </td>");
        printWriter.println("<td> Количество</td>");
        printWriter.println("<td> цена</td>");
        printWriter.println("</tr>");
        if (bucketDTOList.size() > 0) {
            for (int i = 0; i < bucketDTOList.size(); i++) {
                printWriter.println("<tr>");
                printWriter.println("<td>" + bucketDTOList.get(i).getFlower().getName() + "</td>");
                printWriter.println("<td>" + bucketDTOList.get(i).getAmount() + "</td>");
                printWriter.println("<td>" + bucketDTOList.get(i).getPrice() + "</td>");
                printWriter.println("</tr>");
                sum += bucketDTOList.get(i).getPrice().doubleValue();
            }
        }
        double d = user.getDiscount();
        sum = sum * ((100 - d) / 100);
        if (sum > user.getBalance().longValue()) {
            resp.sendRedirect("errors.jsp");
        }
        printWriter.println("<tr>");
        printWriter.println("<td>Итого к оплате</td>");
        printWriter.println("<td>" + sum + "</td>");
        printWriter.println("</tr>");
        printWriter.println("</table>");
        printWriter.println("<form action='PaidServlet' method='post'>");
        printWriter.println("<input type='hidden' name='orderid' value='" + orderDTOList.get(orderDTOList.size() - 1).getId() + "' >");
        printWriter.println("<input type='hidden' name='sum' value='" + sum + "' >");
        printWriter.println("<p align=center><button>Оплатить заказ</button></p>");
        printWriter.println("</form>");
        printWriter.println("<form action='LogOutServlet'>");
        printWriter.println("<p align=center><button>выход</button></p>");
        printWriter.println("</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}