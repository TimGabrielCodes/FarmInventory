/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.controller;

import com.farminventory.dao.ProductDAO;
import com.farminventory.dao.ProductDAOImpl;
import com.farminventory.entity.Transaction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public class TransactionController extends HttpServlet {

    private RequestDispatcher dispatcher;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
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
        
              String action = request.getParameter("action");
              System.out.println(action);

        if (action == null) {
            action = "LIST";

        }
        switch (action) {
            case "LIST":
               listTransactions(request, response);
                break;
            
            case "CREATE":
               makeTransaction(request, response);
                break;

           case "VIEW":
              // getSingleTransaction(request, response);
                break;
         
            default:
                action="LIST";
        //processRequest(request, response);
    }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

    private void listTransactions(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductDAO productDAO = new ProductDAOImpl();
        List<Transaction> list = productDAO.getTrans();
        request.setAttribute("list", list);
         request.setAttribute("title", "Transactions");
        // dispatcher = request.getRequestDispatcher("/Views/WarehouseManager/ViewTransactions.jsp");
        //dispatcher.forward(request, response);
          dispatcher = request.getRequestDispatcher("/Views/WarehouseManager/ViewTransactions.jsp");
           dispatcher.forward(request, response);
    }

  

    private void makeTransaction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
         request.setAttribute("title", "Make Transaction");
          dispatcher = request.getRequestDispatcher("/Views/WarehouseManager/MakeTransaction.jsp");
           dispatcher.forward(request, response);
           
    }
    
}