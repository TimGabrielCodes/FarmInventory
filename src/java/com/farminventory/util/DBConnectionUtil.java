/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public class DBConnectionUtil {
    //Define Database properties
    
    private static final String URL = "jdbc:mysql://localhost:3306/inventorydb?serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "%310594%";
    private static Connection con  = null;
    
    
    //Static method to get connection
    
    public static Connection openConnection() throws ClassNotFoundException, SQLException{
        //Check the connection
        if(con != null){
            return con;
        }
        else{
        
                //load the driver
                Class.forName(DRIVER);
                
                //Get the connection
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                //Return the connection
                return con;
           
        }
    }
    
}

