package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.FlowerService;
import com.accenture.flowershop.be.business.FlowerStockService;
import com.accenture.flowershop.be.business.OrdersService;
import com.accenture.flowershop.be.business.UserService;
import com.accenture.flowershop.be.enitity.Bucket;
import com.accenture.flowershop.be.enitity.Flower;
import com.accenture.flowershop.be.enitity.Orders;
import com.accenture.flowershop.be.enitity.Users;
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
import java.math.BigDecimal;
import java.util.List;

@Controller
public class OrderPayServlet extends HttpServlet {


    @Autowired
    private OrdersService ordersService;

    @Autowired
    private FlowerStockService flowerStockService;
    @Autowired
    private UserService userService;
    @Autowired
    FlowerService flowerService;

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
        long sum=0;
        String login = (String) req.getSession().getAttribute("login");
        List<Flower> flowerList = flowerService.findAll();
        Users user=userService.getUserByLogin(login);
        List<Orders>ordersList=user.getOrdersList();
        List<Bucket>bucketList=ordersList.get(ordersList.size()-1).getBucket();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<style>");
        printWriter.println("body { background: url(images/5.jpg); }");
        printWriter.println("</style>");
        printWriter.println("<body>");
        printWriter.println("<h1 align=center>Привет " + login + " ваш баланс составляет "+user.getBalance()+"</h1>");
            printWriter.println("<h1>ващ заказ номер " + ordersList.get(ordersList.size()-1).getId() + "был создан</h1>");
            printWriter.println("<h1>Дата создания заказа " + ordersList.get(ordersList.size()-1).getOrder_date() + "</h1>");

//        if(bucketList.size()>0) {
//            for (int j = 0; j < bucketList.size(); j++) {
//
//
//                printWriter.println("<h1>Вы заказали : " + bucketList.get(j).getFlower().getName() + "</h1>");
//                printWriter.println("<h1>Количество  " + bucketList.get(j).getAmount() + "</h1>");
//                printWriter.println("<h1>Сумма заказа  " + bucketList.get(j).getPrice() + "</h1>");
//            }
//
//
//        }
        printWriter.println("<h3 align=center> КОРЗИНА </h3>");
        printWriter.println("<table align=center border='1' bgcolor=#87CEFA");
        printWriter.println("<tr>");
        printWriter.println("<td align=center> Цветы </td>");
        printWriter.println("<td> Количество</td>");
        printWriter.println("<td> цена</td>");
        printWriter.println("</tr>");
        if(bucketList.size()>0) {
            for (int i = 0; i < bucketList.size(); i++) {
                printWriter.println("<tr>");
                printWriter.println("<td>" + bucketList.get(i).getFlower().getName() + "</td>");
                printWriter.println("<td>" + bucketList.get(i).getAmount() + "</td>");
                printWriter.println("<td>" + bucketList.get(i).getPrice() + "</td>");
                printWriter.println("</tr>");
                sum+=bucketList.get(i).getPrice().longValue();
            }
        }
        printWriter.println("<tr>");
        printWriter.println("<td>Итого к оплате</td>");
        printWriter.println("<td>" + sum + "</td>");
        printWriter.println("</tr>");
        printWriter.println("</table>");
        printWriter.println("<form action='PaidServlet' method='post'>");
        printWriter.println("<input type='hidden' name='orderid' value='"+ordersList.get(ordersList.size()-1).getId()+"' >");
        printWriter.println("<input type='hidden' name='sum' value='"+sum+"' >");
        printWriter.println("<p align=center><button>Оплатить заказ</button></p>");
        printWriter.println("</form>");
        printWriter.println("<form action='LogOutServlet'>");
        printWriter.println("<p align=center><button>выход</button></p>");
        printWriter.println("</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}