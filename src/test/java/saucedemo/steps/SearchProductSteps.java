package saucedemo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import saucedemo.stepLib.LoginActions;
import saucedemo.stepLib.SearchActions;

public class SearchProductSteps {

    @Steps
    private LoginActions loginActions;
    @Steps
    private SearchActions searchActions;

    @Given("user navigated to saucedemo home page")
    public void userNavigatedToHomepage() {
        loginActions.navigateToHomePage();
        loginActions.loginUser();
    }

    @When("user selects the highest price item from the product list")
    public void userSelectsTheHighestPriceItem() {
        searchActions.searchHighestPricedItem();
    }

    @Then("the selected item has added to the cart")
    public void theSelectedItemHasAddedToTheCart() {
        searchActions.hasItemAddedToCart();
    }
}
