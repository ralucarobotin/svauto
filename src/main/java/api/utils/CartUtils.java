package api.utils;

import api.domain.cart.items.Skus;

public class CartUtils {

    /**
     * Adds an item to the card by it's SKU
     *
     * @param skuId this is the sku_id of the item to be added to the cart
     * @param quantity this is the quantity of the item to be added to the cart
     *
     * @return body with the SKU of the item and the quantity
     */
    public static Skus addSkusToCart(int skuId, int quantity){
        Skus item = new Skus();
        item.setSkuId(skuId);
        item.setQuantity(quantity);
        return item;
    }
}
