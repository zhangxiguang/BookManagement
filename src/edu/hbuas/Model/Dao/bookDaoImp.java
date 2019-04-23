package edu.hbuas.Model.Dao;

import edu.hbuas.Model.javaBean.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bookDaoImp extends BaseDaoImp implements  bookDao {


    @Override
    public boolean addBook(String bookname, String bookauth, String bookpublic, String bookclass) {
        String sql="INSERT INTO book(bookname,auth,bookpublic,bookclass) VALUES(?,?,?,?)";
        PreparedStatement pre=getPre(sql);
        try {
            pre.setString(1,bookname);
            pre.setString(2,bookauth);
            pre.setString(3,bookpublic);
            pre.setString(4,bookclass);

            int rs=pre.executeUpdate();
            if (rs==1){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean addBokkByXml(Book book) {
        String sql="INSERT INTO book(bookname,auth,bookpublic,bookclass,loantime,returntime,status) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pre=getPre(sql);
        try {
            pre.setString(1,book.getBookname());
            pre.setString(2,book.getAuth());
            pre.setString(3,book.getPublic());
            pre.setString(4,book.getBookclass());
            pre.setTimestamp(5,book.getLoantime());
            pre.setTimestamp(6,book.getReturntime());
            pre.setString(7,book.getStatus());


            int rs=pre.executeUpdate();
            if (rs==1){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delBook1(String bookname) {
        String sql="DELETE FROM book WHERE bookname=?";
        PreparedStatement pre=getPre(sql);
        try {
            pre.setString(1,bookname);

            int rs=pre.executeUpdate();
            if (rs==1){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delBook2(int bookid) {
        String sql="DELETE FROM book WHERE bookid=?";
        PreparedStatement pre=getPre(sql);
        try {
            pre.setInt(1,bookid);

            int rs=pre.executeUpdate();
            if (rs==1){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modBook1(String bookname) {
        String sql="DELETE FROM book WHERE bookname=?";
        PreparedStatement pre=getPre(sql);
        try {
            pre.setString(1,bookname);

            int rs=pre.executeUpdate();
            if (rs==1){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean modBook2(int bookid) {
        return false;
    }
}
