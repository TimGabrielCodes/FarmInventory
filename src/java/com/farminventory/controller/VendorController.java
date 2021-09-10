/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.controller;

import com.farminventory.dao.UserDAO;
import com.farminventory.dao.UserDAOImpl;
import com.farminventory.entity.Vendor;
import java.io.IOException;
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
public class VendorController extends HttpServlet {
    
    
    UserDAO userDAO = null;
    RequestDispatcher dispatcher = null;

    public VendorController() {
        userDAO = new UserDAOImpl();
    }


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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");

        if (action == null) {
            action = "LIST";

        }
        switch (action) {
            case "LIST":
                listVendors(request, response);
                break;
            case "ADD":
                addVendor(request, response);
                break;

            case "EDIT":
                getSingleVendor(request, response);
                break;
  
            case "DELETE":
               
               deleteVendor(request, response);
                break;

            default:
                listVendors(request, response);
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
         String vendor_name = request.getParameter("vendor_name");
        String vendor_id = request.getParameter("vendor_id");
        int created_by =  userDAO.getLogger(request.getParameter("created_by")).getUser_id();
      

    
        Vendor vendor = new Vendor();
       
        vendor.setCreated_by(created_by);
     
        //  vendor.setVendor_id(Integer.parseInt(vendor_id));
        vendor.setVendor_name(vendor_name);
        
        if (vendor_id.isEmpty()) {
            //save if
            if (userDAO.addVendor(vendor)) {
               
                request.setAttribute("message", "User saved Successfully");
                listVendors(request, response);
            }
        } else {
            //update
            vendor.setVendor_id(Integer.parseInt(vendor_id));

            if (userDAO.update(vendor)) {
                 listVendors(request, response);
                request.setAttribute("message", "User updated Successfully");
            }
             listVendors(request, response);
    }
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

    private void listVendors(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
         try{
             List<Vendor> list = userDAO.getVendors();
             request.setAttribute("list", list);
             dispatcher = request.getRequestDispatcher("/Views/Manager/vendor_list.jsp");
             dispatcher.forward(request, response);
         } catch(IOException ex){
            ex.printStackTrace();
         }
        
    }

    private void getSingleVendor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        Vendor vendor = userDAO.getVendor(id);
        request.setAttribute("vendor", vendor);
        dispatcher = request.getRequestDispatcher("/Views/Manager/addVendor.jsp");
        dispatcher.forward(request, response);
    }
    private void addVendor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        dispatcher = request.getRequestDispatcher("/Views/Manager/addVendor.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteVendor(HttpServletRequest request, HttpServletResponse response) throws ServletException {
         userDAO = new UserDAOImpl();
   String id = request.getParameter("id");
        System.out.println(id);
   
        if(userDAO.deleteVendor(Integer.parseInt(id))){
          request.setAttribute("message", "Vendor Deleted!");
            listVendors(request, response);
         
       }
        listVendors(request, response);
    }

}

   