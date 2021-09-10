/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.dao;

import com.farminventory.entity.Location;
import com.farminventory.util.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public class LocationDAOImpl implements LocationDAO {
    
   

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<Location> list = null;

    Location location = null;

    PreparedStatement preparedStmt = null;

    @Override
    public List<Location> get() {
        try {
            list = new ArrayList<Location>();
            String sql = "select * from delivery_charges";
            connection  = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
                location = new Location();
                location.setState(resultSet.getString("state"));
                location.setLocation_id(resultSet.getInt("id"));
            //    location.setArea(resultSet.getString("area"));
                location.setCharge(resultSet.getDouble("charge"));
                
                list.add(location);
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean update(Location location) {
         boolean flag;
         try {
          
            String sql = "update delivery_charges set charge ="+ location.getCharge() +",state = '" +location.getState()+"' where  id=" +location.getLocation_id();
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            flag = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
           flag = false;
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            flag = false;
        }
        return flag;
    }

    @Override
    public Location getLocation(int id) {
              Location location = null;
       try{
           location = new Location();
           String sql = "SELECT * FROM delivery_charges  WHERE id=" + id;
           connection = DBConnectionUtil.openConnection();
           statement = connection.createStatement();
           resultSet = statement.executeQuery(sql);
           
           while (resultSet.next()){
               System.out.println(resultSet.getDouble("charge"));
               System.out.println(resultSet.getString("state"));
             location.setCharge(resultSet.getDouble("charge"));
             location.setState(resultSet.getString("state"));
//             location.setArea(resultSet.getString("area"));
             location.setLocation_id(resultSet.getInt("id"));
           }
           
       }
           catch(SQLException e){
               e.printStackTrace();
                   
                   } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       //System.out.println(user.toString());
       return location;
    }
    @Override
    public Location getLocationByState(String state) {
              Location location = null;
       try{
           location = new Location();
           String sql = "SELECT * FROM delivery_charges  WHERE state='" + state +"'";
           connection = DBConnectionUtil.openConnection();
           statement = connection.createStatement();
           resultSet = statement.executeQuery(sql);
           
           while (resultSet.next()){
               System.out.println(resultSet.getDouble("charge"));
               System.out.println(resultSet.getString("state"));
             location.setCharge(resultSet.getDouble("charge"));
             location.setState(resultSet.getString("state"));
           //  location.setArea(resultSet.getString("area"));
             location.setLocation_id(resultSet.getInt("id"));
           }
           
       }
           catch(SQLException e){
               e.printStackTrace();
                   
                   } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       //System.out.println(user.toString());
       return location;
    }

    @Override
    public boolean save(Location location) {
        boolean flag = false;
        try {
           
            String sql = "insert into delivery_charges(state, charge) "
                    + "values(?,?)";
            
            connection = DBConnectionUtil.openConnection();
            
            preparedStmt = connection.prepareStatement(sql);
            
            preparedStmt.setString(1, location.getState());
            //preparedStmt.setString(2, location.getArea());
            preparedStmt.setDouble(2, location.getCharge());
            preparedStmt.executeUpdate();
            flag = true;
            
            
            
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        return flag;
    }

    @Override
    public boolean delete(int id) {
              boolean flag = false;
        try{
            String sql = "DELETE FROM delivery_charges WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
            
        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }


}