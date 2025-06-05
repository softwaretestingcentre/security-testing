package com.softwaretestingcentre.securitytesting.stepdefinitions;

import com.softwaretestingcentre.securitytesting.helpers.HomePage;
import com.softwaretestingcentre.securitytesting.helpers.JuiceShop;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;

public class BasicStepDefinitions {
    @Given("{actor} goes to the Juice Shop")
    public void goesToTheJuiceShop(Actor actor) {
        actor.wasAbleTo(Open.browserOn().the(HomePage.class));
        actor.wasAbleTo(JuiceShop.dismissDialogs());
    }

    @When("{actor} selects {string}")
    public void sheSelects(Actor actor, String juiceName) {
        actor.wasAbleTo(Click.on(HomePage.JUICE_LINK.of(juiceName)));
    }

    @Then("{actor} can see the {string} details")
    public void sheCanSeeTheDetails(Actor actor, String juiceName) {
        Ensure.that(HomePage.JUICE_DETAILS.of(juiceName).isVisibleFor(actor));
    }
}
