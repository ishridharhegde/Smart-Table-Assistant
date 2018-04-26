/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarttableassistant;

import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

public class SmartTableAssistant extends JFrame
{
    private int languageFlag, waitingTime, foodRating, customerBill=0, paymentMode;
    private int onlinePaymentFlag = 0;
    private String customerName,customerEmail, customerTableID;
    private ArrayList<Integer> selectedItems = new ArrayList<Integer>();
    private String foodFeedback,overallFeedback;

    
    
    public void haltSomeTime() throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(1);
        System.out.print("..."); 
    }
    
    
    public String randomIDgenerator()
    {
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder sb = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 8; i++) 
        {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        System.out.print(sb);
          return(sb.toString());
    }
    
    
    //Changes the interface language as per customer's needs
     public void changeLanguage(Customer customer) throws InputMismatchException
    {
        Scanner input = new Scanner(System.in);
        boolean validInput = false;
        
        //Generate unique table ID
        customerTableID = randomIDgenerator();
        customer.generateTableID(customerTableID);
        
        //Ask customer to choose language
        System.out.println("Choose any one of the language:");
        System.out.println("1. English\n2. Kannada\n3. Telugu\n5. Tamil");
        System.out.print("\t$ ");

        //To take the language preference input from the user
        while(!validInput)
        {
            try
            {
                 //Take language preference from custoemer class
                this.languageFlag = customer.chooseLanguage();
            
                if(this.languageFlag<1 || this.languageFlag>5)
                {
                    System.out.println("\tWrong input. Enter again !");
                    System.out.print("\t$ ");
                }
                else
                {
                    validInput = true;
                }
            } 
            catch(InputMismatchException e)
            {
                System.out.print("\tEnter an integer !! Please try again !\n\t$ ");
            }
        }        
    }
    
    public final void menuInEnglish(Customer customer, Chef chef,ServingTeam servingTeam) throws InterruptedException
    {
        Scanner input = new Scanner(System.in);
        char choice;
        
        System.out.println("----------------------------------------------------");
        
        //Take user details
        System.out.print("Please enter your details:\n\t*Name:  ");
        this.customerName = customer.inputName(input);
        System.out.print("\t*E-mail:  ");
        this.customerEmail = customer.inputEmail(input);
        
        //Display menu in english
        System.out.println("Choose your order from the menu below: \n\t(Note: Choose any number of items you need.");
                System.out.println("\t        If you one item in multiple quantities,enter the its index number that many times. Then enter \"0\" at the end");
        System.out.println("1.Bisibele Bath - ?50\t\t2.Vangi Bath - ?70\n3.Rice Bath - ?50\t\t4.Pongal - ?80\n5.Shavige Bath - ?60\t\t6.Idli-Vada - ?60");
        System.out.print("\t$ ");
        while(true)
        {  
            selectedItems = customer.chooseItems(input);
        
            waitingTime = chef.takeOrder(selectedItems);
        
            System.out.println("\n\tPLEASE WAIT FOR "+waitingTime+" SECONDS\n");
            haltSomeTime(); haltSomeTime(); haltSomeTime(); haltSomeTime(); haltSomeTime(); haltSomeTime();
        
            //Remind chef to notify serving team as to serve the food to customers
            chef.notifyServingTeam(customerTableID, customer, servingTeam);
            
            System.out.print("DO YOU WANT TO ORDER AGAIN ? [Y/N]:  ");
            choice = input.next().charAt(0);
            Character ch = Character.toUpperCase(choice);
            
            if(ch.equals('N'))
                     break;                  
        }           
        
    }  
    
    public final void menuInKannada(Customer customer, Chef chef,ServingTeam servingTeam)throws InterruptedException
    {
        Scanner input = new Scanner(System.in);
        char choice;
        
        System.out.println("----------------------------------------------------");
        
        //Take user details
        System.out.print("Nimma vivaragalannu namudisi:\n\t*Name:  ");
        this.customerName = customer.inputName(input);
        System.out.print("\t*E-mail:  ");
        this.customerEmail = customer.inputEmail(input);
        
        //Display menu in english
        System.out.println("Kelagina menuvininda nimma adeshavannu ayke madi: \n\t(Suchane: Nimage yavude item estu beko ayke madi.");
                System.out.println("\t        Nimage onde item jasti bekiddalli astu sala aa number annu enter madi. Mattu konege \"0\" annu enter madi");
        System.out.println("1.Bisibele Bath - ?50\t\t2.Vangi Bath - ?70\n3.Rice Bath - ?50\t\t4.Pongal - ?80\n5.Shavige Bath - ?60\t\t6.Idli-Vada - ?60");
        System.out.print("\t$ ");
        while(true)
        {  
            selectedItems = customer.chooseItems(input);
        
            waitingTime = chef.takeOrder(selectedItems);
        
            System.out.println("\n\tDAYAVITTU "+waitingTime+" SECONDS KAYIRI\n");
            haltSomeTime(); haltSomeTime(); haltSomeTime(); haltSomeTime(); haltSomeTime(); haltSomeTime();
        
            //Remind chef to notify serving team as to serve the food to customers
            chef.notifyServingTeam(customerTableID, customer, servingTeam);
            
            System.out.print("NIVU MATTE ORDER BAYASUTTIRA ? [Y/N]:  ");
            choice = input.next().charAt(0);
            Character ch = Character.toUpperCase(choice);
            
            if(ch.equals('N'))
                     break;                  
        }
    }
    
    
    public final void menuInTelugu(Customer customer, Chef chef,ServingTeam servingTeam)throws InterruptedException
    {
         Scanner input = new Scanner(System.in);
        char choice;
        
        System.out.println("----------------------------------------------------");
        
        //Take user details
        System.out.print("Mi Vivaramulu teliya parachandi:\n\t*Name:  ");
        this.customerName = customer.inputName(input);
        System.out.print("\t*E-mail:  ");
        this.customerEmail = customer.inputEmail(input);
        
        //Display menu in english
        System.out.println("Diguva menu nundi mi orderni enchukondi: \n\t(Gamanika: Miku avasaramaina amshala sankyanu enchukondi.");
                System.out.println("\t        Miku bahula parimanalu korukunte, dani index sankhyanu aneka sarlu namodu cheyyandi. Appudu mugimpulo \"0\" namodu cheyyandi");
        System.out.println("1.Bisibele Bath - ?50\t\t2.Vangi Bath - ?70\n3.Rice Bath - ?50\t\t4.Pongal - ?80\n5.Shavige Bath - ?60\t\t6.Idli-Vada - ?60");
        System.out.print("\t$ ");
        while(true)
        {  
            selectedItems = customer.chooseItems(input);
        
            waitingTime = chef.takeOrder(selectedItems);
        
            System.out.println("\n\tDAYACHESI "+waitingTime+" SECANULA VARAKU VECHI VUNDANDI\n");
            haltSomeTime(); haltSomeTime(); haltSomeTime(); haltSomeTime(); haltSomeTime(); haltSomeTime();
        
            //Remind chef to notify serving team as to serve the food to customers
            chef.notifyServingTeam(customerTableID, customer, servingTeam);
            
            System.out.print("MIRU MALLI ORDER CHEYYALANUKUNTUNNARA ? [Y/N]:  ");
            choice = input.next().charAt(0);
            Character ch = Character.toUpperCase(choice);
            
            if(ch.equals('N'))
                     break; 
    }
    }    
public final void menuInTamil(Customer customer, Chef chef,ServingTeam servingTeam)throws InterruptedException
{
        Scanner input = new Scanner(System.in);
        char choice;
        
        System.out.println("----------------------------------------------------");
        
        //Take user details
        System.out.print("Unkal vivarankalai aluthavum:\n\t*Peyar:  ");
        this.customerName = customer.inputName(input);
        System.out.print("\t*E-mail:  ");
        this.customerEmail = customer.inputEmail(input);
        
        //Display menu in english
        System.out.println("kile ulla menuvillirunthu unkal ordererai tervuseyyavum: \n\t(Kutippu: Unkalluku thevayana yeralamana prutkalai thernthu edukavum");
                System.out.println("\t        Oru porul neraya dhadavai thevai pattal, athanai murai andha yennai aluthavum. Athakku piragu \"0\" aluthavum");
        System.out.println("1.Bisibele Bath - ?50\t\t2.Vangi Bath - ?70\n3.Rice Bath - ?50\t\t4.Pongal - ?80\n5.Shavige Bath - ?60\t\t6.Idli-Vada - ?60");
        System.out.print("\t$ ");
        while(true)
        {  
            selectedItems = customer.chooseItems(input);
        
            waitingTime = chef.takeOrder(selectedItems);
        
            System.out.println("\n\tDhayavu seyadhu "+waitingTime+" vinatikal kaathitukkavum\n");
            haltSomeTime(); haltSomeTime(); haltSomeTime(); haltSomeTime(); haltSomeTime(); haltSomeTime();
        
            //Remind chef to notify serving team as to serve the food to customers
            chef.notifyServingTeam(customerTableID, customer, servingTeam);
            
            System.out.print("Meendum order seyya virumbareerkala ? [Y/N]:  ");
            choice = input.next().charAt(0);
            Character ch = Character.toUpperCase(choice);
            
            if(ch.equals('N'))
                     break;                  
        }
    }
   
   
    public void placingOrder(Customer customer, Chef chef,ServingTeam servingTeam) throws InterruptedException
    {
        switch(this.languageFlag)
        {
            case 1:
                    this.menuInEnglish(customer,chef,servingTeam);
                    break;
            case 2:
                    this.menuInKannada(customer,chef,servingTeam);
                    break;
            case 3:
                    this.menuInTelugu(customer,chef,servingTeam);
                    break;
            case 4:
                    this.menuInTamil(customer,chef,servingTeam);
                    break;
        }
    }
    
    public void feedback(Chef chef,Customer customer,Manager manager)
    {
        Scanner input = new Scanner(System.in);
        switch(this.languageFlag)
        {
            case 1:
                    this.feedbackInEnglish(input, chef, customer,manager);
                    break;
            case 2:
                    this.feedbackInKannada(input, chef, customer,manager);
                    break;
            case 3:
                    this.feedbackInTelugu(input, chef, customer,manager);
                    break;
            case 4:
                    this.feedbackInTamil(input, chef, customer,manager);
                    break;    
        }
    }
    
    public void feedbackInEnglish(Scanner input, Chef chef,Customer customer,Manager manager)
    {
        System.out.println("----------------------------------------------------");
        
        System.out.println("Dear customer, thank you for choosing our hotel.\nIn order to upgrade our services, we expect feedbacks from  our customers.");
        
        //Take food rating
        System.out.print("Please rate the food from 1 to 10: ");
        foodRating = Integer.parseInt(customer.feedback(1, input));
        
        //Take food feedback
        System.out.print("Please your feedback regarding the food quality here:\n\t$ ");
        this.foodFeedback = customer.feedback(2, input);
       
        //Take overall feedback
        System.out.print("Please leave your feedback for the overall experience of the hotel:\n\t$ ");
        this.overallFeedback = customer.feedback(3, input);
        
        //Forwarding food feedback to chef and both overall & food feedback to manager
        chef.receiveCustomerFeedback(foodFeedback);
        manager.receiveCustomerFeedback(foodRating,foodFeedback,overallFeedback,chef);
     
        
        System.out.println("\n Thank you for the precious feedback. Now you can move on for payment. ");
        System.out.println("----------------------------------------------------");
    
    }
    
    public void feedbackInKannada(Scanner input, Chef chef,Customer customer,Manager manager)
    {
        System.out.println("----------------------------------------------------");
        
        System.out.println("Priya grahaka, namma hotel annu ayke madidakkagi dhanyavadagalu.\nNamma sevegalannu upgrade madalu navu namma grahakara pratikriyeyannu niriksisutteve.");
        
        //Take food rating
        System.out.print("Dayavittu aharavannu 1 rinda 10 ravarege rate madi: ");
        foodRating = Integer.parseInt(customer.feedback(1, input));
        
        //Take food feedback
        System.out.print("Illi aharada gunamattada bagge nimma pratikriyeyannu irisi:\n\t$ ");
        this.foodFeedback = customer.feedback(2, input);
       
        //Take overall feedback
        System.out.print("Sthalada ottare anubavada bagge nimma pratikriyeyannu bittukodi:\n\t$ ");
        this.overallFeedback = customer.feedback(3, input);
        
        //Forwarding food feedback to chef and both overall & food feedback to manager
        chef.receiveCustomerFeedback(foodFeedback);
        manager.receiveCustomerFeedback(foodRating,foodFeedback,overallFeedback,chef);
     
        
        System.out.println("\n Nimma amulya pratikriyegagi dhanyavadagalu. Iga nivu pavatigagi chalisabahudu. ");
        System.out.println("----------------------------------------------------");
    }
    
    public void feedbackInTelugu(Scanner input, Chef chef,Customer customer,Manager manager)
    {
         System.out.println("----------------------------------------------------");
        
        System.out.println("Priyamaina customer, meeru maa hotelnu enchukunnanduku dhanyavaadalu.\nMa sevalanu upgrade cheyyadaniki, memu ma kastamarla nundi abhiprayalanu asisthunnamu.");
        
        //Take food rating
        System.out.print("Dayachesi 1 nundi 10 varaku aaharanni rate cheyyandi: ");
        foodRating = Integer.parseInt(customer.feedback(1, input));
        
        //Take food feedback
        System.out.print("Ikkadi aahara nanyathaku sambhandhinchi mii feedback ivvandi:\n\t$ ");
        this.foodFeedback = customer.feedback(2, input);
       
        //Take overall feedback
        System.out.print("Dayachesi hotel yokka motham anubhavaniki mi abhipraayanni teliya cheyandi:\n\t$ ");
        this.overallFeedback = customer.feedback(3, input);
        
        //Forwarding food feedback to chef and both overall & food feedback to manager
        chef.receiveCustomerFeedback(foodFeedback);
        manager.receiveCustomerFeedback(foodRating,foodFeedback,overallFeedback,chef);
     
        
        System.out.println("\n Viluvaina feedback ku dhanyavaadhalu. Ippudu miru chellimpu kosam vellachu. ");
        System.out.println("----------------------------------------------------");
    }
    
    public void feedbackInTamil(Scanner input, Chef chef,Customer customer,Manager manager)
    {
            System.out.println("----------------------------------------------------");
        
        System.out.println("Vitikkai aalar, yengal hotelai therntheduthadhukku nandri.\nEnkal sevaigalai mempatuthavadhukku, vatikkaiaalarkaliranthu karuthukkalai ethirpaakirom.");
        
        //Take food rating
        System.out.print("1 mudhal 10 varai unavukku madipengalai kodukavaum: ");
        foodRating = Integer.parseInt(customer.feedback(1, input));
        
        //Take food feedback
        System.out.print("Inge unavu tharam pathiya unkal karutthakali aluthavum:\n\t$ ");
        this.foodFeedback = customer.feedback(2, input);
       
        //Take overall feedback
        System.out.print("Indha hotelin ottumotha tharam pathiya unkal karuthukalai aluthavum\n\t$ ");
        this.overallFeedback = customer.feedback(3, input);
        
        //Forwarding food feedback to chef and both overall & food feedback to manager
        chef.receiveCustomerFeedback(foodFeedback);
        manager.receiveCustomerFeedback(foodRating,foodFeedback,overallFeedback,chef);
     
        
        System.out.println("\n Vilaimathipana karuthukalukku nandri. Ippothu neenkal kattanam sellutha mudiyum ");
        System.out.println("----------------------------------------------------");    
    }
    
    
    public void billPayment(Customer customer, Cashier cashier)
    {
        Scanner input = new Scanner(System.in);
        switch(this.languageFlag)
        {
            case 1:
                    this.billPaymentInEnglish(customer,input,cashier);
                    break;
            case 2:
                    this.billPaymentInKannada(customer,input,cashier);
                    break;
            case 3:
                    this.billPaymentInTelugu(customer,input,cashier);
                    break;
            case 4:
                    this.billPaymentInTamil(customer,input,cashier);
                    break;    
        }
    }
    
    public void billPaymentInEnglish(Customer customer,Scanner input,Cashier cashier) 
    {     
        System.out.println("\t\tBILL PAYMENT ");
        for(int i=0; i < selectedItems.size(); i++)
        {
            switch(this.selectedItems.get(i))
            {
                case 1:
                        this.customerBill+=50;
                        break;
                case 2:
                        this.customerBill+=70;
                        break;
                case 3:
                        this.customerBill+=50;
                        break;
                case 4:
                        this.customerBill+=80;
                        break;
                 case 5:
                        this.customerBill+=60;
                        break;
                case 6:
                        this.customerBill+=60;
                        break;         
            }
        }
        System.out.println("You bill is ? "+customerBill+".00.");
        System.out.println("How would you like to pay the bill ? Choose any one option.");
        System.out.println("\t1. Debit/Credit Card\n\t2. Cash Payment");
        this.paymentMode = Integer.parseInt(customer.payingBill(1, input));
        
        if(this.paymentMode==1)
        {
            System.out.println(" WE ARE TRANSFERRING YOU TO BANK PORTAL.\nNote: We do not store your payment information");
            
            System.out.println("----------------------------------------------------");
            
            while(true)
            {
                if(onlinePaymentFlag == 1)
                    break;
                System.out.print("Enter card number: ");
                String dummy = customer.payingBill(2, input);
                System.out.print("Enter pin: ");
                    dummy = customer.payingBill(3, input);
                System.out.print("Enter the amount: ");
                    dummy = customer.payingBill(4, input).toString();
                    
                //Checking if the payed amount is less than the bull amount, we have ask customer to pay again    
                if(Integer.parseInt(dummy) < this.customerBill)
                    onlinePaymentFlag=0;
                else
                    onlinePaymentFlag = 1;
            
                System.out.println("----------------------------------------------------");

                      
                if(this.onlinePaymentFlag==1)
                    System.out.println(".........\n\tPayment Successful.");
                else
                    System.out.println("Transaction error ! Try again.");  
            }  
        }
        else
        {
            System.out.println("Please pay the bill in cash to the cashier &\n\t don't forget to collect the acknowledgment.");
            
            cashier.customerPayingCash(customerTableID,customerBill);
            
        }
            
    }
    
    public void billPaymentInKannada(Customer customer,Scanner input,Cashier cashier)
    {
       System.out.println("\t\tBILL PAAVATI ");
        for(int i=0; i < selectedItems.size(); i++)
        {
            switch(this.selectedItems.get(i))
            {
                case 1:
                        this.customerBill+=50;
                        break;
                case 2:
                        this.customerBill+=70;
                        break;
                case 3:
                        this.customerBill+=50;
                        break;
                case 4:
                        this.customerBill+=80;
                        break;
                 case 5:
                        this.customerBill+=60;
                        break;
                case 6:
                        this.customerBill+=60;
                        break;         
            }
        }
        System.out.println("Nimma bill ? "+customerBill+".00.");
        System.out.println("Nivu bill annu hege paavatisuttiri ? Yavude ondu aykeyannu arisi.");
        System.out.println("\t1. Debit/Credit Card\n\t2. Cash Payment");
        this.paymentMode = Integer.parseInt(customer.payingBill(1, input));
        
        if(this.paymentMode==1)
        {
            System.out.println(" NAVU NIMMANNU BANK PORTALGE VARGAYISUTTIDDEVE.\nSuchane: Nimma paavatiya mahitiyannu navu sangrahisuvudilla");
            
            System.out.println("----------------------------------------------------");
            
            while(true)
            {
                if(onlinePaymentFlag == 1)
                    break;
                System.out.print("Card sankhye namudisi: ");
                String dummy = customer.payingBill(2, input);
                System.out.print("Pin annnu namudisi: ");
                    dummy = customer.payingBill(3, input);
                System.out.print("Mottavannu namudisi: ");
                    dummy = customer.payingBill(4, input).toString();
                    
                //Checking if the payed amount is less than the bull amount, we have ask customer to pay again    
                if(Integer.parseInt(dummy) < this.customerBill)
                    onlinePaymentFlag=0;
                else
                    onlinePaymentFlag = 1;
            
                System.out.println("----------------------------------------------------");

                      
                if(this.onlinePaymentFlag==1)
                    System.out.println(".........\n\tPaavati yasasviyagide.");
                else
                    System.out.println("Transaction dosha ! Mattome prayatnisi.");  
            }  
        }
        else
        {
            System.out.println("Paavati annu cashierge balasi &\n\t Acknowledgment tagedukollalu marebedi.");
            
            cashier.customerPayingCash(customerTableID,customerBill);
            
        } 
    }
    
    public void billPaymentInTelugu(Customer customer,Scanner input,Cashier cashier)
    {
          System.out.println("\t\tBILLU CHELLIMPU ");
        for(int i=0; i < selectedItems.size(); i++)
        {
            switch(this.selectedItems.get(i))
            {
                case 1:
                        this.customerBill+=50;
                        break;
                case 2:
                        this.customerBill+=70;
                        break;
                case 3:
                        this.customerBill+=50;
                        break;
                case 4:
                        this.customerBill+=80;
                        break;
                 case 5:
                        this.customerBill+=60;
                        break;
                case 6:
                        this.customerBill+=60;
                        break;         
            }
        }
        System.out.println("Mi billu ? "+customerBill+".00.");
        System.out.println("Miru billunu ela chellinchalanukuntunnaru ? Edaina oka empikanu Enchukondi.");
        System.out.println("\t1. Debit/Credit Card\n\t2. Cash Payment");
        this.paymentMode = Integer.parseInt(customer.payingBill(1, input));
        
        if(this.paymentMode==1)
        {
            System.out.println("MEMU BANK PORTAL KU BADILI CHESTUNNAMU.\nGamanika: memu mi chellimpu samaacharanni nilva cheyyalemu");
            
            System.out.println("----------------------------------------------------");
            
            while(true)
            {
                if(onlinePaymentFlag == 1)
                    break;
                System.out.print("Card sankhyanu namodu cheyyandi: ");
                String dummy = customer.payingBill(2, input);
                System.out.print("Pin namodu cheyyandi: ");
                    dummy = customer.payingBill(3, input);
                System.out.print("Mottanni namodu cheyyandi: ");
                    dummy = customer.payingBill(4, input).toString();
                    
                //Checking if the payed amount is less than the bull amount, we have ask customer to pay again    
                if(Integer.parseInt(dummy) < this.customerBill)
                    onlinePaymentFlag=0;
                else
                    onlinePaymentFlag = 1;
            
                System.out.println("----------------------------------------------------");

                      
                if(this.onlinePaymentFlag==1)
                    System.out.println(".........\n\tChellimpu vijayavantamainadi.");
                else
                    System.out.println("Lava devilalo lopam ! Malli prayatninchandi.");  
            }  
        }
        else
        {
            System.out.println("Dayachesi cashu nagadulo billunu chellinchandi Mariyu\n\t rasidu sekarinchadam marachipovaddu.");
            
            cashier.customerPayingCash(customerTableID,customerBill);
            
        }
            
    }
    
     public void billPaymentInTamil(Customer customer,Scanner input,Cashier cashier)
    {
         System.out.println("\t\tKattanam selutahavum: ");
        for(int i=0; i < selectedItems.size(); i++)
        {
            switch(this.selectedItems.get(i))
            {
                case 1:
                        this.customerBill+=50;
                        break;
                case 2:
                        this.customerBill+=70;
                        break;
                case 3:
                        this.customerBill+=50;
                        break;
                case 4:
                        this.customerBill+=80;
                        break;
                 case 5:
                        this.customerBill+=60;
                        break;
                case 6:
                        this.customerBill+=60;
                        break;         
            }
        }
        System.out.println("Unkal Raceethu: ? "+customerBill+".00.");
        System.out.println("Eppadi kattanam selutha virumbarirkal? Enta oru virupattaiyum thervu seiyyavum.");
        System.out.println("\t1. Debit/Credit Card\n\t2. Cash Payment");
        this.paymentMode = Integer.parseInt(customer.payingBill(1, input));
        
        if(this.paymentMode==1)
        {
            System.out.println("Nankal unkalai vanki portilluku alaithu chelkirom.\nKurippu: Nankal kattanathu thakavalai semikkamaatom");
            
            System.out.println("----------------------------------------------------");
            
            while(true)
            {
                if(onlinePaymentFlag == 1)
                    break;
                System.out.print("ATM attai en aluthavum: ");
                String dummy = customer.payingBill(2, input);
                System.out.print("ATM pin en aluthavum:");
                    dummy = customer.payingBill(3, input);
                System.out.print("Panam yevalavu endru aluthavum: ");
                    dummy = customer.payingBill(4, input).toString();
                    
                //Checking if the payed amount is less than the bull amount, we have ask customer to pay again    
                if(Integer.parseInt(dummy) < this.customerBill)
                    onlinePaymentFlag=0;
                else
                    onlinePaymentFlag = 1;
            
                System.out.println("----------------------------------------------------");

                      
                if(this.onlinePaymentFlag==1)
                    System.out.println(".........\n\tKattanam vetrikanamaga mudindhadhu.");
                else
                    System.out.println("Kattanam mudiyavillai! Marubadi muyarchikkavum.");  
            }  
        }
        else
        {
            System.out.println("Cashieridam panathai seluthavum &\n\t Oppukai cekarikka marakadirkal");
            
            cashier.customerPayingCash(customerTableID,customerBill);
            
        }
    }
    
    public static void main(String[] args) throws InterruptedException
    {       
        
        System.out.println("========================================================================================================");
        System.out.println(" __     __  __      __   ______       __    __     ____     ________    _____   _____      \n" +
"(_ \\   / _) ) \\    / (  (____  )     (  \\  /  )   / __ \\   (___  ___)  / ___/  (_   _)     \n" +
"  \\ \\_/ /    \\ \\  / /       / /       \\ (__) /   / /  \\ \\      ) )    ( (__      | |       \n" +
"   \\   /      \\ \\/ /    ___/ /_        ) __ (   ( ()  () )    ( (      ) __)     | |       \n" +
"   / _ \\       \\  /    /__  ___)      ( (  ) )  ( ()  () )     ) )    ( (        | |   __  \n" +
" _/ / \\ \\_      )(       / /____       ) )( (    \\ \\__/ /     ( (      \\ \\___  __| |___) ) \n" +
"(__/   \\__)    /__\\     (_______)     /_/  \\_\\    \\____/      /__\\      \\____\\ \\________/  \n" +
"                                                                                           ");
        System.out.println("========================================================================================================");
        
        SmartTableAssistant assisant = new SmartTableAssistant();
        
        //Change interface langugage when the assistant starts
        Customer customer = new Customer();        
        assisant.changeLanguage(customer);
        
        //Place the order and 
        //Pass the order to chef
        Chef chef = new Chef();
        ServingTeam servingTeam = new ServingTeam();
        assisant.placingOrder(customer,chef,servingTeam);
        
        
        //To ask for feedback
        Manager manager = new Manager();
        assisant.feedback(chef,customer,manager);
        
        //Bill Payment
        Cashier cashier = new Cashier();
        assisant.billPayment(customer,cashier);
        
        System.out.println("We are happy to serve you.");
        
        System.out.print(" ________   __    __     ____        __      _    __   ___     __      __    ____     __    __  \n" +
"(___  ___) (  \\  /  )   (    )      /  \\    / )  () ) / __)    ) \\    / (   / __ \\    ) )  ( (  \n" +
"    ) )     \\ (__) /    / /\\ \\     / /\\ \\  / /   ( (_/ /        \\ \\  / /   / /  \\ \\  ( (    ) ) \n" +
"   ( (       ) __ (    ( (__) )    ) ) ) ) ) )   ()   (          \\ \\/ /   ( ()  () )  ) )  ( (  \n" +
"    ) )     ( (  ) )    )    (    ( ( ( ( ( (    () /\\ \\          \\  /    ( ()  () ) ( (    ) ) \n" +
"   ( (       ) )( (    /  /\\  \\   / /  \\ \\/ /    ( (  \\ \\          )(      \\ \\__/ /   ) \\__/ (  \n" +
"   /__\\     /_/  \\_\\  /__(  )__\\ (_/    \\__/     ()_)  \\_\\        /__\\      \\____/    \\______/  \n" +
"                                                                                                ");
     
    }
    
}
