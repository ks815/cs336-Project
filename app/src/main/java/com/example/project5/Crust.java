package com.example.project5;

/**
 * Enum class for store list of Crust.
 * @author Sihua Zhou, Yihang Sun
 */
public enum Crust {
    /**
     * Deep Dish crust.
     */
    DEEP_DISH,
    /**
     * Pan crust.
     */
    PAN,
    /**
     * Stuffed crust.
     */
    STUFFED,
    /**
     * Brooklyn crust.
     */
    BROOKLYN,
    /**
     * Thin crust.
     */
    THIN,
    /**
     * Hand tossed crust.
     */
    HAND_TOSSED;

    /**
     * Helper method to find the Crust.
     * @param crust Crust in String.
     * @return Curst
     */
    public static Crust findCrust(String crust){
        for(int index = 0; index < Crust.values().length; index++){
            if(crust.substring(7).equalsIgnoreCase(Crust.values()[index].toString())){
                return Crust.values()[index];
            }
        }
        return null;
    }
}
