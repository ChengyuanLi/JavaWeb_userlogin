package com.action;

import com.domain.User;
import com.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 登录验证
 * @author aidenli
 */
public class LoginAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String upass = req.getParameter("upass");

        UserService userService = UserService.getInstance();
        User user = userService.checkLogin(uname, upass);

        if (user == null) {
            res.sendRedirect("login.html");
        } else {
            res.sendRedirect("main.html");
        }
    }
}
