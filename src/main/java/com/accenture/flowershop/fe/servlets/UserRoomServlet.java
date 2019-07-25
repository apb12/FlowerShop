package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.OrdersService;
import com.accenture.flowershop.be.business.UserService;
import com.accenture.flowershop.be.enitity.Orders;
import com.accenture.flowershop.be.enitity.Users;
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
public class UserRoomServlet extends HttpServlet {

    @Autowired
    private UserService userService;

    @Autowired
    private OrdersService ordersService;

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
        UserPage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserPage(req, resp);
    }

    public void UserPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        Users user = userService.getUserByLogin(login);
        List<OrderDTO> ordersList = new ArrayList<>();
        for (Orders orders : ordersService.findOrderByUser(user.getId())) {
            ordersList.add(mapper.map(orders, OrderDTO.class));
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<style>");
        printWriter.println("body { background: url(images/img5.jpg); }");
        printWriter.println("</style>");
        printWriter.println("<body>");
        printWriter.println("<h1 align=center>Личный кабинет</h1>");
        printWriter.println("<h1 align=center>Ваш баланс :" + user.getBalance() + "</td>");
        printWriter.println("<h1 align=center>Ваша скидка :" + user.getDiscount() + "%</td>");
        printWriter.println("<table align=left border='1' bgcolor=#87CEFA>");
        printWriter.println("<caption>История покупок</caption>");
        printWriter.println("<tr>");
        printWriter.println("<td align=center> Номер заказа </td>");
        printWriter.println("<td>Дата заказа </td>");
        printWriter.println("<td>Сумма сумма заказа </td>");
        printWriter.println("</tr>");
        for (int i = 0; i < ordersList.size(); i++) {
            printWriter.println("<tr>");
            printWriter.println("<td>" + ordersList.get(i).getId() + "</td>");
            printWriter.println("<td>" + ordersList.get(i).getOrder_date() + "</td>");
            printWriter.println("<td>" + ordersList.get(i).getTotal_price() + "</td>");
            printWriter.println("</tr>");
        }
        printWriter.println("</table>");

        printWriter.println("<table align=right border='1' bgcolor=#87CEFA>");
        printWriter.println("<caption>Расшифровка заказа</caption>");
        printWriter.println("<tr>");
        printWriter.println("<td align=center> Номер заказа </td>");
        printWriter.println("<td>цветок </td>");
        printWriter.println("<td>количество </td>");
        printWriter.println("</tr>");
        for (int i = 0; i < ordersList.size(); i++) {
            for (int j = 0; j < ordersList.get(i).getBucket().size(); j++) {
                printWriter.println("<tr>");
                printWriter.println("<td>" + ordersList.get(i).getId() + "</td>");
                printWriter.println("<td>" + ordersList.get(i).getBucket().get(j).getFlower().getName() + "</td>");
                printWriter.println("<td>" + ordersList.get(i).getBucket().get(j).getAmount() + "</td>");
                printWriter.println("</tr>");
            }
        }
        printWriter.println("</table>");
        printWriter.println("<form action='welcome.jsp'>");
        printWriter.println("<p align=center><input type=submit name='loginbutton' value='назад'/></p>");
        printWriter.println("</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}