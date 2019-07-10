package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class LoginServlet extends HttpServlet {

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
        logins(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logins(req, resp);
    }

    public void logins(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<style>");
        printWriter.println("body { background: url(images/img4.jpg); }");
        printWriter.println("</style>");
        printWriter.println("<body>");

        if (!login.isEmpty() && !password.isEmpty()) {
            try {
                if (userService.login(login, password)) {
                    HttpSession session = req.getSession();
                    session.setAttribute("login", login);
                    session.setMaxInactiveInterval(600);
                    if (login.equals("admin")) {
                        resp.sendRedirect("AdminPageServlet");
                    } else {
                        resp.sendRedirect("welcome.jsp");
                    }
                } else {
                    printWriter.println("<h1 align=center>Такого логина или пароля не существует</h1>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            printWriter.println("<h1 align=center>Вы заполнили не все поля,попробуйте еще раз</h1>");
        }
        printWriter.println("<form action='login.jsp'>");
        printWriter.println("<p align=center><input type=submit name='loginbutton' value='повторная авторизация'/></p>");
        printWriter.println("</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
