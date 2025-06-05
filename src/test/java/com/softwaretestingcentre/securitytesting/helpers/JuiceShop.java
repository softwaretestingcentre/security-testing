package com.softwaretestingcentre.securitytesting.helpers;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class JuiceShop {
    public static Performable dismissDialogs() {
        return Task.where("{0} dismisses the dialogs",
                Click.on(HomePage.ACCEPT_COOKIES),
                Click.on(HomePage.DISMISS_WELCOME_MESSAGE)
        );

    }
}
