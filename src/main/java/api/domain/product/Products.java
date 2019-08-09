package api.domain.product;

import java.math.BigInteger;
import java.util.List;

public class Products {
    private String id;
    private String name;
    private String description;
    private String brand;
    private Boolean available;
    private Boolean visible;
    private Integer total_sales;
    private String type;
    private String currency;
    private BigInteger min_price;
    private BigInteger max_price;
    private List<Variant> variants;
    private List<Categories> categories;
    private List<String> meta;
    private List<String> tags;
    private List<String> related_product_ids;
    private List<String> cross_sale_product_ids;
    private List<String> gtins;
    private String default_image_url;
    private BigInteger qty_available;
    private List<Integer> merchant_ids;
    private String date_created;
    private String date_last_modified;

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

    public Integer getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(Integer total_sales) {
        this.total_sales = total_sales;
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

    public BigInteger getMin_price() {
        return min_price;
    }

    public void setMin_price(BigInteger min_price) {
        this.min_price = min_price;
    }

    public BigInteger getMax_price() {
        return max_price;
    }

    public void setMax_price(BigInteger max_price) {
        this.max_price = max_price;
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

    public List<String> getRelated_product_ids() {
        return related_product_ids;
    }

    public void setRelated_product_ids(List<String> related_product_ids) {
        this.related_product_ids = related_product_ids;
    }

    public List<String> getCross_sale_product_ids() {
        return cross_sale_product_ids;
    }

    public void setCross_sale_product_ids(List<String> cross_sale_product_ids) {
        this.cross_sale_product_ids = cross_sale_product_ids;
    }

    public List<String> getGtins() {
        return gtins;
    }

    public void setGtins(List<String> gtins) {
        this.gtins = gtins;
    }

    public String getDefault_image_url() {
        return default_image_url;
    }

    public void setDefault_image_url(String default_image_url) {
        this.default_image_url = default_image_url;
    }

    public BigInteger getQty_available() {
        return qty_available;
    }

    public void setQty_available(BigInteger qty_available) {
        this.qty_available = qty_available;
    }

    public List<Integer> getMerchant_ids() {
        return merchant_ids;
    }

    public void setMerchant_ids(List<Integer> merchant_ids) {
        this.merchant_ids = merchant_ids;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_last_modified() {
        return date_last_modified;
    }

    public void setDate_last_modified(String date_last_modified) {
        this.date_last_modified = date_last_modified;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
