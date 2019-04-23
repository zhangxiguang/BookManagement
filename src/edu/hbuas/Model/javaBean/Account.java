package edu.hbuas.Model.javaBean;


public class Account {

  private int userid;
  private String username;
  private String password;
  private String nickname;

  public Account() {
  }

  public Account(int userid, String username, String password, String nickname) {
    this.userid = userid;
    this.username = username;
    this.password = password;
    this.nickname = nickname;
  }

  @Override
  public String toString() {
    return "Account{" +
            "userid=" + userid +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", nickname='" + nickname + '\'' +
            '}';
  }

  public long getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

}
