/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.dao;

import com.farminventory.entity.Category;
import com.farminventory.entity.Product;
import com.farminventory.entity.Transaction;
import com.farminventory.util.Config;
import java.util.List;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public interface ProductDAO {
        List<Product> get();
        List<Product> getRestock();
        List<Transaction> getTrans();
        List<Transaction> getUserTransactions(String name);
        List<Transaction> countTrans();
        List<Transaction> trackSales();
    boolean  saveProduct(Product product);
   
    
    Product get(int id);
    Config getConfig();
    
    Product get(String name);
    
    boolean update(Product product);
    boolean updateConfig(Config config);
    
    boolean delete(int id);
    
    List<Category> getCategories();

    public boolean logTransaction(Transaction transaction);

    public void updateTable(Transaction transaction);
    int countProducts();

   

    public boolean saveCategory(Category cat);

    public boolean update(Category cat);

    public Category getCategory(int id);

    public boolean deleteCategory(int id);
}

