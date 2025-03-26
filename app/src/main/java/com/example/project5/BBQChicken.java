package com.example.project5;

/**
 * Subclass of Pizza with price feature.
 *
 * @author Sihua Zhou, Yihang Sun
 */
public class BBQChicken extends Pizza{
    /**
     * price for the small BBQ Chicken Pizza.
     */
    public static final double smallPrice = 13.99;
    /**
     * price for the medium BBQ Chicken Pizza.
     */
    public static final double mediumPrice = 15.99;
    /**
     * price for the large BBQ Chicken Pizza.
     */
    public static final double largePrice = 17.99;
    /**
     * constant to represent no such size.
     */
    private final double noSuchSize = -1;

    /**
     * Override method to calculate the price for the pizza with certain size.
     * @return price of the pizza.
     */
    @Override
    public double price() {
        if(Size.SMALL.equals(super.getSize())){
            return smallPrice;
        }else if(Size.MEDIUM.equals(super.getSize())){
            return mediumPrice;
        }else if(Size.LARGE.equals(super.getSize())){
            return largePrice;
        }else{
            return noSuchSize;
        }
    }
}
