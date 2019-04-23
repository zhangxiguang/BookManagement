package edu.hbuas.Model.Dao;

import edu.hbuas.Model.javaBean.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDaoImp extends BaseDaoImp implements userDao {

    @Override
    public Account login(String username, String password) {
        String sql="SELECT * FROM account WHERE username=? and password=?";
        PreparedStatement pre=getPre(sql);
        try {
            pre.setString(1,username);
            pre.setString(2,password);
            ResultSet rs=pre.executeQuery();
            if (rs.next()){
                Account a=new Account();
                a.setUserid(rs.getInt("userid"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setNickname(rs.getString("nickname"));

                System.out.println("查到用户:"+a);
                return a;
            }else {
                System.out.println("账户密码不对");
                return  null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
