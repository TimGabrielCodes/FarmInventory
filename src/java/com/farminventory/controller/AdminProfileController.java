/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.controller;

import com.farminventory.dao.UserDAO;
import com.farminventory.dao.UserDAOImpl;
import com.farminventory.entity.DashboardUtil;
import com.farminventory.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public class AdminProfileController extends HttpServlet {

    RequestDispatcher dispatcher= null;
    UserDAO userDAO = null;
    User user = null;
    
    public AdminProfileController(){
        userDAO = new UserDAOImpl();
        user= new User();
                
    }



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
         
            DashboardUtil util = new DashboardUtil();
            util.setAdmin(userDAO.getAdminCount());
            util.setManagers(userDAO.getManagerCount());
            util.setUsers(userDAO.getUserCount());
            util.setClerk(userDAO.getClerkCount());
            util.setWarehouse(userDAO.getWarehouseManagerCount());
             System.out.println("I am passing this user + " + user.toString());
             System.out.println("and this Util" + util.toString());
             request.setAttribute("util", util);
        request.setAttribute("user", user);
        request.setAttribute("title", "Profile");
        dispatcher = request.getRequestDispatcher("/Views/Admin/Profile.jsp");
        dispatcher.forward(request, response);

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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


