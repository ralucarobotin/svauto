package tests;

import static helpers.WebElementHelper.*;

public class UserAccount {
    private String genderMale;
    private String genderFemale;
    private String customerFirstName;
    private String customerLastName;
    private String passwordNew;
    private String day;
    private String month;
    private String year;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String additionalInfo;
    private String phone;
    private String mobilePhone;
    private String alias;

    public String getGenderMale() {
        return this.genderMale;
    }
    public String getGenderFemale() {
        return this.genderFemale;
    }
    public String getCustomerFirstName() {
        return this.customerFirstName;
    }
    public String getCustomerLastName() {
        return this.customerLastName;
    }
    public String getPasswordNew() {
        return this.passwordNew;
    }
    public String getDay() {
        return this.day;
    }
    public String getMonth() {
        return this.month;
    }
    public String getYear() {
        return this.year;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getCompany() {
        return this.company;
    }
    public String getAddress1() {
        return this.address1;
    }
    public String getAddress2() {
        return this.address2;
    }
    public String getCity() {
        return this.city;
    }
    public String getState() {
        return this.state;
    }
    public String getPostalCode() {
        return this.postalCode;
    }
    public String getCountry() {
        return this.country;
    }
    public String getAdditionalInfo() {
        return this.additionalInfo;
    }
    public String getPhone() {
        return this.phone;
    }
    public String getMobilePhone() {
        return this.mobilePhone;
    }
    public String getAlias() {
        return this.alias;
    }

    private UserAccount(Builder builder) {
        this.genderMale = builder.genderMale;
        this.genderFemale = builder.genderFemale;
        this.customerFirstName = builder.customerFirstName;
        this.customerLastName = builder.customerLastName;
        this.passwordNew = builder.passwordNew;
        this.day = builder.day;
        this.month = builder.month;
        this.year = builder.year;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.company = builder.company;
        this.address1 = builder.address1;
        this.address2 = builder.address2;
        this.city = builder.city;
        this.country = builder.country;
        this.postalCode = builder.postalCode;
        this.state = builder.state;
        this.additionalInfo = builder.additionalInfo;
        this.phone = builder.phone;
        this.mobilePhone = builder.mobilePhone;
        this.alias = builder.alias;
    }

    public static class Builder {
        private String genderMale;
        private String genderFemale;
        private String customerFirstName = generateRandomString();
        private String customerLastName = generateRandomString();
        private String passwordNew = generateRandomPassword();
        private String day;
        private String month;
        private String year;
        private String firstName = generateRandomString();
        private String lastName = generateRandomString();
        private String company = generateRandomString();
        private String address1 = generateRandomString();
        private String address2 = generateRandomString();
        private String city = generateRandomString();
        private String state = generateRandomState();
        private String postalCode = generateRandomPostalCode();
        private String country;
        private String additionalInfo = generateRandomString();
        private String phone = generateRandomNumber();
        private String mobilePhone = generateRandomNumber();
        private String alias = generateRandomString();

        public Builder withGenderMale(String genderMale) {
            this.genderMale = genderMale;
            return this;
        }
        public Builder withGenderFemale(String genderFemale) {
            this.genderFemale = genderFemale;
            return this;
        }
        public Builder withCustomerFirstName(String customerFirstName) {
            this.customerFirstName = customerFirstName;
            return this;
        }
        public Builder withCustomerLastName(String customerLastName) {
            this.customerLastName = customerLastName;
            return this;
        }
        public Builder withPass(String passwordNew) {
            this.passwordNew = passwordNew;
            return this;
        }
        public Builder withDay(String day) {
            this.day = day;
            return this;
        }
        public Builder withMonth(String month) {
            this.month = month;
            return this;
        }
        public Builder withYear(String year) {
            this.year = year;
            return this;
        }
        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder withCompany(String company) {
            this.company = company;
            return this;
        }
        public Builder withAddress1(String address1) {
            this.address1 = address1;
            return this;
        }
        public Builder withAddress2(String address2) {
            this.address2 = address2;
            return this;
        }
        public Builder withCity(String city) {
            this.city = city;
            return this;
        }
        public Builder withState(String state) {
            this.state = state;
            return this;
        }
        public Builder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }
        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }
        public Builder withAdditionalInfo(String additionalInfo) {
            this.additionalInfo = additionalInfo;
            return this;
        }
        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder withMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }
        public Builder withAlias(String alias) {
            this.alias = alias;
            return this;
        }
        public String toString()
        {
            return this.customerFirstName + this.customerLastName + this.passwordNew + this.day + this.month + this.year +
                    this.firstName + this.lastName + this.company + this.address1 + this.address2 + this.city + this.postalCode +
                    this.country + this.state + this.phone + this.mobilePhone + this.alias;
        }
        public UserAccount build() {
            return new UserAccount(this);
        }
    }
}

