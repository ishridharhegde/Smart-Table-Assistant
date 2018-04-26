/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarttableassistant;
import java.util.*;

import java.util.concurrent.TimeUnit;

public class ServingTeam
{
    private String customerTableID;
    private boolean foodServed = false;
    private ArrayList<Integer> itemsToServe = new ArrayList<Integer>();
    
    public void serveFood(String customerTableID, Customer customer, ArrayList<Integer> itemsToServe) throws InterruptedException
    {
        this.customerTableID = customerTableID;
        this.itemsToServe = itemsToServe;
        
        //Serves food to customer by changing their food served flag
        customer.foodServed = true;  
        
        System.out.println("...............................................\nServing table id "+this.customerTableID+" with items:");
        for(int i=0; i < this.itemsToServe.size(); i++)
        {
            switch(this.itemsToServe.get(i))
            {
                case 1:
                        System.out.println("\t\tBisibele Bath");  break;
                case 2:
                        System.out.println("\t\tVangi Bath");     break;
                case 3:
                        System.out.println("\t\tRice Bath");      break;
                case 4:
                        System.out.println("\t\tPongal");         break;
                case 5:
                        System.out.println("\t\tShavige Bath");   break;
                case 6:
                        System.out.println("\t\tIdli-Vada");      break;                             
            }
        } 
        
        System.out.println("\tCUSTOMER STARTED EATING");
        waitWhileCustomerIsEating();    waitWhileCustomerIsEating();
        waitWhileCustomerIsEating();    waitWhileCustomerIsEating(); 
        waitWhileCustomerIsEating();    waitWhileCustomerIsEating();
        waitWhileCustomerIsEating();    waitWhileCustomerIsEating();
        
        System.out.print("\n");
    }
    
    
    public void waitWhileCustomerIsEating() throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(1);
        System.out.print("........");
    }
}
