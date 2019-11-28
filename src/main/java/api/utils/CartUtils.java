package api.utils;

import api.domain.cart.items.AddItemToCart;

public class CartUtils {

    public static AddItemToCart addItemToCart(String skuId, String quantity){
        AddItemToCart item = new AddItemToCart();
        item.setSkuId(skuId);
        item.setQuantity(quantity);
        return item;
    }

}
