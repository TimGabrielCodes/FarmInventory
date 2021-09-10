/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.util;
/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public class Config {
    double POS;
    int id;
    double VAT;
    Integer restockLevel;
    String lastModifiedBy;

    public Config() {
    }

    public double getPOS() {
        return POS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPOS(double POS) {
        this.POS = POS;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getRestockLevel() {
        return restockLevel;
    }

    public void setRestockLevel(Integer restockLevel) {
        this.restockLevel = restockLevel;
    }

    @Override
    public String toString() {
        return "Config{" + "POS=" + POS + ", id=" + id + ", VAT=" + VAT + ", restockLevel=" + restockLevel + ", lastModifiedBy=" + lastModifiedBy + '}';
    }

  
    
    

}

