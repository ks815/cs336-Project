package com.example.project5;


import java.text.DecimalFormat;

/**
 * Subclass with price feature depends on numbers of toppings.
 *
 * @author Sihua Zhou, Yihang Sun
 */
public class BuildYourOwn extends Pizza{
    /**
     * price of the small build your own pizza without any toppings.
     */
    public static final double smallPrice = 8.99;
    /**
     * price of the medium build your own pizza without any toppings.
     */
    public static final double mediumPrice = 10.99;
    /**
     * price of the large build your own pizza without any toppings.
     */
    public static final double largePrice = 12.99;
    /**
     * retail price for every topping.
     */
    public static final double pricePerTopping = 1.59;
    /**
     * constant to represent no such size.
     */
    private final double noSuchSize = -1;

    /**
     * Override method to calculate the price for the pizza with certain size and number of toppings.
     * @return price of the pizza.
     */
    @Override
    public double price() {
        DecimalFormat df = new DecimalFormat("#0.00");
        if(Size.SMALL.equals(super.getSize())){
            return Double.parseDouble(df.format(smallPrice + super.getToppings().size() * pricePerTopping));
        }else if(Size.MEDIUM.equals(super.getSize())){
            return Double.parseDouble(df.format(mediumPrice + super.getToppings().size() * pricePerTopping));
        }else if(Size.LARGE.equals(super.getSize())){
            return Double.parseDouble(df.format(largePrice + super.getToppings().size() * pricePerTopping));
        }else{
            return noSuchSize;
        }
    }

    /**
     * Calculate the price for a build your own pizza and return with String representation.
     * @param size size of the pizza.
     * @param numberOfToppings number of the toppings this pizza has.
     * @return String representation of the pizza price.
     */
    public static String calculatePrice(Size size, int numberOfToppings){
        double totalPrice = 0;
        if(size.equals(Size.SMALL)){
            totalPrice = smallPrice + pricePerTopping * numberOfToppings;
        }else if (size.equals(Size.MEDIUM)){
            totalPrice = mediumPrice + pricePerTopping * numberOfToppings;
        }else if(size.equals(Size.LARGE)){
            totalPrice = largePrice + pricePerTopping * numberOfToppings;
        }
        return String.format("%.2f", totalPrice);
    }
}
