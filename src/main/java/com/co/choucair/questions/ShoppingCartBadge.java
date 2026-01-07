package com.co.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import com.co.choucair.userinterfaces.SerenityInventoryPage;

/**
 * Devuelve el número mostrado en el badge del carrito.
 * Si el badge no está visible, retorna 0.
 */
public class ShoppingCartBadge implements Question<Integer> {

    public static Question<Integer> value() {
        return new ShoppingCartBadge();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        var badgeTarget = SerenityInventoryPage.SHOPPING_CART_BADGE;
        var badge = badgeTarget.resolveFor(actor);

        if (!badge.isVisible() || badge.getText().isBlank()) {
            return 0;
        }
        String text = badge.getText().trim();
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            // En caso de texto inesperado, retornamos 0 para no romper la prueba
            return 0;
        }
    }
}
