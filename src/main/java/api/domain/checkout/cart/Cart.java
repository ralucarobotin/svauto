package api.domain.checkout.cart;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cart {

    private Integer id;
    private String token;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("app_id")
    private Integer appId;
    @JsonProperty("developer_id")
    private Integer developerId;
    private String status;
    @JsonProperty("data_created")
    private String dataCreated;
    @JsonProperty("data_last_modified")
    private String dataLastModified;
    private Boolean priced;
    private String currency;
    @JsonProperty("currency_symbol")
    private String currencySymbol;
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

    public Boolean getGuest() {
        return guest;
    }

    public void setGuest(Boolean guest) {
        this.guest = guest;
    }
}
