package com.example.project5;

/**
 * Interface class for multiple to use it abstract methods.
 * Add/remove toppings, pizza, order.
 * @author Sihua Zhou, Yihang Sun
 */
public interface Customizable {
    /**
     * Abstract method add.
     * @param obj instance input.
     * @return true for added, false for not.
     */
    boolean add(Object obj);

    /**
     * Abstract method remove
     * @param obj instance input.
     * @return true for removed, false for not.
     */
    boolean remove(Object obj);
}
