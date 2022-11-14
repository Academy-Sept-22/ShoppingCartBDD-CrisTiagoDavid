package shoppingbasket;

import java.util.HashMap;

public class Basket {

    private HashMap<ProductId,Integer> products = new HashMap<>();

    public int getCount() {
        return products.keySet().size();
    }

    public void addProduct(ProductId productId, int quantity) {
        products.put(productId, quantity);
    }

    public int getCountFor(ProductId productId) {
        return products.get(productId);
    }
}
