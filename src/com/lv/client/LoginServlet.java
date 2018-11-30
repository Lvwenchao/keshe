package com.lv.client;

import com.lv.domain.User;
import com.lv.service.UserService;

import javax.mail.Session;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 2.调用service完成登录操作。
        UserService service = new UserService();
        HttpSession session=request.getSession();
        try {
            User user = service.login(username, password);
            session.setAttribute("user",user);
            // 获取用户的角色，其中用户的角色分普通用户和超级用户两种
            String role = user.getRole();
            // 如果是超级用户，就进入到网上书城的后台管理系统；否则进入我的账户页面
            if ("管理员".equals(role)) {
                response.sendRedirect("/admin/login/myhome.jsp");
                return;
            } else {
                response.sendRedirect("/client/myAccount.jsp");
                return;
            }
        } catch (LoginException e) {
            // 如果出现问题，将错误信息存储到request范围，并跳转回登录页面显示错误信息
            e.printStackTrace();
            request.setAttribute("register_message", e.getMessage());
            request.getRequestDispatcher("/client/login.jsp").forward(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
