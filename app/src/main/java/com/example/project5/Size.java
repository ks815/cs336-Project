package com.example.project5;

/**
 * Enum class for holding size of the pizza.
 * @author Sihua Zhou, Yihang Sun
 */
public enum Size {
    /**
     * Small size.
     */
    SMALL,
    /**
     * Medium size.
     */
    MEDIUM,
    /**
     * Large size.
     */
    LARGE;

    /**
     * Helper method to find the size of pizza.
     * @param size pizza size.
     * @return Size.
     */
    public static Size findSize(String size){
        for(int index = 0; index < Size.values().length; index++){
            if(size.equalsIgnoreCase(Size.values()[index].toString())){
                return Size.values()[index];
            }
        }
        return null;
    }
}
