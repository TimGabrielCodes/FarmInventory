/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.dao;

import com.farminventory.entity.Login;
import com.farminventory.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public class LoginDAOImpl implements LoginDAO{

    @Override
    public String authenticate(Login login) {
        String sql = "select * from user where email=? and password =?"; 
        
        try{
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, login.getEmail());
           stmt.setString(2, login.getPassword());
           
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                return "true";
            } else{
                return "false";
                
            }
           
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            
        }
        return "error";
    }
    
}
