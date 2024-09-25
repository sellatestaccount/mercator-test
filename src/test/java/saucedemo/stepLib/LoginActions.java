package saucedemo.stepLib;

import saucedemo.config.Configuration;
import saucedemo.pages.HomePage;
import saucedemo.pages.LoginPage;

public class LoginActions {

    private HomePage homePage;
    private LoginPage loginPage;

    public void navigateToHomePage() {
        homePage.launchUrl(Configuration.get("url"));
    }

    public void loginUser() {
        String username = Configuration.get("username");
        String password = Configuration.get("password");
        loginPage.loginUser(username, password);
    }
}
