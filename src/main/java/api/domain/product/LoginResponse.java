package api.domain.product;

import java.util.List;

public class LoginResponse {

    private int id;
    private String first_name;
    private String last_name;
    private String password;
    private String email;
    private String type;
    private String verified;
    private String status;
    private String date_created;
    private String date_last_modified;
    private List<Roles> roles;
    private String tos_accepted;
    private String payment_configured;
    private String token;
    private String refresh_token;
    private String merchant_id;
    private String store_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public String getTos_accepted() {
        return tos_accepted;
    }

    public void setTos_accepted(String tos_accepted) {
        this.tos_accepted = tos_accepted;
    }

    public String getPayment_configured() {
        return payment_configured;
    }

    public void setPayment_configured(String payment_configured) {
        this.payment_configured = payment_configured;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getStore_url() {
        return store_url;
    }

    public void setStore_url(String store_url) {
        this.store_url = store_url;
    }
}
