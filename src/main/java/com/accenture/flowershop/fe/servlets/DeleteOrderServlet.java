package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DeleteOrderServlet extends HttpServlet {

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
        deleteOrder(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        deleteOrder(req, resp);
    }

    public void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long orderid = Long.valueOf(req.getParameter("orderid"));
        ordersService.ordersDelete(orderid);
        resp.sendRedirect("AdminPageServlet");
    }
}