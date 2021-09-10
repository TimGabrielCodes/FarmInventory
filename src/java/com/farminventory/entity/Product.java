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
public class Product {

    private int product_id;
    private String name;
    private double cost_price;
    private double selling_price;
    private int logger_id;
    private int vendor_id;
    private String category;
    private int quantity;
    private String picURL;
    private String vendorName;
    private User logger;
    private String loggerName;

    public User getLogger() {
        return logger;
    }

    public void setLogger(User logger) {
        this.logger = logger;
        this.loggerName = logger.getFullName();
    }

    public String getLoggerName() {
        this.loggerName = this.logger.getFullName();
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, double cost_price, double selling_price, int logger_id, int vendor_id, String category, int quantity) {
        this.name = name;
        this.cost_price = cost_price;
        this.selling_price = selling_price;
        this.logger_id = logger_id;
        this.vendor_id = vendor_id;
        this.category = category;
        this.quantity = quantity;
    }



    public Product(int product_id, String name, double cost_price, double selling_price, int logger_id, int vendor_id, String category, int quantity) {
        this.product_id = product_id;
        this.name = name;
        this.cost_price = cost_price;
        this.selling_price = selling_price;
        this.logger_id = logger_id;
        this.vendor_id = vendor_id;
        this.category = category;
        this.quantity = quantity;
    }

    public Product() {
           this.name = null;
                                    
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost_price() {
        return cost_price;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public void setCost_price(double cost_price) {
        this.cost_price = cost_price;
    }

    public double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(double selling_price) {
        this.selling_price = selling_price;
    }

    public int getLogger_id() {
        return logger_id;
    }

    public void setLogger_id(int logger_id) {
        this.logger_id = logger_id;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    

    public void setVendorName(String vendorName) {
       this.vendorName = vendorName;
    }

    public String getVendorName() {
        return vendorName;
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", name=" + name + ", cost_price=" + cost_price + ", selling_price=" + selling_price + ", logger_id=" + logger_id + ", vendor_id=" + vendor_id + ", category=" + category + ", quantity=" + quantity + ", picURL=" + picURL + ", vendorName=" + vendorName + ", logger=" + logger + ", loggerName=" + loggerName + '}';
    }

}
