package saucedemo.stepLib;

import org.junit.Assert;
import saucedemo.pages.SearchPage;

public class SearchActions {

    private SearchPage searchPage;

    public void searchHighestPricedItem() {
        searchPage.selectHighestPricedItem();
    }

    public void hasItemAddedToCart() {
        searchPage.clickOnShoppingCart();
        Assert.assertFalse(searchPage.getCartItems().isEmpty());
    }
}
