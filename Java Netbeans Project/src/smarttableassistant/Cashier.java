/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarttableassistant;

public class Cashier 
{
    private String tableID;
    private int amount;
    public void customerPayingCash(String tableID, int amount)
    {
        this.tableID = tableID;
        this.amount = amount;
    }
}
