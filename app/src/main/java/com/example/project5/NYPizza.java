package com.example.project5;

/**
 * Concrete Class implemented PizzaFactory for generating instance of Pizza.
 * Specifically it generate New York style pizza.
 * @author Sihua Zhou, Yihang Sun
 */
public class NYPizza implements PizzaFactory{

    /**
     * method to generate an instance of Deluxe Class.
     * @return instance of Deluxe Class.
     */
    @Override
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();
        return pizza;
    }
    /**
     * method to generate an instance of Meatzza Class.
     * @return instance of Meatzza Class.
     */
    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        return pizza;
    }

    /**
     * method to generate an instance of BBQChicken Class.
     * @return instance of BBQChicken Class.
     */
    @Override
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        return pizza;
    }

    /**
     * method to generate an instance of BuildYourOwn Class.
     * @return instance of BuildYourOwn Class.
     */
    @Override
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        return pizza;
    }
}
