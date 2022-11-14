package shoppingbasket;

import io.cucumber.java.en.*;
import io.cucumber.java.es.*;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    private ShoppingBasketService service = new ShoppingBasketService();
    private UserId userId;

    @Dado("There is no Shopping basket yet for user {string}")
    public void there_is_no_shopping_basket_yet(String userName) {
        Basket basket = service.basketFor(new UserId(userName));
        assertNull(basket);
    }

    @Entonces("I should have a Shopping basket created")
    public void i_should_have_a_shopping_basket() {
        Basket basket = service.basketFor(userId);
        assertNotNull(basket);
    }

    @Entonces("I should have {int} products in the Shopping basket")
    public void iShouldHaveProductsInTheShoppingBasket(int numberOfProducts) {
        Basket basket = service.basketFor(userId);
        assertEquals(numberOfProducts, basket.getCount());
    }

    @When("I add {int} item of product {string} to the Shopping basket")
    public void iAddItemOfProductToTheShoppingBasket(int quantity, String productName) {
        ProductId productId = new ProductId(productName);
        service.addItem(userId, productId, quantity);
    }


    @Given("I am user {string}")
    public void iAmUser(String userName) {
        userId = new UserId(userName);
    }

    @And("My basket should have {int} item of product {string}")
    public void myBasketShouldHaveItemOfProduct(int quantity, String productName) {
        Basket basket = service.basketFor(userId);
        assertEquals(quantity, basket.getCountFor(new ProductId(productName)));
    }

    @And("I close the store and reopen it")
    public void iCloseTheStoreAndReopenIt() {
        service = new ShoppingBasketService();
    }
}
