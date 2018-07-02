/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarttableassistant;

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

public class Customer 
{
    public boolean foodServed = false;
    private String customerName,customerEmail, customerTableID,foodFeedback, overallFeedback, cardNumber, pin, paymentAmount;
    private int languageFlag, itemsCount=0, foodRating, paymentMode;
    private ArrayList<Integer> selectedItems = new ArrayList<Integer>();

     public void generateTableID(String CustomerTableID)
     {
         this.customerTableID = customerTableID;
     }
     
     public String inputName(Scanner input)      //Takes customer name input
    {
        this.customerName = input.next();
        return(this.customerName);
    }
     
     public String inputEmail(Scanner input)    //Takes customer email input
     {
         this.customerEmail = input.next();
         return(this.customerEmail);
     }

     public ArrayList<Integer> chooseItems(Scanner input)   // Returns the items selected by the user
     {
         int choice;
         while(true)
         {
             if(itemsCount > 7)
                 break;
             choice = input.nextInt();
             if(choice == 0)
                 break;
             else
             {
                 selectedItems.add(choice);
                 itemsCount++;
             }
         }
         return(selectedItems);
     }
        
    public int chooseLanguage()             //User can choose any of the offered language
    {
        //Customer is storing the language preference
        Scanner input = new Scanner(System.in);
        this.languageFlag = input.nextInt();
        return(this.languageFlag);
    }
        
    public void operateTableAssistant()
    {
        
    }
    
    public String payingBill(int choice,Scanner input)
    {
        switch(choice)
        {
            case 1:
                    this.paymentMode = input.nextInt();
                    return(Integer.toString(this.paymentMode));
            case 2:
                    this.cardNumber = input.next();
                    return("");
            case 3:
                    pin = input.next();
                    return("");
            case 4:
                    this.paymentAmount = input.next();
                    return(paymentAmount);
                       
        }
        return("0");
    }
    
    
   
    
    public String feedback(int choice, Scanner input)
    {
        switch(choice)
        {
            case 1:
                    while(true)
                    {
                        this.foodRating = input.nextInt();
                        if(this.foodRating >  10 || this.foodRating < 1)
                            System.out.print("Oops! Enter again: ");
                        else 
                            return(Integer.toString(this.foodRating));                  
                    }           
            case 2:
                    this.foodFeedback = input.next();
                    return(this.foodFeedback);                 
            case 3:
                    this.overallFeedback = input.next();
                    return(this.overallFeedback);
        }
        
        return(" ");
    }
    
}
