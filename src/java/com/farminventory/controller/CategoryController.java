/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.controller;

import com.farminventory.dao.ProductDAO;
import com.farminventory.dao.ProductDAOImpl;
import com.farminventory.dao.UserDAO;
import com.farminventory.dao.UserDAOImpl;
import com.farminventory.entity.Category;
import com.farminventory.entity.User;
import java.io.IOException;
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
public class CategoryController extends HttpServlet {

    ProductDAO productDAO = null;
    RequestDispatcher dispatcher = null;
    Category cat = null;
    
    public CategoryController() {
        productDAO = new ProductDAOImpl();
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
                listCategory(request, response);
                break;
            
            case "EDIT":
                getSingleCategory(request, response);
                break;
            
            case "DELETE":
                delete(request, response);
                break;
            
            case "NEW":
                newCategory(request, response);
                break;
            
            default:
                listCategory(request, response);
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
        String category = request.getParameter("category");
      UserDAO userDAO = new UserDAOImpl();
       User user = userDAO.getLogger(request.getSession().getAttribute("email").toString());
        String id = request.getParameter("id");
        cat = new Category();
        //  category.setArea(area);
     cat.setName(category);

     cat.setCreatedBy(user.getFullName());

        System.out.println("Category from interface" + cat.toString());
        if (id.isEmpty()) {
            
            if (productDAO.saveCategory(cat)) {
                request.setAttribute("message", "Saved");
                listCategory(request, response);
            } else {
                request.setAttribute("message", "Error! Duplicate Entry found");
                listCategory(request, response);
            }
        } else {
            cat.setId(Integer.parseInt(id));
            if (productDAO.update(cat)) {
                request.setAttribute("message", "Update Committed Successfully");
                listCategory(request, response);
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

    public void listCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<Category> list = productDAO.getCategories();
            
            request.setAttribute("list", list);
            System.out.println(list.get(0));
            request.setAttribute("title", "View Categories");
            dispatcher = request.getRequestDispatcher("/Views/WarehouseManager/Categories.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getSingleCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        //System.out.println(id);
        cat = productDAO.getCategory(id);
        request.setAttribute("title", "Edit Delivery Charges");
        request.setAttribute("category", cat);
        dispatcher = request.getRequestDispatcher("/Views/WarehouseManager/EditCategory.jsp");
        dispatcher.forward(request, response);
        
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        request.setAttribute("title", "Delete");
        int id = Integer.parseInt(request.getParameter("id"));
        //System.out.println(id);

        if (productDAO.deleteCategory(id)) {
            request.setAttribute("message", "Product Deleted!");
            
        }
        listCategory(request, response);
        
    }

    private void newCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        dispatcher = request.getRequestDispatcher("/Views/WarehouseManager/EditCategory.jsp");
        dispatcher.forward(request, response);
    }
    
}
