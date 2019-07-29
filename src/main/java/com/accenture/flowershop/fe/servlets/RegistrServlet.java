package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.JmsReciever;
import com.accenture.flowershop.be.business.JmsService;
import com.accenture.flowershop.be.business.UserMarshgallingService;
import com.accenture.flowershop.be.business.UserService;
import com.accenture.flowershop.fe.dto.UserDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrServlet extends HttpServlet {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMarshgallingService userMarshgallingService;

    @Autowired
    private JmsService jmsService;
    @Autowired
    private JmsReciever jmsReciever;
    @Autowired
    Mapper mapper;

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
        registration(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        registration(req, resp);
    }

    public void registration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<style>");
        printWriter.println("body { background: url(images/img4.jpg); }");
        printWriter.println("</style>");
        printWriter.println("<body>");

        if (!login.isEmpty() && !name.isEmpty() && !password.isEmpty() && !email.isEmpty()) {
            try {
                if (!userService.loginExist(login) && userService.registr(login, password, name, email)) {
                    userMarshgallingService.UserToXml(login);
                    jmsService.setSendNewUsers(mapper.map(userService.getUserByLogin(login), UserDTO.class));
                    resp.sendRedirect("login.jsp");
                } else {
                    printWriter.println("<h1 align=center>Пользователь с таким логином = " + login + " уже существует</h1>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            printWriter.println("<h1 align=center>Вы заполнили не все поля ,попробуйте еще раз</h1>");
        }
        printWriter.println("<form action='registration.jsp'>");
        printWriter.println("<p align=center><input type=submit name='regbutton' value=' повторная регистарация'/></p>");
        printWriter.println("</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
