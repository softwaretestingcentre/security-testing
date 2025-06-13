package com.softwaretestingcentre.securitytesting.helpers;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.core.Serenity.getDriver;


public class JuiceShop {
    public static Performable openShop() {
        return Task.where("{0} opens the shop",
                Open.browserOn().the(HomePage.class)
        );
    }

    public static Performable searchFor(String searchTerm) {
        return Task.where("{0} searches for " + searchTerm,
                Click.on(HomePage.SEARCH_BUTTON),
                Enter.theValue(searchTerm).into(HomePage.SEARCH_INPUT),
                SendKeys.of(Keys.ENTER).into(HomePage.SEARCH_INPUT)
        );
    }

    public static Question<String> getAlertText() {
        Alert alert = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
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
                Open.browserOn().the(ScoreBoardPage.class)
        );
    }

    public static Performable openPrivacyPolicy() {
        return Task.where("{0} opens the Privacy Policy",
                Open.browserOn().the(PrivacyPolicyPage.class)
        );
    }

    public static Performable challengeIsSolved(String solvedChallenge) {
        WaitUntil.the(ScoreBoardPage.CHALLENGE_CARD, WebElementStateMatchers.isVisible());
        return Ensure.that(ScoreBoardPage.SOLVED_CHALLENGE.of(solvedChallenge)).isDisplayed();
    }
}
