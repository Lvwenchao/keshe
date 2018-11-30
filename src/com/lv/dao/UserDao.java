package com.lv.dao;

import com.lv.domain.User;
import com.lv.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Mr.lv
 * @data: 2018/11/17 11:01
 * @description: 对数据库中用户表的操作
 * @Version: 1.0
 **/
public class UserDao {
    public void addUser(User user) throws SQLException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=format.format(new Date());

        String sql = "insert into user(username,password,gender,email,telephone,introduce,activecode,registTime" +
                ") values(?,?,?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        int row = runner.update(sql, user.getUsername(), user.getPassword(),
                user.getGender(), user.getEmail(), user.getTelephone(),
                user.getIntroduce(), user.getActiveCode(),date);
        if (row == 0) {
            throw new RuntimeException();
        }
    }

    // 根据激活码查找用户
    public User findUserByActiveCode(String activeCode) throws SQLException {
        String sql = "select * from user where activecode=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class), activeCode);

    }

    // 激活用戶
    public void activeUser(String activeCode) throws SQLException {
        String sql = "update user set state=? where activecode=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, 1, activeCode);
    }

    //根据用户名与密码查找用户
    public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
        String sql="select * from user where username=? and password=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class),username,password);
    }
}
