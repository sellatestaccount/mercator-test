package saucedemo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElementFacade username;

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(id = "login-button")
    private WebElementFacade loginButton;

    public void loginUser(String username, String password) {
        this.username.type(username);
        this.password.type(password);
        clickOnElement(loginButton);
    }
}
