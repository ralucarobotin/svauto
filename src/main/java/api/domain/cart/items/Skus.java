package api.domain.cart.items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Skus {

    private Integer id;
    @JsonProperty("merchant_id")
    private Integer merchantId;
    @JsonProperty("app_id")
    private Integer appId;
    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("sku_id")
    private Integer sku_id;
    @JsonProperty("external_id")
    private String externalId;
    private String name;
    private String brand;
    private String thumbnail;
    private Integer quantity;
    private Integer price;
    private Integer weight;
    private Integer height;
    private Integer width;
    private Integer length;
    private Boolean available;
    @JsonProperty("line_price")
    private Integer linePrice;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantId() {
        return merchantId;
    }
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getAppId() {
        return appId;
    }
    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getSkuId() { return sku_id; }
    public void setSkuId(Integer skuId) {
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

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }
    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getLinePrice() {
        return linePrice;
    }
    public void setLinePrice(Integer linePrice) {
        this.linePrice = linePrice;
    }
}
