package com.co.choucair.stepdefinitions;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.questions.ValidateText;
import com.co.choucair.questions.ValidateUrl;
import com.co.choucair.tasks.Login;
import com.co.choucair.utils.KillBrowser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

import static com.co.choucair.userinterfaces.SerenityLoginPage.TXT_VALIDATION;
import static com.co.choucair.utils.GlobalData.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.ensure.Ensure.that;
import static net.serenitybdd.screenplay.ensure.Ensure.thatTheCurrentPage;
import static org.hamcrest.Matchers.containsString;

public class SerenityLoginStepDefinitions {

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public static void CloseDriver() throws IOException, InterruptedException {
        SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
        KillBrowser.processes(List.of((SerenityWebdriverManager.inThisTestThread().getCurrentDriverName()).split(":")).get(0));
    }

    @Given("the user is on the serenity demo page")
    public void theUserIsOnTheSerenityDemoPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }

    @When("attempts to log in")
    public void attemptsToLogIn(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                Login.onTheSite(UserLoombokData.setData(dataTable).get(0))
        );
    }

    @Then("^validate the text on screen (.*)$")
    public void validateTheTextOnScreenDashboard(String text) {
        theActorInTheSpotlight().should(seeThat(ValidateText.of(TXT_VALIDATION, text), containsString(text)));

    }

    @And("^the url should be (.*)$")
    public void validateUrlOnScreen(String expectedUrl) {
        theActorInTheSpotlight().
                attemptsTo(
                        that(ValidateUrl.current()).isEqualTo(expectedUrl)

                );
    }


}
