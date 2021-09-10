/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.controller;

import com.farminventory.dao.ProductDAO;
import com.farminventory.dao.ProductDAOImpl;
import com.farminventory.dao.UserDAO;
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

public class GlobalConfig extends HttpServlet {
    Config config = null;
    ProductDAO productDAO = null;
    public GlobalConfig(){
        config = new Config();
       
        
        
    }
   
    RequestDispatcher dispatcher = null;
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
        try (PrintWriter out = response.getWriter()) {
 
            
        }
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

        if (action == null) {
            action = "LIST";

        }
        switch (action) {
       
            case "EDITPOS":
                editPOSVAT(request, response);
                break;
            case "EDITDEL":
                editDelivery(request, response);
                break;
            case "ADD":
                newDelivery(request, response);
                break;
            
           
         
            default:
               editGlobal(request, response);
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
         String lastModifiedBy = request.getSession().getAttribute("email").toString();
         System.out.println("Last Modified by" + lastModifiedBy);
        double POS = Double.parseDouble(request.getParameter("POS"));
        double VAT = Double.parseDouble(request.getParameter("VAT"));
        Integer restockLevel = Integer.parseInt(request.getParameter("restock_level"));
     
        
        config.setLastModifiedBy(lastModifiedBy);
        config.setPOS(POS);
        config.setVAT(VAT);
        config.setRestockLevel(restockLevel);
                    
                
        if (productDAO.updateConfig(config)){
                request.setAttribute("message", "Saved!!");
            }
      
           
        editGlobal(request, response);

    
    }
    protected void editPOSVAT(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        productDAO = new ProductDAOImpl();
      config = productDAO.getConfig();
      
      request.setAttribute("config", config);
      dispatcher = request.getRequestDispatcher("/Views/Manager/EditPOSandVat.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void editGlobal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         dispatcher = request.getRequestDispatcher("/Views/Manager/GlobalConfig.jsp");
        dispatcher.forward(request, response);
    }
    private void editDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         dispatcher = getServletContext().getRequestDispatcher("/DeliveryController");
        dispatcher.forward(request, response);
    }
    private void newDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         dispatcher = getServletContext().getRequestDispatcher("/DeliveryController?action=NEW");
        dispatcher.forward(request, response);
    }
    

}









