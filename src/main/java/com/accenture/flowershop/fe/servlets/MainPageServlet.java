package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.FlowerService;
import com.accenture.flowershop.be.business.UserService;
import com.accenture.flowershop.be.enitity.Flower;
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
        List<Flower>flowerList=flowerService.findAll();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<style>");
        printWriter.println("body { background: url(images/img2.jpg); }");
        printWriter.println("</style>");
        printWriter.println("<body>");
        printWriter.println("<h1 align=center>Привет " + login + " вы в сессии</h1>");

        for (int i = 0; i <flowerList.size() ; i++) {



                printWriter.println("<tr>");
                printWriter.println("<td class='t1'>" + flowerList.get(i).getName() + "</td>");
                printWriter.println("<td class='t2'>" + flowerList.get(i).getPrice()+ "</td>");
                printWriter.println("<td class='t3'>" + flowerList.get(i).getTotal() + "</td>");
                printWriter.println("</tr>");
                printWriter.println(" <form >");
    printWriter.println("<p>кол-во цетов:");
    printWriter.println("<input type='number' name='cm' autofocus></p>");
            printWriter.println("<p><button>Положить в корзину</button></p>");
  printWriter.println("</form>");
            }



        printWriter.println("<form action='LogOutServlet'>");
	    printWriter.println("<p align=center><button>выход</button></p>");
	    printWriter.println("</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}

