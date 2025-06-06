package com.softwaretestingcentre.securitytesting.helpers;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://stc-owasp-juice-dnebatcgf2ddf4cr.uksouth-01.azurewebsites.net/#/")
//@DefaultUrl("http://localhost:3000/#/")
public class HomePage extends PageObject {

    public static Target ACCEPT_COOKIES = Target.the("Accept cookies")
            .locatedBy("[aria-label='dismiss cookie message']");

    public static Target DISMISS_WELCOME_MESSAGE = Target.the("Dismiss Welcome Message")
            .locatedBy("[aria-label='Close Welcome Banner']");

    public static Target JUICE_LINK = Target.the("Juice {0}")
            .locatedBy("//div[@class='item-name' and contains(., '{0}')]");

    public static Target JUICE_DETAILS = Target.the("Details for {0}")
            .locatedBy("//app-product-details//h1[contains(., '{0}')]");

    public static Target JUICE_STRAPLINE = Target.the("Strapline is {0}")
            .locatedBy("//app-product-details//div[contains(., '{0}')]");

}
