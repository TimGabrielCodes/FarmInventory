/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.dao;

import com.farminventory.entity.DashboardUtil;
import com.farminventory.entity.User;
import com.farminventory.entity.Vendor;
import java.util.List;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public interface UserDAO {
    
    List<User> get();
    List<Vendor> getVendors();
    boolean  saveUser(User user);
    
    User get(int id);
    
    
    
    User getLogger(String email);
    
    boolean updateUser(User user);
    
    boolean delete(int id);
    
    Vendor getVendor(String name);
    Vendor getVendor(int id);
    
    boolean addVendor(Vendor vendor);
    
    boolean deleteVendor(int id);
    
    boolean update (Vendor vendor);
    
    int getUserCount();
    int getManagerCount();
    int getClerkCount();
    int getWarehouseManagerCount();
    int getAdminCount();
    int getTransactionCount(String name);
    int getProductCount(int id);
    int getTransactionCount();

    int getVendorCount();
    
    List<User> getManagers();
    List<User> getWarehouseManagers();
    List<User> getClerks();
   
 
     
    
}
