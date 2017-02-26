package com.gdmec.jacky.digitalcampus;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://mysql-jackyfeng.c9users.io/phpmyadmin/", "jackyfeng", "cjacky3795391.");
            System.out.println("连接数据库成功");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
        } catch (SQLException e) {
            System.out.println("连接数据库失败");
        }
        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("关闭数据库成功");
            } catch (SQLException e) {
                System.out.println("关闭数据库失败");
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            close(conn);
        }
    }
}
