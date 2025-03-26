package com.example.project5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Enum Class holds the list of topping.
 * @author Sihua Zhou, Yihang Sun
 */
public enum Topping {
    /**
     * Topping Sausage.
     */
    SAUSAGE,
    /**
     * Topping Pepperoni.
     */
    PEPPERONI,
    /**
     * Topping Green Pepper
     */
    GREEN_PEPPER,
    /**
     * Topping Onion.
     */
    ONION,
    /**
     * Topping Mushroom.
     */
    MUSHROOM,
    /**
     * Topping BBQ Chicken.
     */
    BBQ_CHICKEN,
    /**
     * Topping Provolone.
     */
    PROVOLONE,
    /**
     * Topping Cheddar.
     */
    CHEDDAR,
    /**
     * Topping Beef.
     */
    BEEF,
    /**
     * Topping Ham.
     */
    HAM,
    /**
     * Topping Bacon.
     */
    BACON,
    /**
     * Topping Black Olive.
     */
    BLACK_OLIVE,
    /**
     * Topping Garlic.
     */
    GARLIC;

    /**
     * Helper method to find corresponding Topping constant.
     * @param topping Topping String,
     * @return Topping constant
     */
    public static Topping findTopping(String topping){
        for(int index = 0; index < Topping.values().length; index++){
            if(topping.equalsIgnoreCase(Topping.values()[index].toString())){
                return Topping.values()[index];
            }
        }
        return null;
    }

    /**
     * Helper method to turn enum list to arraylist.
     * @return arralist of Topping.
     */
    public static ArrayList<String> enumToList(){
        ArrayList<String> temp = new ArrayList<>();
        for(int index = 0; index < Topping.values().length; index++){
            temp.add(Topping.values()[index].toString());
        }
        return temp;
    }

    /**
     * Helper method to convert string arraylist to Topping arraylist.
     * @param list string arraylist for toppings.
     * @return Topping arraylist.
     */
    public static ArrayList<Topping> ListToList(ArrayList<String> list){
        ArrayList<Topping> temp = new ArrayList<>();
        while(list.size() > 0){
            temp.add(findTopping(list.remove(0)));
        }
        return temp;
    }


    /**
     * Getter for default Deluxe topping list.
     * @return default Deluxe topping list.
     */
    public static ArrayList<Topping> defaultDeluxeList(){
        ArrayList<Topping> temp = new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI
                , Topping.GREEN_PEPPER,Topping.ONION, Topping.MUSHROOM));
        return temp;
    }

    /**
     * Getter for default BBQ Chicken topping list.
     * @return default BBQ Chicken topping list.
     */
    public static ArrayList<Topping> defaultBBQChickenList(){
        ArrayList<Topping> temp = new ArrayList<>(Arrays.asList(Topping.BBQ_CHICKEN,Topping.GREEN_PEPPER
                , Topping.PROVOLONE, Topping.CHEDDAR));
        return temp;
    }

    /**
     * Getter for default Meatzza topping list.
     * @return default Meatzza topping list.
     */
    public static ArrayList<Topping> defaultMeatzzaList(){
        ArrayList<Topping> temp = new ArrayList<>(Arrays.asList(Topping.SAUSAGE,Topping.PEPPERONI
                , Topping.BEEF, Topping.HAM));
        return temp;
    }
}
