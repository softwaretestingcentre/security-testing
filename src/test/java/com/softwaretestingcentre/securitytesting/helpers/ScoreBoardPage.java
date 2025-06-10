package com.softwaretestingcentre.securitytesting.helpers;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.WhenPageOpens;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

@DefaultUrl("https://stc-owasp-juice-dnebatcgf2ddf4cr.uksouth-01.azurewebsites.net/#/score-board")
public class ScoreBoardPage extends PageObject {

    @WhenPageOpens
    public void waitForSpinner() {
        WaitUntil.the(ScoreBoardPage.SPINNER, WebElementStateMatchers.isNotVisible());
    }

    public static Target SPINNER = Target.the("Spinner")
            .locatedBy(".loading-spinner-wrapper");

    public static Target CHALLENGE_CARD = Target.the("Challenge Card")
            .locatedBy("challenge-card");

    public static Target SOLVED_CHALLENGE = Target.the("Solved Challenge")
            .locatedBy("//challenge-card[contains(concat(' ', normalize-space(@class), ' '), ' solved ')]//*[text()='{0}']");

}
