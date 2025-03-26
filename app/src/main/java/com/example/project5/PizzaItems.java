package com.example.project5;

import java.io.Serializable;

/**
 * Class for holding information for recycler view.
 * @author Sihua Zhou, Yihang Sun
 */
public class PizzaItems implements Serializable {
    /**
     * Image Constant.
     */
    private int images;
    /**
     * Pizza style.
     */
    private String style;
    /**
     * Pizza flavor.
     */
    private String flavor;
    /**
     * Pizza crust.
     */
    private String crust;
    /**
     * Pizza Toppings.
     */
    private String toppings;
    /**
     * Small pizza price.
     */
    private String smallPrice;
    /**
     * Medium pizza price.
     */
    private String mediumPrice;
    /**
     * Large pizza price.
     */
    private String largePrice;
    /**
     * Button information.
     */
    private String buttonText;

    /**
     * Constructor for pizza items.
     * @param images Image Constant.
     * @param style Pizza style.
     * @param flavor Pizza flavor.
     * @param crust Pizza crust.
     * @param toppings Pizza Toppings.
     * @param smallPrice Small pizza price.
     * @param mediumPrice Medium pizza price.
     * @param largePrice Large pizza price.
     * @param buttonText Button information.
     */
    public PizzaItems(int images, String style, String flavor, String crust, String toppings, String smallPrice, String mediumPrice, String largePrice, String buttonText) {
        this.images = images;
        this.style = style;
        this.flavor = flavor;
        this.crust = crust;
        this.toppings = toppings;
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
        this.buttonText = buttonText;
    }

    /**
     * Getter for Image Constant.
     * @return Image Constant.
     */
    public int getImages() {
        return images;
    }

    /**
     * Getter for pizza style.
     * @return pizza style.
     */
    public String getStyle() {
        return style;
    }

    /**
     * Getter for pizza flavor.
     * @return pizza flavor.
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Getter for pizza crust.
     * @return pizza crust.
     */
    public String getCrust() {
        return crust;
    }

    /**
     * Getter for pizza toppings.
     * @return pizza toppings.
     */
    public String getToppings() {
        return toppings;
    }

    /**
     * Getter for small pizza price.
     * @return small pizza price.
     */
    public String getSmallPrice() {
        return smallPrice;
    }

    /**
     * Getter for medium pizza price.
     * @return medium pizza price.
     */
    public String getMediumPrice() {
        return mediumPrice;
    }

    /**
     * Getter for large pizza price.
     * @return large pizza price.
     */
    public String getLargePrice() {
        return largePrice;
    }

    /**
     * Getter for button information.
     * @return button information.
     */
    public String getButtonText() {
        return buttonText;
    }
}
