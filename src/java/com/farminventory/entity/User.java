/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.entity;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public class User {
    private int user_id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String email;
    private boolean admin;
    private String role;
    private String fullName;
    public User() {
    }

    public User(int user_id, String first_name, String last_name, String username, String password, String email, boolean is_admin) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = is_admin;
  
    }

    public User(int user_id, String first_name, String last_name, String email, boolean is_admin) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.admin = is_admin;
     
    }
    
    

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
 

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

  
    public String getFullName() {
        return  this.fullName = this.first_name + "  " + this.last_name;
    }

    public void setFullName() {
        this.fullName = this.first_name + "  " + this.last_name;
    }
    

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", username=" + username + ", password=" + password + ", email=" + email + ", role=" + role + '}';
    }
    
    
    
    
}
