package tests;

public class UserAccount {
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

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAlias() {
        return alias;
    }

    public static class Builder {
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

        public UserAccount build() {
            //Here we create the actual user account object, which is always in a fully initialised state when it's returned.
            UserAccount account = new UserAccount();
            account.customerFirstName = this.customerFirstName;
            account.customerLastName = this.customerLastName;
            account.passwordNew = this.passwordNew;
            account.day = this.day;
            account.month = this.month;
            account.year = this.year;
            account.firstName = this.firstName;
            account.lastName = this.lastName;
            account.company = this.company;
            account.address1 = this.address1;
            account.address2 = this.address2;
            account.city = this.city;
            account.country = this.country;
            account.postalCode = this.postalCode;
            account.state = this.state;
            account.additionalInfo = this.additionalInfo;
            account.phone = this.phone;
            account.mobilePhone = this.mobilePhone;
            account.alias = this.alias;

            return account;
        }
    }

    private UserAccount() {
    }
}

//    UserAccount account = new UserAccount.Builder()
//            .withCustomerFirstName(fillInCustomerFirstName())
//            .withCustomerLastName()
//            .withPass()
//            .withDay()
//            .withMonth()
//            .withYear()
//            .withFirstName()
//            .withLastName()
//            .withCompany()
//            .withAddress1()
//            .withAddress2()
//            .withCity()
//            .withState()
//            .withCountrySelect()
//            .withPostalCode()
//            .withCountry()
//            .withAdditionalInfo()
//            .withPhone()
//            .withMobilePhone()
//            .withAlias()
//
//            .build();

