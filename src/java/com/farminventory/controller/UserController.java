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
public class UserController extends HttpServlet {

    UserDAO userDAO = null;
    RequestDispatcher dispatcher = null;

    public UserController() {
        userDAO = new UserDAOImpl();
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
                listUsers(request, response);
                break;
            case "ADD":
                newUser(request, response);
                break;

            case "EDIT":
                getSingleUser(request, response);
                break;
  
            case "DELETE":
                deleteUser(request, response);
                break;
            case "MANAGERS":
                listManagers(request, response);
                break;
            case "WAREHOUSE":
                listWarehouseManagers(request, response);
                break;
                
            case "CLERKS":
                listClerks(request, response);
                break;

            default:
                listUsers(request, response);
                break;
        }
//processRequest(request, response);
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
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password1 = request.getParameter("pass1");
        String password2 = request.getParameter("pass2");
        String userID = request.getParameter("user_id");
        String role = request.getParameter("role");

        System.out.println(role);
        User user = new User();
      

        user.setEmail(email);
        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        user.setUsername(username);
        user.setPassword(password1);
        user.setRole(role);
        if (userID.isEmpty()) {
            //save if
            if (userDAO.saveUser(user)) {
                request.setAttribute("message", "User saved Successfully");
            }
        } else {
            //update
            user.setUser_id(Integer.parseInt(userID));

            if (userDAO.updateUser(user)) {
                request.setAttribute("message", "User updated Successfully");
            }
        }

        listUsers(request, response);

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

    public void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<User> list = userDAO.get();
            DashboardUtil util = new DashboardUtil();
            util.setAdmin(userDAO.getAdminCount());
            util.setManagers(userDAO.getManagerCount());
            util.setUsers(userDAO.getUserCount());
            util.setClerk(userDAO.getClerkCount());
            util.setWarehouse(userDAO.getWarehouseManagerCount());
          
            request.setAttribute("list", list);
            request.setAttribute("util", util);
 request.setAttribute("title", "Users");
            dispatcher = request.getRequestDispatcher("/Views/Admin/user_list.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getSingleUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        
        System.out.println("get single User");
            DashboardUtil util = new DashboardUtil();
            util.setAdmin(userDAO.getAdminCount());
            util.setManagers(userDAO.getManagerCount());
            util.setUsers(userDAO.getUserCount());
            util.setClerk(userDAO.getClerkCount());
            util.setWarehouse(userDAO.getWarehouseManagerCount());
            request.setAttribute("util", util);
        String id = request.getParameter("id");
        User user = userDAO.get(Integer.parseInt(id));
        System.out.println("This is the user that we want to edit: " + user.toString());
         request.setAttribute("title", "Edit User");
        request.setAttribute("user", user);
        dispatcher = request.getRequestDispatcher("/Views/Admin/add_user.jsp");
        dispatcher.forward(request, response);

    }

   public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
 
   
   String id = request.getParameter("id");
  
        User user = userDAO.get(Integer.parseInt(id));
        if(userDAO.delete(Integer.parseInt(id))){
             request.setAttribute("title", "Delete User");
          request.setAttribute("message", "User Deleted!");
         
       }
        listUsers(request, response);

}
   public void newUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
           
       System.out.println("Add new user to database "
               + "MySQL and Postgresql");
            DashboardUtil util = new DashboardUtil(); 
            util.setAdmin(userDAO.getAdminCount());
            util.setManagers(userDAO.getManagerCount());
            util.setUsers(userDAO.getUserCount());
            util.setClerk(userDAO.getClerkCount());
            util.setWarehouse(userDAO.getWarehouseManagerCount());
            request.setAttribute("util", util);
 request.setAttribute("title", "Create New User");
    dispatcher = request.getRequestDispatcher("/Views/Admin/add_user.jsp");
           dispatcher.forward(request, response);

}

    private void listWarehouseManagers(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<User> list = userDAO.getWarehouseManagers();
            DashboardUtil util = new DashboardUtil();
            util.setAdmin(userDAO.getAdminCount());
            util.setManagers(userDAO.getManagerCount());
            util.setUsers(userDAO.getUserCount());
            util.setClerk(userDAO.getClerkCount());
            util.setWarehouse(userDAO.getWarehouseManagerCount());
          
            request.setAttribute("list", list);
            request.setAttribute("util", util);
 request.setAttribute("title", "Users");
            dispatcher = request.getRequestDispatcher("/Views/Admin/user_list.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  

    private void listClerks(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<User> list = userDAO.getClerks();
            DashboardUtil util = new DashboardUtil();
            util.setAdmin(userDAO.getAdminCount());
            util.setManagers(userDAO.getManagerCount());
            util.setUsers(userDAO.getUserCount());
            util.setClerk(userDAO.getClerkCount());
            util.setWarehouse(userDAO.getWarehouseManagerCount());
          
            request.setAttribute("list", list);
            request.setAttribute("util", util);
            request.setAttribute("title", "Users");
            dispatcher = request.getRequestDispatcher("/Views/Admin/user_list.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

    private void listManagers(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<User> list = userDAO.getManagers();
            DashboardUtil util = new DashboardUtil();
            util.setAdmin(userDAO.getAdminCount());
            util.setManagers(userDAO.getManagerCount());
            util.setUsers(userDAO.getUserCount());
            util.setClerk(userDAO.getClerkCount());
            util.setWarehouse(userDAO.getWarehouseManagerCount());
          
            request.setAttribute("list", list);
            request.setAttribute("util", util);
 request.setAttribute("title", "Users");
            dispatcher = request.getRequestDispatcher("/Views/Admin/user_list.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}






