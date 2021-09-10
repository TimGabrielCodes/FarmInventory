/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.controller;

import com.farminventory.dao.LocationDAO;
import com.farminventory.dao.LocationDAOImpl;
import com.farminventory.entity.Location;
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
public class DeliveryController extends HttpServlet {

    LocationDAO locationDAO = null;
    RequestDispatcher dispatcher = null;
    Location location = null;
    
    public DeliveryController() {
        locationDAO = new LocationDAOImpl();
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
            case "LIST":
                listLocation(request, response);
                break;
            
            case "EDIT":
                getSingleLocation(request, response);
                break;
            
            case "DELETE":
                delete(request, response);
                break;
            
            case "NEW":
                newDelivery(request, response);
                break;
            
            default:
                listLocation(request, response);
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
        String state = request.getParameter("state");
        //   String area = request.getParameter("area");
        double charge = Double.parseDouble(request.getParameter("charge"));
        String id = (request.getParameter("id"));
        location = new Location();
        //  location.setArea(area);
        location.setCharge(charge);
        location.setState(state);

        // System.out.println(location.getArea());
        System.out.println(location.getState());
        System.out.println(location.getCharge());
        if (id.isEmpty()) {
            
            if (locationDAO.save(location)) {
                request.setAttribute("message", "Saved");
                listLocation(request, response);
            } else {
                request.setAttribute("message", "Error! Duplicate Entry found");
                listLocation(request, response);
            }
        } else {
            location.setLocation_id(Integer.parseInt(id));
            if (locationDAO.update(location)) {
                request.setAttribute("message", "Update Committed Successfully");
                listLocation(request, response);
            }
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

    public void listLocation(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<Location> list = locationDAO.get();
            
            request.setAttribute("list", list);
            request.setAttribute("title", "View Delivery Charges");
            dispatcher = request.getRequestDispatcher("/Views/Manager/DeliveryCharges.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getSingleLocation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        //System.out.println(id);
        location = locationDAO.getLocation(id);
        request.setAttribute("title", "Edit Delivery Charges");
        request.setAttribute("location", location);
        System.out.println("Edititng locations");
//            System.out.println(location.getArea());
        System.out.println(location.getCharge());
        System.out.println(location.getLocation_id());
        System.out.println(location.getState());
        System.out.println("Edititng locations");
        dispatcher = request.getRequestDispatcher("/Views/EditDelivery.jsp");
        dispatcher.forward(request, response);
        
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        request.setAttribute("title", "Delete");
        int id = Integer.parseInt(request.getParameter("id"));
        //System.out.println(id);

        if (locationDAO.delete(id)) {
            request.setAttribute("message", "Product Deleted!");
            
        }
        listLocation(request, response);
        
    }

    private void newDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        dispatcher = request.getRequestDispatcher("/Views/Manager/EditDelivery.jsp");
        dispatcher.forward(request, response);
    }
    
}
