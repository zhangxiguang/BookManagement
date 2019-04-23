package edu.hbuas.Model.Dao;



import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class BaseDaoImp implements BaseDao {
    private static Connection con=null;
    private PreparedStatement pre;
    private Statement sta;

    private static Properties properties;
    private static DataSource dataSource;
    private static BasicDataSourceFactory dataSourceFactory;

    static {

        try {
            Class.forName(driverClass); //classLoader,加载对应驱动
            try {
                con = (Connection) DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Connection getCon() {

        System.out.println("一个数据库已连接");
        return  con;
    }


    public PreparedStatement getPre(String sqls) {
        String sql = sqls;

        if (con == null) {
            getCon();
        }

        try {
            pre = con.prepareStatement(sql);
            return pre;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pre;
    }

    public Statement getSta() {

        if (con == null) {
            getCon();
        }

        try {
            sta = con.createStatement();
            return sta;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sta;
    }
}
