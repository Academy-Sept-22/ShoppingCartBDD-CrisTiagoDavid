package shoppingbasket;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StepDefinitions {

    private ShoppingBasketService service;
    private UserId userId;

    @Given("There is no Shopping basket yet")
    public void there_is_no_shopping_basket_yet() {
        service = new ShoppingBasketService();
    }
    @When("I add a product to the Shopping basket")
    public void i_add_a_product_to_the_shopping_basket() {
        userId = new UserId("1");
        ProductId productId = new ProductId("1");
        int quantity = 1;
        service.addItem(userId, productId, quantity);
    }
    @Then("I should create the Shopping basket")
    public void i_should_create_the_shopping_basket() {
        Basket basket = service.basketFor(userId);
        assertNotNull(basket);
    }


}
