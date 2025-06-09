package com.softwaretestingcentre.securitytesting.helpers;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class JuiceShop {
    public static Performable openShop() {
        return Task.where("{0} opens the shop",
                Open.browserOn().the(HomePage.class),
                Click.on(HomePage.ACCEPT_COOKIES),
                WaitUntil.the(HomePage.DISMISS_WELCOME_MESSAGE, isClickable()),
                Click.on(HomePage.DISMISS_WELCOME_MESSAGE)
        );
    }

    public static Performable searchFor(String searchTerm) {
        return Task.where("{0} searches for " + searchTerm,
                Open.browserOn().the(HomePage.class),
                Click.on(HomePage.SEARCH_BUTTON),
                Enter.theValue(searchTerm).into(HomePage.SEARCH_INPUT),
                SendKeys.of(Keys.ENTER).into(HomePage.SEARCH_INPUT)
        );
    }

    public static Question<String> getAlertText() {
        return Question.about("Alert text").answeredBy(
                actor -> {
                    actor.attemptsTo(Switch.toAlert());
                    String acknowledgement = actor.asksFor(HtmlAlert.text());
                    actor.attemptsTo(Switch.toAlert().andDismiss());
                    return acknowledgement;
                }
        );
    }

    public static Performable alertIsEqualTo(String alertText) {
        return Ensure.that("Alert message is " + alertText,
                getAlertText()).isEqualTo(alertText);
    }

    public static Performable openScoreBoard() {
        return Task.where("{0} opens their Score Board",
                Open.browserOn().the(ScoreBoardPage.class),
                WaitUntil.the(ScoreBoardPage.SPINNER, WebElementStateMatchers.isNotVisible())
        );
    }

    public static Performable challengeIsSolved(String solvedChallenge) {
        return Ensure.that(ScoreBoardPage.SOLVED_CHALLENGE.of(solvedChallenge)).isDisplayed();
    }
}
