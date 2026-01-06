package com.co.choucair.questions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateText implements Question<String> {

    Target element;
    String text;

    public ValidateText(Target element, String text) {
        this.text = text;
        this.element = element;
    }

    @Override
    public String answeredBy(Actor actor) {
        Target TXT_PRODUCTS = element.of(text);
        String texto = Text.of(TXT_PRODUCTS).answeredBy(actor);
        //System.out.println("El texto productes es:"+ actor.asksFor(Text.of(element.of(text))));
        return texto;
    }

    public static ValidateText of(Target element, String text){
        return Instrumented.instanceOf(ValidateText.class).withProperties(element, text);
    }
}
