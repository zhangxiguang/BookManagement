package edu.hbuas.Control;

import edu.hbuas.Model.Dao.userDao;
import edu.hbuas.Model.Dao.userDaoImp;
import edu.hbuas.Model.javaBean.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userServlet",urlPatterns = "/userServlet")
public class userServlet extends HttpServlet {
    private userDao userDao;

    @Override
    public void init() throws ServletException {
        userDao=new userDaoImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String  method = request.getParameter("method");
        switch (method) {
            case "login": {
                login(request, response);
                break;
            }
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入登录后台");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        Account account=new Account();
        account=userDao.login(username,password);

        if (account!=null){
            System.out.println("登录成功，跳转主页面");
            request.getSession().setAttribute("loginuesr",account);
            response.sendRedirect("main.jsp");
        }else {
            System.out.println("密码或账户错误，请重试!");
            String errLogin="密码或账户错误，请重试!";
            request.getSession().setAttribute("errorLogin",errLogin);
            response.sendRedirect("index.jsp");
//            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

    }



}
