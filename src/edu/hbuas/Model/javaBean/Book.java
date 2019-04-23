package edu.hbuas.Model.javaBean;


import java.sql.Timestamp;

public class Book {

  private int bookid;
  private String bookname;
  private String auth;
  private String bookpublic;
  private String bookclass;
  private java.sql.Timestamp loantime;
  private java.sql.Timestamp returntime;
  private String status;

  public Book() {
  }

  @Override
  public String toString() {
    return "Book{" +
            "bookid=" + bookid +
            ", bookname='" + bookname + '\'' +
            ", auth='" + auth + '\'' +
            ", bookpublic='" + bookpublic + '\'' +
            ", bookclass='" + bookclass + '\'' +
            ", loantime=" + loantime +
            ", returntime=" + returntime +
            ", status='" + status + '\'' +
            '}';
  }

  public Book(int bookid, String bookname, String auth, String bookpublic, String bookclass, java.sql.Timestamp loantime, java.sql.Timestamp returntime, String status) {
    this.bookid = bookid;
    this.bookname = bookname;
    this.auth = auth;
    this.bookpublic = bookpublic;
    this.bookclass = bookclass;
    this.loantime = loantime;
    this.returntime = returntime;
    this.status = status;
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


  public String getPublic() {
    return bookpublic;
  }

  public void setPublic(String bookpublic) {
    this.bookpublic = bookpublic;
  }


  public String getBookclass() {
    return bookclass;
  }

  public void setBookclass(String bookclass) {
    this.bookclass = bookclass;
  }


  public java.sql.Timestamp getLoantime() {
    return loantime;
  }

  public void setLoantime(java.sql.Timestamp loantime) {
    this.loantime = loantime;
  }


  public java.sql.Timestamp getReturntime() {
    return returntime;
  }

  public void setReturntime(java.sql.Timestamp returntime) {
    this.returntime = returntime;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
