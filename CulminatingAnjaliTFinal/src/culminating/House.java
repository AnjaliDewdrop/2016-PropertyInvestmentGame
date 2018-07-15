/*
 * Description: House class
 * File Name: Culminating
 * Programmer: Anjali Thatte
 * Date: August 24
 */
package culminating;

/**
 *
 * @author anjal
 */
public class House {
    //instance variables
    private double price;                  //price of the house
    private final double changeFactor;     //what percent the house price will change by
    private final String name;             //name of house based on location on grid
    private int ownedBy=5;                 //who it is owned by (5= bank, 0-3=players based on their ID)
    private Boolean changePrice=false;     //if price should be changed in current turn
    
    /**
     * Description: Constructor of houses
     * @param price
     * @param changeFactor
     * @param name 
     */
    public House (double price, double changeFactor, String name){
        this.price=price;               //price of house
        this.changeFactor=changeFactor; // what percent the house prie will be of original when market changes
        this.name=name;                 //name of the house based on location on grid
    }
    /**
     * changes price by change factor
     */
    public void changeMarketVal(){
        price*=changeFactor;
    }
    /**
     * changes owner represented by number (5 for bank, 0-3 for players based on ID)
     * @param newOwner 
     */
    public void changeOwner(int newOwner){
        ownedBy=newOwner;
    }
    /**
     * whether the price is changed is determined by this t/f id
     * @param change 
     */
    public void priceWillChange(Boolean change){
        changePrice=change;
    }
    /**
     * used to inform if this house is supposed to change price in current turn
     * @return 
     */
    public Boolean giveChangePrice(){
        return changePrice;
    }
    /**
     * returns owner by their ID (0-3 or 5)
     * @return 
     */
    public int giveOwner(){
        return ownedBy;
    }
    /**
     * returns name of house based on location
     * @return 
     */
    public String giveName(){
        return name;
    }
    /**
     * returns price of house
     * @return 
     */
    public double givePrice(){
        return price;
    }
    
       
}

