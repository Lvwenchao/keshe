package com.lv.client;

import com.lv.domain.User;
import com.lv.exception.RegisterException;
import com.lv.service.UserService;
import com.lv.utils.ActiveCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
       try {
           String username = request.getParameter("username");
           String password = request.getParameter("password");
           String email = request.getParameter("email");
           String gender = request.getParameter("gender");
           String telephone = request.getParameter("telephone");
           user.setUsername(username);
           user.setPassword(password);
           user.setEmail(email);
           user.setGender(gender);
           user.setTelephone(telephone);
           // 封裝激活码
           user.setActiveCode(ActiveCodeUtils.createActiveCode());
       }
       catch (Exception e){
           e.printStackTrace();
       }
       try {
            UserService service = new UserService();
            service.register(user);
        }
        catch (RegisterException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
            System.out.println(e.getMessage());
            return;
        }
        //注册成功，跳转到registersuccess.jsp
        response.sendRedirect("/client/registersuccess.jsp");
        return;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}

