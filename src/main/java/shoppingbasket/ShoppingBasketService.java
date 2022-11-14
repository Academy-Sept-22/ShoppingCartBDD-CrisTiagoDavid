package shoppingbasket;

import java.util.HashMap;
import java.util.HashSet;

public class ShoppingBasketService {

    private HashMap<UserId, Basket> baskets = new HashMap<>();

    public void addItem(UserId userId, ProductId productId, int quantity) {

        Basket basket = baskets.get(userId);
        if (basket == null) {
            basket = new Basket();
            baskets.put(userId, basket);
        }

        basket.addProduct(productId, quantity);

    }

    public Basket basketFor(UserId userId) {
        return this.baskets.get(userId);
    }
}
