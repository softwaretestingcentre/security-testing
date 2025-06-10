package com.softwaretestingcentre.securitytesting.helpers;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.WhenPageOpens;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Cookie;

@DefaultUrl("https://stc-owasp-juice-dnebatcgf2ddf4cr.uksouth-01.azurewebsites.net/#/")
//@DefaultUrl("http://localhost:3000/#/")
public class HomePage extends PageObject {

    @WhenPageOpens
    public void setCookies() {
        if (getDriver().manage().getCookieNamed("cookieconsent_status") == null) {
            getDriver().manage().addCookie(new Cookie("cookieconsent_status", "dismiss"));
            getDriver().manage().addCookie(new Cookie("welcomebanner_status", "dismiss"));
            getDriver().manage().addCookie(new Cookie("language", "en"));
            getDriver().navigate().refresh();
        }
    }

    public static Target JUICE_LINK = Target.the("Juice {0}")
            .locatedBy("//div[@class='item-name' and contains(., '{0}')]");

    public static Target JUICE_DETAILS = Target.the("Details for {0}")
            .locatedBy("//app-product-details//h1[contains(., '{0}')]");

    public static Target JUICE_STRAPLINE = Target.the("Strapline is {0}")
            .locatedBy("//app-product-details//div[contains(., '{0}')]");

    public static Target SEARCH_BUTTON = Target.the("Search button")
            .locatedBy("#searchQuery");

    public static Target SEARCH_INPUT = Target.the("Search input")
            .locatedBy("app-mat-search-bar input");

}
