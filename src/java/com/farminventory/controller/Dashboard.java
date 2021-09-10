/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.controller;

import com.farminventory.dao.UserDAO;
import com.farminventory.dao.UserDAOImpl;
import com.farminventory.entity.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public class Dashboard extends HttpServlet {

  private User loggedIn;
  UserDAO userDAO;
    private RequestDispatcher dispatcher;
  public Dashboard(){
      userDAO = new UserDAOImpl();
      
     
      
      
  }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        loggedIn = userDAO.getLogger(request.getSession().getAttribute("email").toString());
       
       String role = loggedIn.getRole();
        System.out.println("Redirecting to :" + role);
     
        switch (role) {
            case "Administrator":
          adminDashboard(request, response);
                break;
            case "Manager":
         managerDashboard(request, response);
                break;

            case "Warehouse Manager":
            warehouseDashboard(request, response);
                break;

            case "Clerk":
             clerkDashboard(request, response);
                break;

            default:
               //listProducts(request, response);
                break;
    }
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void adminDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("The Admin dashboard");
        
        dispatcher = getServletContext().getRequestDispatcher("/UserController");
        dispatcher.forward(request, response);
    }

    private void managerDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       dispatcher = getServletContext().getRequestDispatcher("/ManagerController");
       dispatcher.forward(request, response);
    }

    private void warehouseDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
dispatcher = getServletContext().getRequestDispatcher("/WarehouseManager");
        dispatcher.forward(request, response);
    }

    private void clerkDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatcher = getServletContext().getRequestDispatcher("/ClerkController");
        dispatcher.forward(request, response);

    }

   
        
    }



