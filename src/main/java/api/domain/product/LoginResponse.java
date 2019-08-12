package api.domain.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LoginResponse {

    private int id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String password;
    private String email;
    private String type;
    private String verified;
    private String status;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("date_last_modified")
    private String dateLastModified;
    private List<Roles> roles;
    @JsonProperty("tos_accepted")
    private String tosAccepted;
    @JsonProperty("payment_configured")
    private String paymentConfigured;
    private String token;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("merchant_id")
    private String merchantId;
    @JsonProperty("store_url")
    private String storeUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public String getTosAccepted() {
        return tosAccepted;
    }

    public void setTosAccepted(String tosAccepted) {
        this.tosAccepted = tosAccepted;
    }

    public String getPaymentConfigured() {
        return paymentConfigured;
    }

    public void setPaymentConfigured(String paymentConfigured) {
        this.paymentConfigured = paymentConfigured;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }
}
