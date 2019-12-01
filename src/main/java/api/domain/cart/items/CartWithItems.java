package api.domain.cart.items;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CartWithItems {

    private Integer id;
    private String token;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("app_id")
    private Integer appId;
    @JsonProperty("developer_id")
    private Integer developerId;
    private List<Bags> bags;
    @JsonProperty("shipping_address")
    private List<ShippingAddress> shippingAddress;
    @JsonProperty("billing_address")
    private List<BillingAddress> billingAddress;
    private String status;
    @JsonProperty("data_created")
    private String dataCreated;
    @JsonProperty("data_last_modified")
    private String dataLastModified;
    private Boolean priced;
    private String currency;
    @JsonProperty("currency_symbol")
    private String currencySymbol;
    @JsonProperty("stripe_key")
    private String stripeKey;
    private Boolean guest;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAppId() {
        return appId;
    }
    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getDeveloperId() {
        return developerId;
    }
    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public List<Bags> getBags() {
        return bags;
    }
    public void setBags(List<Bags> values) {
        this.bags = values;
    }

    public List<ShippingAddress> getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(List<ShippingAddress> values) {
        this.shippingAddress = values;
    }

    public List<BillingAddress> getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(List<BillingAddress> values) {
        this.billingAddress = values;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataCreated() {
        return dataCreated;
    }
    public void setDataCreated(String dataCreated) {
        this.dataCreated = dataCreated;
    }

    public String getDataLastModified() {
        return dataLastModified;
    }
    public void setDataLastModified(String dataLastModified) {
        this.dataLastModified = dataLastModified;
    }

    public Boolean getPriced() {
        return priced;
    }
    public void setPriced(Boolean priced) {
        this.priced = priced;
    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }
    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getStripeKey() {
        return stripeKey;
    }
    public void setStripeKey(String stripeKey) {
        this.stripeKey = stripeKey;
    }

    public Boolean getGuest() {
        return guest;
    }
    public void setGuest(Boolean guest) {
        this.guest = guest;
    }
}
