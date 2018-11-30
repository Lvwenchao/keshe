package com.lv;

import com.lv.dao.ProductDao;
import com.lv.dao.UserDao;
import com.lv.domain.Product;
import com.lv.domain.User;
import com.lv.utils.MailUtils;

import javax.mail.MessagingException;
import java.sql.SQLException;

/**
 * @author: mrlv
 * @data: 2018/11/17 13:06
 * @description: 测试
 * @Version: 1.0
 **/
public class test {
    public static void main(String[] args) throws SQLException, MessagingException {
        Product product=new Product();
        product.setId("12");
        product.setName("java入门");
        ProductDao dao=new ProductDao();
        dao.addProduct(product);
    }
}
