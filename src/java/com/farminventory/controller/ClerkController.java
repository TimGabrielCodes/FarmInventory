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
import com.farminventory.entity.Product;
import com.farminventory.entity.Transaction;
import com.farminventory.entity.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
@MultipartConfig
public class ClerkController extends HttpServlet {

    ProductDAO productDAO = null;
    UserDAO userDAO = null;
    RequestDispatcher dispatcher = null;
    Product product = null;
    List<Category> categorylist = null;
    String fileUrl;

    public ClerkController() {
        productDAO = new ProductDAOImpl();
        userDAO = new UserDAOImpl();

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "DASHBOARD";

        }
        switch (action) {
            case "LIST":
                warehouse(request, response);
                break;
            case "ADD":
                addProducts(request, response);
                break;
            case "SELL":
                makeTransaction(request, response);
                break;
            case "TRANSACTIONS":
                viewTransactions(request, response);
                break;
            case "DASHBOARD":
               clerkDashBoard(request, response);
                break;
            default:
                clerkDashBoard(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String product_id = request.getParameter("product_id");
        String name = request.getParameter("product_name");
        Double cost_price = Double.parseDouble(request.getParameter("cost_price"));
        Double selling_price = Double.parseDouble(request.getParameter("selling_price"));
        String category = request.getParameter("dcategory");

        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String vendor_name = request.getParameter("vendor");
        String logger_email = (String) request.getSession().getAttribute("email");
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = getServletContext().getInitParameter("file_upload") + Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            System.out.println("Catalina base is" + getServletContext().getInitParameter("file_upload"));
        product = new Product();
        userDAO = new UserDAOImpl();

        User logger = userDAO.getLogger(logger_email);

        product.setCategory(category);
        product.setCost_price(cost_price);
        product.setLogger_id(logger.getUser_id());
        product.setName(name);
        product.setQuantity(quantity);
        product.setSelling_price(selling_price);
        product.setPicURL(fileName);
        product.setVendorName(vendor_name);
        System.out.println("Id from client" + request.getParameter("product_id"));
        if (product_id.isEmpty()) {
            if (productDAO.saveProduct(product)) {
                saveFile(request, response);
                request.setAttribute("message", "Product Added Successfully");
                System.out.println("Product to be saved" + product.toString());

            }
        }else {

                request.setAttribute("message", "Error ");
            }
        

        warehouse(request, response);
        

    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void clerkDashBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
           // List<Product> list = productDAO.get();
            ProductDAO pr = new ProductDAOImpl();
            UserDAO us = new UserDAOImpl();
            int productCount= pr.countProducts();
            int transCount = us.getTransactionCount(user.getFullName());
            int products =  us.getProductCount(user.getUser_id());
             List<Transaction> list = productDAO.getUserTransactions(user.getFullName());
   
            request.setAttribute("list", list);
      
            request.setAttribute("stockCount", productCount);
            request.setAttribute("transCount", transCount);
            request.setAttribute("products", products);
            request.setAttribute("list", list);
            request.setAttribute("title", "Dashboard");
            dispatcher = request.getRequestDispatcher("/Views/Clerk/Dashboard.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void warehouse(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<Product> list = productDAO.get();

            request.setAttribute("list", list);
            request.setAttribute("title", "Inventory Products List");
            dispatcher = request.getRequestDispatcher("/Views/Clerk/Stock.jsp");
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public void addProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Add Products");
        dispatcher = request.getRequestDispatcher("/Views/Clerk/addProduct.jsp");
        dispatcher.forward(request, response);

    }
   private void makeTransaction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
         request.setAttribute("title", "Make Transaction");
          dispatcher = request.getRequestDispatcher("/Views/Clerk/MakeTransaction.jsp");
           dispatcher.forward(request, response);
           
    }
   private void viewTransactions(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
 ProductDAO productDAO = new ProductDAOImpl();
       //System.out.println(user.getFullName());
 List<Transaction> list = productDAO.getUserTransactions(user.getFullName());
   
       
         request.setAttribute("title", "Make Transaction");
         request.setAttribute("list", list);
          dispatcher = request.getRequestDispatcher("/Views/Clerk/ViewTransactions.jsp");
           dispatcher.forward(request, response);
           
    }

    public void saveFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = getServletContext().getInitParameter("file_upload") + Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

        InputStream fileContent = filePart.getInputStream();
        File uploads = new File(fileName);

        System.out.println("FIle should be saved at" + uploads.getAbsolutePath());

        copyInputStreamToFile(fileContent, uploads);

    }

    private static void copyInputStreamToFile(InputStream inputStream, File file)
            throws IOException {

        try (FileOutputStream outputStream = new FileOutputStream(file)) {

            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
    }
}

