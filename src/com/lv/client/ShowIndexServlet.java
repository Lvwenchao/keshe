package com.lv.client;

import com.lv.domain.Notice;
import com.lv.service.NoticeService;
import com.lv.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowIndexServlet")
public class ShowIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NoticeService nService = new NoticeService();
        Notice notice = nService.getRecentNotice();
        req.setAttribute("n", notice);

        //查询本周热销的两条商品，传递到index.jsp页面进行展示
        ProductService pService = new ProductService();
        List<Object[]> pList =  pService.getWeekHotProduct();
		/*for(Object[] os:pList){
			for(Object o:os){
				System.out.println(o);
			}
			System.out.println("---------------------");
		}*/
        req.setAttribute("pList", pList);

        //请求转发
        req.getRequestDispatcher("/client/index.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
