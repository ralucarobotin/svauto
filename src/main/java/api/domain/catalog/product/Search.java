package api.domain.catalog.product;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
*
*
* @author mmuresan
* @since 2019-09-02
*/
public class Search {

  String query;
  @JsonProperty("merchant_id")
  String merchantId;
  @JsonProperty("category_id")
  String categoryId;
  @JsonProperty("category_slug")
  String categorySlug;
  @JsonProperty("min_commission")
  String minCommission;
  @JsonProperty("max_commission")
  String maxCommission;
  @JsonProperty("min_price")
  String minPrice;
  @JsonProperty("max_price")
  String maxPrice;

  public Search setQuery(String query) {
    this.query = query;
    return this;
  }

  public Search setMerchantId(String merchantId) {
    this.merchantId = merchantId;
    return this;
  }

  public Search setCategoryId(String categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  public Search setCategorySlug(String categorySlug) {
    this.categorySlug = categorySlug;
    return this;
  }

  public Search setMinCommission(String minCommission) {
    this.minCommission = minCommission;
    return this;
  }

  public Search setMaxCommission(String maxCommission) {
    this.maxCommission = maxCommission;
    return this;
  }

  public Search setMinPrice(String minPrice) {
    this.minPrice = minPrice;
    return this;
  }

  public Search setMaxPrice(String maxPrice) {
    this.maxPrice = maxPrice;
    return this;
  }
}
