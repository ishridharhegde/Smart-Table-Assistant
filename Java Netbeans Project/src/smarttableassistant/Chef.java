/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarttableassistant;
import java.util.*;

public class Chef 
{
    private ArrayList<Integer> customerOrder = new ArrayList<Integer>();
    private String customerFeedback, managerRemarks;
    
    
    public int takeOrder(ArrayList<Integer> selectedItems)
    {
        this.customerOrder = selectedItems;
        Random randomNumberGenerator = new Random();
        return(randomNumberGenerator.nextInt((1200 - 300) + 1) + 300);
    }
    
    public void notifyServingTeam(String customerTableID,Customer customer, ServingTeam servingTeam) throws InterruptedException
    {
        
        servingTeam.serveFood(customerTableID,customer,customerOrder);
    }
    
    public void receiveCustomerFeedback(String customerFeedback)
    {
        this.customerFeedback = customerFeedback;
        
    }
    
    public void putManagerRemarks(String managerRemarks)
    {
        this.managerRemarks = managerRemarks;
    }
    
}
