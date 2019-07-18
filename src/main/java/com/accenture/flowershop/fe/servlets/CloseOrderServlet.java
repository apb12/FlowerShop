package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.OrdersService;
import com.accenture.flowershop.be.business.UserService;
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
import java.math.BigDecimal;

@Controller
public class CloseOrderServlet extends HttpServlet {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;


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
        closeOrder(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        closeOrder(req,resp);
    }

    public void closeOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long orderid = Long.valueOf(req.getParameter("orderid"));
        long userid=Long.valueOf(req.getParameter("userid"));
        long cash=userService.getUserById(userid).getBalance().longValue()-Long.valueOf(req.getParameter("price"));
        BigDecimal cash1=new BigDecimal(cash);
        userService.userCashUpdate(userid,cash1);
        ordersService.updateOrders(orderid, OrderStatus.CLOSED);
        resp.sendRedirect("AdminPageServlet");


    }
}