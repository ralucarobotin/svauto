package api.utils;

import api.domain.cart.items.Skus;

public class CartUtils {

    public static Skus addSkusToCart(int skuId, int quantity){
        Skus item = new Skus();
        item.setSkuId(skuId);
        item.setQuantity(quantity);
        return item;
    }

}
