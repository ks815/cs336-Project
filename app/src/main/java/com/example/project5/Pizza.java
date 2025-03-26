package com.example.project5;

import java.util.ArrayList;

/**
 * Abstract class that implement Customizable.
 * Add/remove toppings.
 * @author Sihua Zhou, Yihang Sun
 */
public abstract class Pizza implements Customizable{
    /**
     * Instance variable for holding the list of toppings with Type Topping.
     */
    private ArrayList<Topping> toppings;
    /**
     * Instance variable for holding Crust of the pizza.
     */
    private Crust crust;
    /**
     * Instance variable for holding Size of the pizza.
     */
    private Size size;

    /**
     * Constructor of Pizza Class when Pizza's subclass instance is generated..
     */
    public Pizza(){
        toppings = new ArrayList<>();
    }

    /**
     * Set new Topping list for this pizza.
     * @param toppings list of Toppings.
     */
    public void setToppings(ArrayList<Topping> toppings){
        this.toppings = toppings;
    }

    /**
     * Set new Crust for this pizza.
     * @param crust Crust of this pizza.
     */
    public void setCrust(Crust crust){
        this.crust = crust;
    }

    /**
     * Set new Size for this pizza.
     * @param size Size of this pizza.
     */
    public void setSize(Size size){
        this.size = size;
    }

    /**
     * Getter method for accessing the topping list of this pizza.
     * @return list of toppings.
     */
    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    /**
     * Getter method for accessing the size of the pizza.
     * @return size of the pizza.
     */
    public Size getSize() {
        return size;
    }

    /**
     * Method to add a topping to a pizza.
     * @param obj instance input.
     * @return true for added, false for not.
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Topping){
            ArrayList<Topping> newList = toppings;
            newList.add((Topping)obj);
            setToppings(newList);
            return true;
        }
        return false;
    }

    /**
     * Method to remove a topping to a pizza.
     * @param obj instance input.
     * @return true for removed, false for not.
     */
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Topping){
            ArrayList<Topping> newList = toppings;
            newList.remove((Topping)obj);
            return true;
        }
        return false;
    }

    /**
     * Return with Topping in String representation
     * @return Topping in String representation
     */
    public String getToppingString(){
        String textList = "";
        for(Topping top: toppings){
            textList = textList + top.toString() + ", ";
        }
        return textList;
    }

    /**
     * Abstract method to will be implemented by its subclass for calculating the price of the pizza.
     * @return price of the pizza.
     */
    public abstract double price();
}
