package edu.hbuas.Model.Dao;

import edu.hbuas.Model.javaBean.Account;

public interface userDao {
    public Account login(String username,String password);
}
