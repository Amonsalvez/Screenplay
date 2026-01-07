
package com.co.choucair.tasks;

import com.co.choucair.userinterfaces.SerenityLoginPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import com.co.choucair.userinterfaces.SerenityInventoryPage;
import com.co.choucair.utils.ProductNameFormat;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

/**
 * Task para agregar un producto al carrito por nombre visible.
 * Convierte el nombre del producto a formato kebab para coincidir con el data-test/id:
 * Ej: "Sauce Labs Backpack" -> "sauce-labs-backpack"
 */
public class AddProductToCart {

    private AddProductToCart() {}

    public static Performable named(String productName) {
        return Task.where("{0} adds the product '" + productName + "' to the cart",
                JavaScriptClick.on(SerenityInventoryPage.BTN_ADD_TO_CART)
        );
    }
}
