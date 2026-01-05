package com.co.choucair.questions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.ensure.Ensure.thatTheCurrentPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.screenplay.Task;


public class ValidateUrl implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
    }

    public static ValidateUrl current() {
        return Instrumented.instanceOf(ValidateUrl.class).withProperties();
    }
}


/*
    private final String expectedUrl;

    private ValidateUrl(String expectedUrl) {
        this.expectedUrl = expectedUrl;
    }

    public static ValidateUrl is(String fullUrl) {
        return instrumented(ValidateUrl.class, fullUrl);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriverWait wait = new WebDriverWait(
                BrowseTheWeb.as(actor).getDriver(),
                java.time.Duration.ofSeconds(10)
        );
        // Esperar a que la URL sea exactamente la esperada
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        // Aserción para reportes de Serenity
        actor.attemptsTo(
                thatTheCurrentPage().currentUrl().isEqualTo(expectedUrl)
        );
    }
 */