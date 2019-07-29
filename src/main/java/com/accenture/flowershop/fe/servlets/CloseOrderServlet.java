package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.FlowerStockService;
import com.accenture.flowershop.be.business.OrdersService;
import com.accenture.flowershop.be.business.UserService;
import com.accenture.flowershop.be.enitity.Bucket;
import com.accenture.flowershop.be.enitity.Flower;
import com.accenture.flowershop.be.enitity.FlowerStock;
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

    @Autowired
    private FlowerStockService flowerStockService;


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
        closeOrder(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        closeOrder(req, resp);
    }

    public void closeOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long orderid = Long.valueOf(req.getParameter("orderid"));
        long userid = Long.valueOf(req.getParameter("userid"));
        double cash = userService.getUserById(userid).getBalance().doubleValue() - Double.valueOf(req.getParameter("price"));
        userService.userCashUpdate(userid, new BigDecimal(cash));
       for(Bucket b:ordersService.findOrdersById(orderid).getBucket()){
         long fl=  b.getFlower().getFlowerStock().getCount()-b.getAmount();
         flowerStockService.updateFlowerStock(b.getFlower().getFlowerStock().getId(),fl);

       }
        ordersService.updateOrders(orderid, OrderStatus.CLOSED);
        resp.sendRedirect("AdminPageServlet");
    }
}