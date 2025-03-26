package com.example.project5;

import java.util.ArrayList;

/**
 * Class for holding the entire orders for the store.
 * @author Sihua Zhou, Yihang Sun
 */
public class StoreOrder implements Customizable{

    /**
     * Instance variable for holding the order number of each order.
     */
    private ArrayList<Integer> orderNumbers;

    /**
     * Instance variable for holding the list of orders.
     */
    private ArrayList<Order> listOfOrder;

    /**
     * Constructor of the StoreOrder Class.
     */
    public StoreOrder(){
        orderNumbers = new ArrayList<>();
        listOfOrder = new ArrayList<>();
    }

    /**
     * Getter method for returning the list of order number.
     * @return List of order number.
     */
    public ArrayList<Integer> getOrderNumbers() {
        return orderNumbers;
    }

    /**
     * Getter method for returning the list of order.
     * @return List of order.
     */
    public ArrayList<Order> getListOfOrder() {
        return listOfOrder;
    }

    /**
     * Getter method for returning specific order for the given index.
     * @param index Index of the order in the list of order.
     * @return certain order.
     */
    public Order getOrderDetail(Integer index){
        if(index == -1){
            return null;
        }else{
            return listOfOrder.get(index);
        }
    }

    /**
     * Method to add order into the store order.
     * @param obj instance input.
     * @return true for added, false for not.
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order){
            listOfOrder.add((Order) obj);
            return true;
        }else if(obj instanceof Integer){
            orderNumbers.add((Integer) obj);
            return true;
        }
        return false;
    }

    /**
     * Method to remove order from the store order.
     * @param obj instance input.
     * @return true for removed, false for not.
     */
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Order){
            listOfOrder.remove((Order) obj);
            return true;
        }else if(obj instanceof Integer){
            orderNumbers.remove((Integer) obj);
            return true;
        }
        return false;
    }
}
