package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.FlowerService;
import com.accenture.flowershop.be.business.FlowerStockService;
import com.accenture.flowershop.be.business.OrdersService;
import com.accenture.flowershop.be.business.UserService;
import com.accenture.flowershop.be.enitity.Bucket;
import com.accenture.flowershop.be.enitity.Flower;
import com.accenture.flowershop.be.enitity.Orders;
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
import java.util.List;

@Controller
public class MainPageServlet extends HttpServlet {


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
        userSession(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userSession(req, resp);
    }
    public void userSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        List<Flower> flowerList = flowerService.findAll();
        List<Orders>ordersList=userService.getUserByLogin(login).getOrdersList();
        List<Bucket>bucketList=ordersList.get(ordersList.size()-1).getBucket();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<style>");
        printWriter.println("body { background: url(images/img2.jpg); }");
        printWriter.println("</style>");
        printWriter.println("<body>");
        printWriter.println("<h1 align=center>Привет " + login + " выберите цветы,которые вам нравятся</h1>");
        printWriter.println("<table align=center border='1' bgcolor=#87CEFA");
        printWriter.println("<tr>");
        printWriter.println("<td align=center> Цветы </td>");
        printWriter.println("<td> Цена</td>");
        printWriter.println("<td> Остаток</td>");
        printWriter.println("<td align=center> Корзина </td>");
        printWriter.println("</tr>");
        for (int i = 0; i < flowerList.size(); i++) {
            printWriter.println("<tr>");
            printWriter.println("<td>" + flowerList.get(i).getName() + "</td>");
            printWriter.println("<td>" + flowerList.get(i).getPrice() + "</td>");
            printWriter.println("<td>" + flowerList.get(i).getFlowerStock().getCount() + "</td>");
            printWriter.println("<td>");
            printWriter.println(" <form  action='BucketServlet' method='post'>");
            printWriter.println("<input type='number' step=1 min=1 pattern=[0-9]{3} name='amount' autofocus required>");
            printWriter.println("<input type='hidden' name='flowerid' value='"+flowerList.get(i).getId()+"' >");
            printWriter.println("<input type='hidden' name='orderid' value='"+ordersList.get(ordersList.size()-1).getId()+"' >");
            printWriter.println("<button>Положить в корзину</button></p>");
            printWriter.println("</form>");
            printWriter.println("</td>");
            printWriter.println("</tr>");
        }
        printWriter.println("</table>");
        printWriter.println("<form action='OrderPayServlet'>");
        printWriter.println("<p align=center><button>Оплатить заказ</button></p>");
        printWriter.println("</form>");
        printWriter.println("<form action='LogOutServlet'>");
        printWriter.println("<p align=center><button>выход</button></p>");
        printWriter.println("</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}


