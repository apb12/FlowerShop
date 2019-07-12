package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.OrdersService;
import com.accenture.flowershop.be.business.UserService;
import com.accenture.flowershop.be.enitity.Orders;
import com.accenture.flowershop.fe.enums.OrderStatus;
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
public class AdminPageServlet extends HttpServlet {

    @Autowired
    private UserService userService;

    @Autowired
    private OrdersService ordersService;

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
        List<Orders>ordersList=ordersService.findOrderByStatus(OrderStatus.PAID);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<style>");
        printWriter.println("body { background: url(images/img5.jpg); }");
        printWriter.println("</style>");
        printWriter.println("<body>");
        printWriter.println("<h1 align=center>Админ панель</h1>");
        for (int i = 0; i <ordersList.size() ; i++) {
            printWriter.println("<h3> заказ к выполнению № "+ordersList.get(i).getId()+"</h3>");
            printWriter.println("<h3> дата заказа "+ordersList.get(i).getOrder_date()+"</h3>");
            printWriter.println("<h3> сумма заказа  "+ordersList.get(i).getTotal_price()+"</h3>");

        }

        printWriter.println("<form action='login.jsp'>");
        printWriter.println("<p align=center><input type=submit name='loginbutton' value='вернуться на главную'/></p>");
        printWriter.println("</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}