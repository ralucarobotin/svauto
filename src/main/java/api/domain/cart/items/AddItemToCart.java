package api.domain.cart.items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddItemToCart {

    private String id;
    @JsonProperty("merchant_id")
    private String merchantId;
    @JsonProperty("app_id")
    private String appId;
    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("sku_id")
    private String sku_id;
    @JsonProperty("external_id")
    private String externalId;
    private String name;
    private String thumbnail;
    private String quantity;
    private String price;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getAppId() {
        return appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSkuId() {
        return sku_id;
    }
    public void setSkuId(String skuId) {
        this.sku_id = skuId;
    }

    public String getExternalId() {
        return externalId;
    }
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
