package com.softwaretestingcentre.securitytesting.stepdefinitions;

import com.softwaretestingcentre.securitytesting.helpers.JuiceShop;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

public class ChallengeStepDefinitions {

    @Then("{actor} sees she has solved the {string} challenge")
    public void sheSeesSheHasSolvedTheChallenge(Actor actor, String challengeName) {
        actor.attemptsTo(
                Ensure.that(JuiceShop.isChallengeSolved(challengeName)).isTrue()
        );
    }
}
