package com.co.choucair.stepdefinitions;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.questions.ShoppingCartBadge;
import com.co.choucair.tasks.AddProductToCart;
import com.co.choucair.tasks.Login;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

import static com.co.choucair.utils.GlobalData.ACTOR;
import static com.co.choucair.utils.GlobalData.URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class SerenityAddStepDefinitions {


    @Given("the user is logged in")
    public void theUserIsLoggedIn(DataTable dataTable) {
        theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
        theActorInTheSpotlight().attemptsTo(
                Login.onTheSite(UserLoombokData.setData(dataTable).get(0))
        );
    }


    @When("the user adds the product {string}")
    public void theUserAddsTheProduct(String productName) {
        theActorInTheSpotlight().attemptsTo(
                AddProductToCart.named(productName)
        );
    }

    @Then("the shopping cart badge should display {int}")
    public void theShoppingCartBadgeShouldDisplay(int expectedCount) {
        theActorInTheSpotlight().should(
                seeThat(ShoppingCartBadge.value(), equalTo(expectedCount))
        );
    }
}
