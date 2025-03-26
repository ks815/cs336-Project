package com.example.project5;

/**
 * Interface class for generating the instance of each type of pizza.
 * Implemented by two styles of pizza class.
 * @author Sihua Zhou, Yihang Sun
 */
public interface PizzaFactory {
    /**
     * Abstract method to create a Deluxe pizza, implemented by two styles of pizza classes.
     * @return Deluxe pizza instance.
     */
    Pizza createDeluxe();
    /**
     * Abstract method to create a Meatzza pizza, implemented by two styles of pizza classes.
     * @return Meatzza pizza instance.
     */
    Pizza createMeatzza();
    /**
     * Abstract method to create a BBQ Chicken pizza, implemented by two styles of pizza classes.
     * @return BBQ Chicken pizza instance.
     */
    Pizza createBBQChicken();
    /**
     * Abstract method to create a BuildYourOwn pizza, implemented by two styles of pizza classes.
     * @return BUildYourOwn pizza instance.
     */
    Pizza createBuildYourOwn();
}
