/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.controller;

import com.farminventory.dao.*;
import com.farminventory.entity.Location;
import com.farminventory.entity.Product;
import com.farminventory.entity.Transaction;
import com.farminventory.entity.User;
import com.farminventory.util.Config;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public class ValidateClerkTransaction extends HttpServlet {

    ProductDAO productDAO = null;
    UserDAO userDAO = null;
    LocationDAO locationDAO = null;
    Product product = null;
    Location location = null;
    public RequestDispatcher dispatcher;
    Config config;
    User logger;
    Transaction transaction;

    public ValidateClerkTransaction() {
        transaction = new Transaction();
        productDAO = new ProductDAOImpl();
        locationDAO = new LocationDAOImpl();
        userDAO = new UserDAOImpl();
        logger = new User();
        location = new Location();
        product = new Product();
        config = new Config();

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
        System.out.println("Hello Validate");

        String productName = request.getParameter("product_name");
        String paymentMethod = request.getParameter("method");
        String client = request.getParameter("client");
        int requestedQty = Integer.parseInt(request.getParameter("quantity"));
        
        location = locationDAO.getLocationByState(request.getParameter("delivery"));
        String loc = request.getParameter("delivery");
           System.out.println("Payment Method is" + paymentMethod);
           System.out.println("Location is" + location.toString());
           System.out.println("Location is" + loc);
        
        product = productDAO.get(productName);
        
        
        transaction.setProduct(product);
        transaction.setQuantity(requestedQty);
        transaction.setDelivery(location);
        transaction.setLogger(userDAO.getLogger(request.getSession().getAttribute("email").toString()));
        transaction.setDelivery(location);
        transaction.setVAT(productDAO.getConfig().getVAT());
        transaction.setBuyer(client);
        
        transaction.setCostPrice();
        transaction.setSubCharge();
        transaction.setTotalCharge();
        System.out.println("The total charge is: " + transaction.getTotalCharge());
        System.out.println("The delivery charge is: )" + transaction.getDelivery().getCharge());
        
     config = productDAO.getConfig();
      //  double POS_CHARGE = config.getPOS();
      System.out.println(config.toString());
     
      if(paymentMethod.equals("POS")){
         transaction.setPOS_charge(productDAO.getConfig().getPOS());
    } 
     
         if (requestedQty > product.getQuantity()) {
            System.out.println("This is the product: " + product.toString());
            request.setAttribute("message","<div class='alert  alert-danger' role='alert'>Not enough products in stock</div>");
            dispatcher = request.getRequestDispatcher("/Views/Clerk/MakeTransaction.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("transaction", transaction);
             
         dispatcher = request.getRequestDispatcher("/Views/Clerk/MakeTransaction.jsp");
         dispatcher.forward(request, response);
        }
       
     
    }
    


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("This is the Transaction" + transaction.toString());
         if(productDAO.logTransaction(transaction)){
             productDAO.updateTable(transaction);
            request.setAttribute("message", "Done");
             
        
         }else{
              request.setAttribute("message", "error");
         }
         response.sendRedirect("Dashboard");

           
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




