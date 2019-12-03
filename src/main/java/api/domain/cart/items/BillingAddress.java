package api.domain.cart.items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillingAddress {

    private String name;
    private String city;
    private String state;
    private String country;
    @JsonProperty("postal_code")
    private String postal_code;
    private String phone;
    private String type;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("address_1")
    private String address_1;
    @JsonProperty("address_2")
    private String address_2;

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

    public String getPostalCode() {
        return postal_code;
    }
    public void setPostalCode(String postalCode) {
        this.postal_code = postalCode;
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

    public String getAddress1() {
        return address_1;
    }
    public void setAddress1(String address1) {
        this.address_1 = address1;
    }

    public String getAddress2() {
        return address_2;
    }
    public void setAddress2(String address2) {
        this.address_2 = address2;
    }
}
