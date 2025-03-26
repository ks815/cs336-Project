package com.example.project5;

import java.util.ArrayList;

/**
 * Class to handle functions for manipulating an Order instance.
 * @author Sihua Zhou, Yihang Sun
 */
public class Order implements Customizable{

    /**
     * Unique order the current order has.
     */
    private int order_number;

    /**
     * Instance variable for list of pizza.
     */
    private ArrayList<Pizza> listOfPizza;

    /**
     * Instance varibale for list of pizza in textual representation.
     */
    private ArrayList<String> listOfPizzaDisplay;

    /**
     * Constructor when new Order is generated.
     * @param order_number order number of the previous order.
     */
    public Order(int order_number){
        this.order_number = order_number + 1;
        listOfPizza = new ArrayList<>();
        listOfPizzaDisplay = new ArrayList<>();
    }

    /**
     * Getter method to return list of pizza.
     * @return list of pizza in ArrayList<Pizza>.
     */
    public ArrayList<Pizza> getListOfPizza(){
        return listOfPizza;
    }

    /**
     * Getter method to return list of pizza.
     * @return list of pizza in ArrayList<String>.
     */
    public ArrayList<String> getListOfPizzaDisplay(){
        return listOfPizzaDisplay;
    }

    /**
     * Getter method to return the current order's order number.
     * @return current order's order number.
     */
    public int getOrder_number(){
        return order_number;
    }

    /**
     * Method to calculate the current order subtotal and turn it into String representation.
     * @return current order subtotal.
     */
    public String calculateSubtotal(){
        double subtotal = 0;
        for(Pizza pizza: listOfPizza){
            subtotal = subtotal + pizza.price();
        }
        return String.format("%.2f", subtotal);
    }

    /**
     * Method to calculate the current order sales tax and turn it into String representation.
     * @return current order sales tax.
     */
    public String calculateSalesTax(){
        double tax = 0;
        for(Pizza pizza: listOfPizza){
            tax = tax + pizza.price();
        }
        tax = tax * 0.06625;
        return String.format("%.2f", tax);
    }

    /**
     * Method to calculate the current order total price including tax and turn it into String representation.
     * @return current order total price
     */
    public String calculateOrderTotal(){
        double subtotal = 0;
        double tax = 0;
        double orderTotal = 0;
        for(Pizza pizza: listOfPizza){
            subtotal = subtotal + pizza.price();
        }
        tax = subtotal * 0.06625;
        orderTotal = subtotal + tax;
        return String.format("%.2f", orderTotal);
    }

    /**
     * Method to add a pizza into the current order.
     * @param obj instance input.
     * @return true for added, false for not.
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Pizza){
            listOfPizza.add((Pizza) obj);
            return true;
        }else if(obj instanceof String){
            listOfPizzaDisplay.add((String) obj);
            return true;
        }
        return false;
    }

    /**
     * Method to remove a pizza from the current order.
     * @param obj instance input.
     * @return true for removed, false for not.
     */
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Pizza){
            listOfPizza.remove((Pizza) obj);
            return true;
        }else if(obj instanceof String){
            listOfPizzaDisplay.remove((String) obj);
            return true;
        }
        return false;
    }
}
