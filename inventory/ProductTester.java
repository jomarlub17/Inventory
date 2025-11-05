/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;
import java.util.Scanner;


/**
 *
 * @author jomarlubin
 */
public class ProductTester {
  
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int maxSize,menuChoice;
        maxSize = getNumProducts(in);
        
        System.out.println();
        if(maxSize == 0)
        {
            System.out.println("No products required!");
        }
        else
        {
            Product[] products = new Product[maxSize];
            addToInventory(products, in, maxSize);    
            do{
                menuChoice = getMenuOption(in);
                executeMenuChoice(menuChoice, products, in);
            }while(menuChoice!=0);
        }
    }
    //9
    public static void executeMenuChoice(int menuChoice, Product[] products, Scanner in){
        switch(menuChoice) {
            case 1: System.out.println("view product list\n" + "add stock\n" + "Deduct stock\n" +"Discontinue stock\n");
                    displayInventory(products);
                    break;
            case 2: System.out.println("view product list\n" + "add stock\n" + "Deduct stock\n" +"Discontinue stock\n");
                    addInventory(products, in);
                    break;
            case 3: System.out.println("view product list\n" + "add stock\n" + "Deduct stock\n" +"Discontinue stock\n");
                    deductInventory(products, in);
                    break;
            case 4: System.out.println("view product list\n" + "add stock\n" + "Deduct stock\n" +"Discontinue stock\n");
                    discontinueInventory(products, in);
                    break;
            case 0: break;
                  
        }
    }
   
    //8
     public static void discontinueInventory(Product[] products, Scanner in){
        int productChoice;
        productChoice = getProductNumber(products, in);
        products[productChoice].setActive(false);
    }
    
    //7 debugged
    public static void deductInventory(Product[] products, Scanner in){
        int productChoice;
        productChoice = getProductNumber(products, in);
        int updateValue = -1;
        try{
            System.out.println("How many products do you want to deduct?");
            updateValue  = in.nextInt();
            while(updateValue<0 || updateValue > products[productChoice].getUnitsInStock()){
                System.out.println("Incorrect! value must 0 ore greater, try again:");
                updateValue = in.nextInt();
            }
            
        }
        catch(Exception e){
            System.out.println("Incorrecty Data type");
        }
        
        products[productChoice].deductFromInventory(updateValue);
    }
    
    //6 debugged
    public static void addInventory(Product[] products, Scanner in){
        int productChoice;
        int updateValue = -1;
        productChoice = getProductNumber(products, in);
        try{
            System.out.println("How many products do you want to add?");
            updateValue = in.nextInt();
            while(updateValue <0){
                System.out.println("only positve numbers allowed, try again: ");
                updateValue = in.nextInt();   
        }
        }
        catch(Exception e){
            System.out.println("Incorrect data type");
        }
        
          products[productChoice].addToInventory(updateValue);
        
            
    }
    
    //5 debugged
    public static int getProductNumber(Product[] products, Scanner in){
        int productChoice = -1;
        for(int i = 0; i< products.length; i++){
            
            System.out.println("product index: " + i );
            System.out.println("product name: " + products[i].getName()+ "\n" ); 
            
        }
         try{
            in.nextLine();
            System.out.println("choose your product: ");
            productChoice = in.nextInt();
            while(productChoice <0 || productChoice>(products.length -1)){
                System.out.println("Incorrect input try again (choose index #)");
                productChoice = in.nextInt();
            }
            }
            catch(Exception ArrayIndexOutOfBoundsException){
               System.out.println("Incorrect data type");
               
            }
            
           
        return productChoice;
    }
   
    //4
     public static int getMenuOption(Scanner in){
        in.nextLine();
        int menuOption = -1;
         System.out.println("1. View Inventory \n" +
                           "2. Add Stock \n" + 
                           "3. Deduct Stock \n" +
                           "4. Discontinue product \n" +
                           "0. Exit \n" +
                           "Please enter a menu option: ");
        menuOption = in.nextInt();
        while(menuOption<0 && menuOption>4){
             System.out.println("Try again, choose between 0 and 4");
             System.out.println("1. View Inventory \n" +
                                "2. Add Stock \n" + 
                                "3. Deduct Stock \n" +
                                "4. Discontinue product \n" +
                                "0. Exit \n" +
                                "Please enter a menu option: ");
             menuOption = in.nextInt();
             
        }
        return menuOption;
    }  
    
    
    //3
    public static int getNumProducts(Scanner in){
         int maxSize = -1;
        System.out.println("Enter the number of products you would like to add \n" +
                           "Enter 0 (zero) if you do not wish to add products:  ");
        maxSize = in.nextInt();
        try{
            while(maxSize < 0){
                System.out.println("Incorrect value entered");
                System.out.println("Enter the number of products you would like to add \n" +
                           "Enter 0 (zero) if you do not wish to add products:  ");
                maxSize = in.nextInt();
        }    
        }
        catch(Exception InputMismatchException) {
            System.out.println("Incorrect data type entered");
            in.nextLine();
        }
        return maxSize;
    }
    //2
    public static void addToInventory(Product[] products, Scanner in, int m){
        int tempNumber;
        String tempName;
        int tempQty;
        double tempPrice;
       
       for(int i = 0; i < m ; i++){
               in.nextLine();  
                //prompt the user to values to initialize the variables
                System.out.println("Enter the product's item number: ");
                tempNumber = in.nextInt();
                System.out.println("Enter the product's name: ");
                tempName = in.next();
                System.out.println("Enter the product's quantity in stock: ");
                tempQty = in.nextInt();
                System.out.println("Enter the product's price: ");
                tempPrice = in.nextDouble();
                products[i] = new Product(tempNumber, tempName, tempQty, tempPrice); 
                
            }
       
                
    }
    //1
    public static void displayInventory(Product[] products){
         for(Product each : products) {
            System.out.println(each.toString());
        }
    }
   }
