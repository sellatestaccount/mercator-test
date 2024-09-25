package saucedemo.pages;

public class HomePage extends BasePage {

    public void launchUrl(String url) {
        getDriver().close();
        getDriver().manage().deleteAllCookies();
        getDriver().get(url);
    }
}
