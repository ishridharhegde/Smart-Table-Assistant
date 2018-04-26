/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarttableassistant;


public class Manager 
{
    private int foodRating;
    String username, password, foodFeedback, overallFeedback;
    
    public void receiveCustomerFeedback(int foodRating, String foodFeedback, String overallFeedback, Chef chef)
    {
        this.foodRating = foodRating;
        this.foodFeedback = foodFeedback;
        this.overallFeedback = overallFeedback;
        
       this.improvise(chef);
    }
    
    public void improvise(Chef chef)
    {
        if(foodRating <= 5)
            chef.putManagerRemarks("You have to talk with me regarding the improvement of food quality");
        else
            chef.putManagerRemarks("Well done");     
    }
    
}
