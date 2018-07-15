/*
 * Description: Player class
 * File Name: Culminating
 * Programmer: Anjali Thatte
 * Date: August 24
 */
package culminating;

import java.util.ArrayList;

/**
 *
 * @author anjal
 */
public class Player {
    
    private ArrayList<House> owned = new ArrayList<House>();                            //houses player owns
    private final int playerID;                                                           //specific ID (unique to player)
    private final String name;                                                            //entered name
    private double balance;                                                         //money currently in account

    
    /**
     * Description: constructor for player objects
     * @param inputID
     * @param inputName
     * @param inputBalance 
     */
    public Player(int inputID, String inputName, double inputBalance){
        playerID=inputID;   //specific ID (unique to player)
        name=inputName;    //entered name
        balance=inputBalance; //money currently in account
    }
    /**
     * subtracts the 10% property tax from total money so far
     */
    public void taxes(){
        for (int i=0; i<owned.size(); i++){
            balance-=(owned.get(i).givePrice()*.1);
        }
        
    }
    /**
     * returns balance player has left
     * @return 
     */
    public double giveBalance(){
        return balance;
    }
    /**
     * returns arraylist of houses player owns now
     * @return 
     */
    public ArrayList<House> giveOwned(){
        return owned;
    }
    /**
     * returns a String version of all houses player owns now
     * @return 
     */
    public String ownedToString(){
        String temp="   ";
        for (int i=0; i<owned.size(); i++){
            temp+="\n   ("+owned.get(i).giveName()+") Current Market Value: "+owned.get(i).givePrice();
        }
        return temp;
    }
    /**
     * returns name of player that they entered
     * @return 
     */
    public String giveName(){
        return name;
    }
    /**
     * adds house to owned list, while subtracting its price from balance
     * @param bought //house bought
     */
    public void buyHouse (House bought){
        owned.add(bought);
        balance-=bought.givePrice();
    }
    /**
     * removes house from owned list, while adding its current market value to balance
     * @param sold //house sold
     */
    public void sellHouse(House sold){
        owned.remove(sold);
        balance+=sold.givePrice();
    }

}
