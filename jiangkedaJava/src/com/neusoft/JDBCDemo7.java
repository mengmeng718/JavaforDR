package com.neusoft;

import com.neusoft.utils.JDBCUtils;
import sun.awt.geom.AreaOp;

import java.sql.*;
import java.util.Scanner;

//    通过键盘录入用户名和密码,判断用户是否登录成功
//    select * from user where username = "" and password = "";
//    如果这个sql有查询结果，则成功，反之，则失败
//  模拟用户登录程序
public class JDBCDemo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎来到萌萌的登录界面~");
        System.out.println("请输入您的用户名：");
        String userName = scanner.next();
        System.out.println("请输入您的密码：");
        String password = scanner.next();
        boolean flag = login(userName, password);
        if (flag) {
            System.out.println("登录成功~");
        } else {
            System.out.println("用户名或密码错误，请重新登录");
        }
    }

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    public static boolean login(String userName, String password) {
        // 参数校验
        if (userName == null || password == null) {
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = '" + userName + "' and password='" + password + "'";
//            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 走到这里说明有异常，需要返回true
        return false;
    }
}
