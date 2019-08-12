package api.domain.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.List;

public class Products {
    private String id;
    private String name;
    private String description;
    private String brand;
    private Boolean available;
    private Boolean visible;
    @JsonProperty("total_sales")
    private Integer totalSales;
    private String type;
    private String currency;
    @JsonProperty("min_price")
    private BigInteger minPrice;
    @JsonProperty("max_price")
    private BigInteger maxPrice;
    private List<Variant> variants;
    private List<Categories> categories;
    private List<String> meta;
    private List<String> tags;
    @JsonProperty("related_product_ids")
    private List<String> relatedProduct_ids;
    @JsonProperty("cross_sale_product_ids")
    private List<String> crossSaleProductIds;
    private List<String> gtins;
    @JsonProperty("default_image_url")
    private String defaultImageUrl;
    @JsonProperty("qty_available")
    private BigInteger qtyAvailable;
    @JsonProperty("merchant_ids")
    private List<Integer> merchantIds;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("date_last_modified")
    private String dateLastModified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigInteger getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigInteger minPrice) {
        this.minPrice = minPrice;
    }

    public BigInteger getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigInteger maxPrice) {
        this.maxPrice = maxPrice;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<String> getMeta() {
        return meta;
    }

    public void setMeta(List<String> meta) {
        this.meta = meta;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getRelatedProduct_ids() {
        return relatedProduct_ids;
    }

    public void setRelatedProduct_ids(List<String> relatedProduct_ids) {
        this.relatedProduct_ids = relatedProduct_ids;
    }

    public List<String> getCrossSaleProductIds() {
        return crossSaleProductIds;
    }

    public void setCrossSaleProductIds(List<String> crossSaleProductIds) {
        this.crossSaleProductIds = crossSaleProductIds;
    }

    public List<String> getGtins() {
        return gtins;
    }

    public void setGtins(List<String> gtins) {
        this.gtins = gtins;
    }

    public String getDefaultImageUrl() {
        return defaultImageUrl;
    }

    public void setDefaultImageUrl(String defaultImageUrl) {
        this.defaultImageUrl = defaultImageUrl;
    }

    public BigInteger getQtyAvailable() {
        return qtyAvailable;
    }

    public void setQtyAvailable(BigInteger qtyAvailable) {
        this.qtyAvailable = qtyAvailable;
    }

    public List<Integer> getMerchantIds() {
        return merchantIds;
    }

    public void setMerchantIds(List<Integer> merchantIds) {
        this.merchantIds = merchantIds;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(String dateLastModified) {
        this.dateLastModified = dateLastModified;
    }
}
