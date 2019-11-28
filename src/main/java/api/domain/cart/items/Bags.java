package api.domain.cart.items;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Bags {

    private Integer id;
    @JsonProperty("order_id")
    private Integer orderId;
    @JsonProperty("merchant_id")
    private Integer merchantId;
    @JsonProperty("app_id")
    private Integer appId;
    private String status;
    @JsonProperty("fulfillment_status")
    private String fulfillmentStatus;
    @JsonProperty("financial_status")
    private String financialStatus;
    private List<Skus> skus;
    private List<Taxes> taxes;
    private List<Transactions> transactions;
    @JsonProperty("external_checkout")
    private Boolean externalCheckout;
    @JsonProperty("commission_rate")
    private Integer commissionRate;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("remorse_period_ends")
    private String remorsePeriodEnds;
    private String currency;
    @JsonProperty("external_currency")
    private String externalCurrency;
    @JsonProperty("merchant_name")
    private String merchantName;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getFulfillmentStatus() {
        return fulfillmentStatus;
    }
    public void setFulfillmentStatus(String fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
    }

    public String getFinancialStatus() {
        return financialStatus;
    }
    public void setFinancialStatus(String financialStatus) {
        this.financialStatus = financialStatus;
    }

    public List<Skus> getSkus() {
        return skus;
    }
    public void setSkus(List<Skus> values) {
        this.skus = values;
    }

    public List<Taxes> getTaxes() {
        return taxes;
    }
    public void setTaxes(List<Taxes> values) {
        this.taxes = values;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transactions> values) {
        this.transactions = values;
    }

    public Boolean getExternalCheckout() {
        return externalCheckout;
    }
    public void setExternalCheckout(Boolean externalCheckout) {
        this.externalCheckout = externalCheckout;
    }

    public Integer getCommissionRate() {
        return commissionRate;
    }
    public void setCommissionRate(Integer commissionRate) {
        this.commissionRate = commissionRate;
    }

    public String getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getRemorsePeriodEnds() {
        return remorsePeriodEnds;
    }
    public void setRemorsePeriodEnds(String remorsePeriodEnds) {
        this.remorsePeriodEnds = remorsePeriodEnds;
    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExternalCurrency() {
        return externalCurrency;
    }
    public void setExternalCurrency(String externalCurrency) {
        this.externalCurrency = externalCurrency;
    }

    public String getMerchantName() {
        return merchantName;
    }
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
