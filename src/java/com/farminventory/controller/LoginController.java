/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.controller;

import com.farminventory.dao.LoginDAO;
import com.farminventory.dao.LoginDAOImpl;
import com.farminventory.dao.UserDAO;
import com.farminventory.dao.UserDAOImpl;
import com.farminventory.entity.Login;
import com.farminventory.entity.User;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public class LoginController extends HttpServlet {
    LoginDAO loginDAO = null;
    User user;
    UserDAO userDAO;
    public LoginController(){
        loginDAO = new LoginDAOImpl();
        userDAO = new UserDAOImpl();
       user = new User();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        Login login = new Login();
        login.setEmail(request.getParameter("email"));
        
        
        login.setPassword(request.getParameter("password"));
        
      String status =  loginDAO.authenticate(login);
      
      if(status.equals("true")){
          user = userDAO.getLogger(login.getEmail());
          session.setAttribute("email", login.getEmail());
          session.setAttribute("loggedIn", user);
          response.sendRedirect("Dashboard");
      }
      if(status.equals("false")){
          response.sendRedirect("index.jsp?status=false");
      }
      if(status.equals("error")){
          response.sendRedirect("index.jsp?status=error");
      }
    }
    
}