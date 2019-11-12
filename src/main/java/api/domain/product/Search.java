package api.domain.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {

  private String query;
  @JsonProperty("merchant_id")
  private String merchantId;
  @JsonProperty("category_id")
  private String categoryId;
  @JsonProperty("category_slug")
  private String categorySlug;
  @JsonProperty("min_commission")
  private String minCommission;
  @JsonProperty("max_commission")
  private String maxCommission;
  @JsonProperty("min_price")
  private String minPrice;
  @JsonProperty("max_price")
  private String maxPrice;

  public String getQuery() {
    return query;
  }

  public Search setQuery(String query) {
    this.query = query;
    return this;
  }

  public String getMerchantId() {
    return merchantId;
  }

  public Search setMerchantId(String merchantId) {
    this.merchantId = merchantId;
    return this;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public Search setCategoryId(String categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  public String getCategorySlug() {
    return categorySlug;
  }

  public Search setCategorySlug(String categorySlug) {
    this.categorySlug = categorySlug;
    return this;
  }

  public String getMinCommission() {
    return minCommission;
  }

  public Search setMinCommission(String minCommission) {
    this.minCommission = minCommission;
    return this;
  }

  public String getMaxCommission() {
    return maxCommission;
  }

  public Search setMaxCommission(String maxCommission) {
    this.maxCommission = maxCommission;
    return this;
  }

  public String getMinPrice() {
    return minPrice;
  }

  public Search setMinPrice(String minPrice) {
    this.minPrice = minPrice;
    return this;
  }

  public String getMaxPrice() {
    return maxPrice;
  }

  public Search setMaxPrice(String maxPrice) {
    this.maxPrice = maxPrice;
    return this;
  }
}
