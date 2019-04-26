package edu.hbuas.Model.javaBean;


import java.sql.Timestamp;

public class Book {

  private int bookid;
  private String bookname;
  private String auth;
  private String bookpublic;
  private String bookclass;
  private String loantime;
  private String eturntime;
  private String status;

  public Book() {
  }

  public Book(int bookid, String bookname, String auth, String bookpublic, String bookclass, String loantime, String eturntime, String status) {
    this.bookid = bookid;
    this.bookname = bookname;
    this.auth = auth;
    this.bookpublic = bookpublic;
    this.bookclass = bookclass;
    this.loantime = loantime;
    this.eturntime = eturntime;
    this.status = status;
  }

  @Override
  public String toString() {
    return "Book{" +
            "bookid=" + bookid +
            ", bookname='" + bookname + '\'' +
            ", auth='" + auth + '\'' +
            ", bookpublic='" + bookpublic + '\'' +
            ", bookclass='" + bookclass + '\'' +
            ", loantime='" + loantime + '\'' +
            ", eturntime='" + eturntime + '\'' +
            ", status='" + status + '\'' +
            '}';
  }

  public int getBookid() {
    return bookid;
  }

  public void setBookid(int bookid) {
    this.bookid = bookid;
  }

  public String getBookname() {
    return bookname;
  }

  public void setBookname(String bookname) {
    this.bookname = bookname;
  }

  public String getAuth() {
    return auth;
  }

  public void setAuth(String auth) {
    this.auth = auth;
  }

  public String getBookpublic() {
    return bookpublic;
  }

  public void setBookpublic(String bookpublic) {
    this.bookpublic = bookpublic;
  }

  public String getBookclass() {
    return bookclass;
  }

  public void setBookclass(String bookclass) {
    this.bookclass = bookclass;
  }

  public String getLoantime() {
    return loantime;
  }

  public void setLoantime(String loantime) {
    this.loantime = loantime;
  }

  public String getEturntime() {
    return eturntime;
  }

  public void setEturntime(String eturntime) {
    this.eturntime = eturntime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
