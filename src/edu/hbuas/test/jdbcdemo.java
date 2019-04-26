package edu.hbuas.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcdemo {
    private static final String URL="jdbc:mysql://locahost:3306/localhost";
    private  static final String username="root";
    private  static final String pwd="123456";

    public static void update() throws ClassNotFoundException {

        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //建立链接
        try {
            Connection con=DriverManager.getConnection(URL,username,pwd);
            //执行增删操作
            Statement sta=con.createStatement();
            String sql="insert  into person values(9,'q','nv',12,'123hbjb','jjc' )";

            int count=sta.executeUpdate(sql);
            if(count>0)
            {
                System.out.println("操作成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void main(String args[]) throws ClassNotFoundException {

        update();

    }
}

