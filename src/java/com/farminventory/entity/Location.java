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
public class Location {
    private int location_id;
    private String state;
    private double charge;

    public String getState() {
        return state;
    } 

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }
    



    public void setState(String state) {
        this.state = state;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "Location{" + "location_id=" + location_id + ", state=" + state  + ", charge=" + charge + '}';
    }
    
    
    
}
