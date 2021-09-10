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
public class Transaction {
    private int ref_number;
    private int quantity;
    private Product product;
    private User logger;
    private String  time;
    private String  loggername;
    private String  productName;
    private double subcharge;
    private double VAT;
    private double POS_charge;
    private Location delivery;
    private double totalCharge;
    private String buyer;
    private double costPrice;
    private int count;
  
    

    public Transaction() {
    }

    public int getQuantity() {
        return quantity;
    }
    public void setCostPrice(){
      this.costPrice =  this.quantity * this.product.getSelling_price();
    }

    public String getBuyer() {
        return buyer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public double getCostPrice() {
        return costPrice;
    }

    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

    public int getRef_number() {
        return ref_number;
    }

    public void setRef_number(int ref_number) {
        this.ref_number = ref_number;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getLogger() {
        return logger;
    }

    public void setLogger(User logger) {
        this.logger = logger;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getSubcharge() {
        return subcharge;
    }

    public void setSubcharge(double subcharge) {
        this.subcharge = subcharge;
    }

    public double getVAT() {
        double dVAT = (this.VAT/100)*this.costPrice;
        return dVAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public double getPOS_charge() {
        return POS_charge;
    }

    public void setPOS_charge(double POS_charge) {
        this.POS_charge = POS_charge;
    }

    public String getLoggername() {
        return loggername;
    }

    public void setLoggername(String loggername) {
        this.loggername = loggername;
    }

    public Location getDelivery() {
        return delivery;
    }

    public void setDelivery(Location delivery) {
        this.delivery = delivery;
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public double getTotalCharge2() {
        return this.totalCharge;
    }

    
   public void setSubCharge(){  
       double cost = this.product.getSelling_price()*this.quantity;
       double dVAT = (this.VAT/100)*cost;
       
       subcharge = dVAT + cost +this.delivery.getCharge();;
       
   } 
   public void setTotalCharge2(double totalCharge){
       this.totalCharge = totalCharge;
   }
  
    public void setTotalCharge() {
          this.totalCharge = getSubcharge() + this.delivery.getCharge();
    }
    

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    

    @Override
    public String toString() {
        return "Transaction{" + "ref_number=" + ref_number + ", quantity=" + quantity + ", product=" + product + ", logger=" + logger + ", time=" + time + ", subcharge=" + subcharge + ", VAT=" + VAT + ", POS_charge=" + POS_charge + ", delivery=" + delivery + ", totalCharge=" + totalCharge + '}';
    }
    
    
    
}
