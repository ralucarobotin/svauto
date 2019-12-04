package api.domain.cart.items;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.google.gson.annotations.SerializedName;

public class BillingAddress {

    private String name;
    private String city;
    private String state;
    private String country;
    @SerializedName("postal_code")
    private String postalCode;
    private String phone;
    private String type;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @SerializedName("address_1")
    private String address1;
    @SerializedName("address_2")
    private String address2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonGetter("postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonSetter("postal_code")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonGetter("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonSetter("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonGetter("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonSetter("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonGetter("address_1")
    public String getAddress1() {
        return address1;
    }

    @JsonSetter("address_1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @JsonGetter("address_2")
    public String getAddress2() {
        return address2;
    }

    @JsonSetter("address_2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
}
