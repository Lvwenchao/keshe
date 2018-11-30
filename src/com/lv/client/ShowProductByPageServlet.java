package com.lv.client;

import com.lv.domain.PageBean;
import com.lv.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowProductByPageServlet")
public class ShowProductByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = 1;
        String _currentPage = request.getParameter("currentPage");
        if (_currentPage != null) {
            currentPage = Integer.parseInt(_currentPage);
        }
        // 2.定义每页显示条数,默认为4
        int currentCount = 4;

        String  _currentCount = request.getParameter("currentCount");
        if (_currentCount != null) {
            currentCount = Integer.parseInt(_currentCount);
        }
        // 3.获取查找的分类
        String category = "全部商品";
        request.setCharacterEncoding("utf-8");
        String _category =request.getParameter("category") ;
        if (_category != null) {
            category = _category;
        }
        // 4.调用service，完成获取当前页分页Bean数据.
        ProductService service = new ProductService();
        PageBean bean = service.findProductByPage(currentPage, currentCount,
                category);
        // 将数据存储到request范围，跳转到product_list.jsp页面展示
        request.setAttribute("bean", bean);
        request.getRequestDispatcher("/client/product_list.jsp").forward(request, response);
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
