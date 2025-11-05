/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

/**
 *
 * @author jomarlubin
 */
public class Product {
    //Instance field declaratins.
    private int itemNumber;
    private String productName;
    private  int unitsInStock;
    private double price;
    private boolean active;
    //default constructor       
    public Product(){   
    }
    public Product(int number, String name, int qty, double price){
      this.itemNumber = number;
      this.productName = name;
      this.unitsInStock = qty;
      this.price = price;
      this.active = true;
    }
    public  int addToInventory(int quantity){
       return unitsInStock = unitsInStock + quantity;
    }
    public int deductFromInventory(int quantity){
       return unitsInStock = unitsInStock - quantity;
    }
    
    //gets and returns Item number because its private
    public int getItemNumber(){
        return itemNumber;
    }
    //gets and returns phone because its private
    public String getName(){
        return productName;
    }
    // gets and returns units in stock because its private
    public int getUnitsInStock(){
        return unitsInStock;
    }
    // gets and returns the price because its private
    public double getPrice(){
        return price;
    }
    // gets and returns the value for active because its private
    public boolean getActive(){
        return active;
    }
    // sets a value for item number
    public void setItemNumber( int number){
        itemNumber = number;
    }
    // sets a value for phone
    public void setName(String name){
        productName  = name;
    }
    // sets a value for the units in stock
    public void setUnitsInStock(int qty){
        unitsInStock = qty;
    }
    // sets a value for the price
    public void setPrice(int p){
        price = p;
    }
    //Sets  a value for the status
    public void setActive(boolean a){
        active = a;
    }
    //method to get inventory value
    public double getInventoryValue(){
        return unitsInStock * price;
    }
    //overide toString method
    public String toString(){
        
        return "Item Number      : " + itemNumber + "\n" +
               "Name             : " + productName + "\n" +
               "Quantity in stock: " + unitsInStock +"\n" +
               "Price            : " + price + "$" + "\n" + 
               "Stock value      : " + getInventoryValue() + "\n" +
               "Product status   : " + (this.active?"Active":"Discontinued") +"\n";
        
    }
    
    
}
