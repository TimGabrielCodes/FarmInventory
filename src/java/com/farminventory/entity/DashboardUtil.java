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
public class DashboardUtil {
    private int managers;
    private int users;
    private int admin;
    private int warehouse;
    private int clerk;

        public DashboardUtil(){
            
        }
    public int getManagers() {
        return managers;
    }

    public void setManagers(int managers) {
        this.managers = managers;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }

    public int getClerk() {
        return clerk;
    }

    public void setClerk(int clerk) {
        this.clerk = clerk;
    }

    @Override
    public String toString() {
        return "DashboardUtil{" + "managers=" + managers + ", users=" + users + ", admin=" + admin + ", warehouse=" + warehouse + ", clerk=" + clerk + '}';
    }

    
    
}
