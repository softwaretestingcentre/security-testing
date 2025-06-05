package com.softwaretestingcentre.securitytesting.helpers;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

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
}
