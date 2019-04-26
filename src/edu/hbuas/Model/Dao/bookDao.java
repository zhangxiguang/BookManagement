package edu.hbuas.Model.Dao;

import edu.hbuas.Model.javaBean.Book;

public interface bookDao {
    public boolean addBook(String bookname,String bookauth,String bookpublic,String bookclass);
    public boolean addBokkByXml(Book book);
    public boolean delBook1(String bookname);
    public boolean delBook2(int bookid);
    public boolean modBook1(String bookname);
    public boolean modBook2(int bookid);

    //清空数据
    public void emptyDate();

}
