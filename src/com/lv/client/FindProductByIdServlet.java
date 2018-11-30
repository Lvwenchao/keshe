package com.lv.client;

import com.lv.domain.Product;
import com.lv.exception.FindProductByIdException;
import com.lv.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindProductByIdServlet")
public class FindProductByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 得到商品的id
        String id = request.getParameter("id");
        // 获取type参数值，此处的type用于区别普通用户和超级用户
        String type = request.getParameter("type");
        ProductService service = new ProductService();
        try {
            // 调用service层方法，通过id查找商品
            Product p = service.findProductById(id);
            request.setAttribute("p", p);
            // 普通用户默认不传递type值，会跳转到info.jsp页面
            if (type == null) {
                request.getRequestDispatcher("/client/info.jsp").forward(request,response);
                return;
            }
            request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
            return;
        } catch (FindProductByIdException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
