package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.OrdersService;
import com.accenture.flowershop.be.enitity.Orders;
import com.accenture.flowershop.fe.dto.OrderDTO;
import com.accenture.flowershop.fe.enums.OrderStatus;
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
public class AdminPageServlet extends HttpServlet {

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
        adminPage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminPage(req, resp);
    }

    public void adminPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        List<OrderDTO> orderDTOListDr = new ArrayList<>();
        List<OrderDTO> orderDTOListCl = new ArrayList<>();
        for (Orders orders : ordersService.findOrderByStatus(OrderStatus.PAID)) {
            orderDTOList.add(mapper.map(orders, OrderDTO.class));
        }
        for (Orders orders : ordersService.findOrderByStatus(OrderStatus.DRAFT)) {
            orderDTOListDr.add(mapper.map(orders, OrderDTO.class));
        }
        for (Orders orders : ordersService.findOrderByStatus(OrderStatus.CLOSED)) {
            orderDTOListCl.add(mapper.map(orders, OrderDTO.class));
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<style>");
        printWriter.println("body { background: url(images/img5.jpg); }");
        printWriter.println("</style>");
        printWriter.println("<body>");
        printWriter.println("<h1 align=center>Админ панель</h1>");
        printWriter.println("<table align=left border='1' bgcolor=#87CEFA>");
        printWriter.println("<caption>Оплаченые заказы </caption>");
        printWriter.println("<tr>");
        printWriter.println("<td align=center> Номер заказа </td>");
        printWriter.println("<td>Дата заказа </td>");
        printWriter.println("<td>Сумма сумма заказа </td>");
        printWriter.println("<td>Действие с заказом</td>");
        printWriter.println("</tr>");
        for (int i = 0; i < orderDTOList.size(); i++) {
            printWriter.println("<tr>");
            printWriter.println("<td>" + orderDTOList.get(i).getId() + "</td>");
            printWriter.println("<td>" + orderDTOList.get(i).getOrder_date() + "</td>");
            printWriter.println("<td>" + orderDTOList.get(i).getTotal_price() + "</td>");
            printWriter.println("<td>");
            printWriter.println(" <form  action='CloseOrderServlet' method='post'>");
            printWriter.println("<input type='hidden' name='orderid' value='" + orderDTOList.get(i).getId() + "' >");
            printWriter.println("<input type='hidden' name='userid' value='" + orderDTOList.get(i).getUser_id() + "' >");
            printWriter.println("<input type='hidden' name='price' value='" + orderDTOList.get(i).getTotal_price() + "' >");
            printWriter.println("<button>Выполнить заказ</button></p>");
            printWriter.println("</form>");
            printWriter.println("</td>");
            printWriter.println("</tr>");
        }
        printWriter.println("</table>");
        printWriter.println("<table  align=center border='1' bgcolor=#87CEFA>");
        printWriter.println("<caption>Черновики </caption>");
        printWriter.println("<tr>");
        printWriter.println("<td align=center> Номер заказа </td>");
        printWriter.println("<td>Дата заказа </td>");
        printWriter.println("<td>Статус </td>");
        printWriter.println("<td>Действие с заказом</td>");
        printWriter.println("</tr>");
        for (int j = 0; j < orderDTOListDr.size(); j++) {
            printWriter.println("<tr>");
            printWriter.println("<td>" + orderDTOListDr.get(j).getId() + "</td>");
            printWriter.println("<td>" + orderDTOListDr.get(j).getOrder_date() + "</td>");
            printWriter.println("<td>" + orderDTOListDr.get(j).getStatus() + "</td>");
            printWriter.println("<td>");
            printWriter.println(" <form  action='DeleteOrderServlet' method='post'>");
            printWriter.println("<input type='hidden' name='orderid' value='" + orderDTOListDr.get(j).getId() + "' >");
            printWriter.println("<button>Удалить заказ</button></p>");
            printWriter.println("</form>");
            printWriter.println("</td>");
            printWriter.println("</tr>");
        }
        printWriter.println("</table>");
        printWriter.println("<table align=right border='1' bgcolor=#87CEFA>");
        printWriter.println("<caption>Архив заказов</caption>");
        printWriter.println("<tr>");
        printWriter.println("<td align=right> Номер заказа </td>");
        printWriter.println("<td>Дата заказа </td>");
        printWriter.println("<td>Сумма заказа </td>");
        printWriter.println("<td>Статус </td>");
        printWriter.println("</tr>");
        for (int y = 0; y < orderDTOListCl.size(); y++) {
            printWriter.println("<tr>");
            printWriter.println("<td>" + orderDTOListCl.get(y).getId() + "</td>");
            printWriter.println("<td>" + orderDTOListCl.get(y).getOrder_date() + "</td>");
            printWriter.println("<td>" + orderDTOListCl.get(y).getTotal_price() + "</td>");
            printWriter.println("<td>" + orderDTOListCl.get(y).getStatus() + "</td>");
            printWriter.println("<td>");
            printWriter.println("</tr>");
        }
        printWriter.println("</table>");
        printWriter.println("<form action='login.jsp'>");
        printWriter.println("<p align=center><input type=submit name='loginbutton' value='вернуться на главную'/></p>");
        printWriter.println("</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}