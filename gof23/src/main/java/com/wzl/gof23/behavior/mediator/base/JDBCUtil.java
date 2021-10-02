package com.wzl.gof23.behavior.mediator.base;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC工具类
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/2 8:43
 */
@Slf4j
public class JDBCUtil {

    public static final String URL = "jdbc:mysql://1.14.76.46:3306/iroman";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        // 1. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 创建mysql连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        // 3. 创建statement或者preStatement
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("select id, name, age, create_time, update_time from iroman_gof23");
        while (resultSet.next()) {
            log.info("测试结果 姓名：{} 年龄：{}", resultSet.getString("name"),resultSet.getInt("age"));
        }
    }
}
