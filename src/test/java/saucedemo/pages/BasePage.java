package saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BasePage extends PageObject {

    public void clickOnElement(WebElementFacade webElementFacade) {
        webElementFacade.click();
    }
}
