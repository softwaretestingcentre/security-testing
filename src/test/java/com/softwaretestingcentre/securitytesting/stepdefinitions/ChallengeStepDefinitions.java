package com.softwaretestingcentre.securitytesting.stepdefinitions;

import com.softwaretestingcentre.securitytesting.helpers.JuiceShop;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;

public class ChallengeStepDefinitions {

    @Then("{actor} sees she has solved the {string} challenge")
    public void sheSeesSheHasSolvedTheChallenge(Actor actor, String solvedChallenge) {
        actor.wasAbleTo(JuiceShop.openScoreBoard());
        actor.wasAbleTo(JuiceShop.challengeIsSolved(solvedChallenge));
    }
}
