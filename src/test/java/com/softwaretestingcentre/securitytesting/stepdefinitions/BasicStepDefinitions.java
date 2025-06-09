package com.softwaretestingcentre.securitytesting.stepdefinitions;

import com.softwaretestingcentre.securitytesting.helpers.HomePage;
import com.softwaretestingcentre.securitytesting.helpers.JuiceShop;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

public class BasicStepDefinitions {
    @Given("{actor} goes to the Juice Shop")
    public void goesToTheJuiceShop(Actor actor) {
        actor.wasAbleTo(JuiceShop.openShop());
    }

    @When("{actor} selects {string}")
    public void sheSelects(Actor actor, String juiceName) {
        actor.wasAbleTo(Click.on(HomePage.JUICE_LINK.of(juiceName)));
    }

    @Then("{actor} can see the {string} details")
    public void sheCanSeeTheDetails(Actor actor, String juiceName) {
        Ensure.that(HomePage.JUICE_DETAILS.of(juiceName).isVisibleFor(actor));
    }

    @Then("{actor} can see the {string} strapline")
    public void sheCanSeeTheStrapline(Actor actor, String juiceStrapline) {
        Ensure.that(HomePage.JUICE_STRAPLINE.of(juiceStrapline).isVisibleFor(actor));
    }


    @When("{actor} injects HTML into the search input")
    public void sheInjectsHTMLIntoTheSearchInput(Actor actor) {
        actor.wasAbleTo(JuiceShop.searchFor("<iframe id='injection' src='javascript:alert(\"xss\")'>"));
    }

    @Then("{actor} sees an alert message containing {string}")
    public void sheSeesAnAlertMessage(Actor actor, String alertMessage) {
        actor.attemptsTo(JuiceShop.alertIsEqualTo(alertMessage));
    }

    @When("{actor} opens the score board")
    public void sheOpensTheScoreBoard(Actor actor) {
        actor.attemptsTo(JuiceShop.openScoreBoard());
    }
}
