package com.co.choucair.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class SerenityInventoryPage {


    public static final Target BTN_ADD_TO_CART = Target.the("botón de add to cart")
            .located(By.id("add-to-cart-sauce-labs-backpack"));

    public static final Target SHOPPING_CART_LINK = Target.the("shopping cart link")
            .located(By.cssSelector("a.shopping_cart_link"));

    /**
     * Badge del carrito: aparece con el número cuando hay items.
     */
    public static final Target SHOPPING_CART_BADGE = Target.the("shopping cart badge")
            .located(By.cssSelector(".shopping_cart_badge"));
}
