package saucedemo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchPage extends  BasePage {

    @FindBy(className = "pricebar")
    private List<WebElementFacade> itemPrices;

    @FindBy(className = "shopping_cart_link")
    private WebElementFacade shoppingCartLink;

    @FindBy(className = "cart_item")
    private List<WebElementFacade> cartItems;

    public void selectHighestPricedItem() {
        List<String> priceList = new ArrayList<>();
        By inventoryItemPrice = By.className("inventory_item_price");
        By addToCart = By.xpath("//button[contains(@class, 'btn_inventory')]");

        for (WebElementFacade element : itemPrices) {
            WebElement itemPrice = element.findElement(inventoryItemPrice);
            priceList.add(itemPrice.getText().replaceAll("^\\$", "").trim());
        }
        double maxPrice = priceList.stream()
                .mapToDouble(Double::parseDouble)
                .max().orElseThrow(NoSuchElementException::new);
        WebElement priceElement = itemPrices.stream()
                .filter(elementFacade -> elementFacade.findBy(inventoryItemPrice).getText().contains(String.valueOf(maxPrice)))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        priceElement.findElement(addToCart).click();
    }

    public List<WebElementFacade> getCartItems() {
        clickOnShoppingCart();
        return cartItems;
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCartLink);
    }
}
