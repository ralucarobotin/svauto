package tests;

public class Account {

    //YOUR PERSONAL INFORMATION
    private boolean gender;
    private String customerFirstName;
    private String customerLastName;
    private String email;
    private String password;
    private int days;
    private int months;
    private int years;
    private int newsletter;
    private int optIn;

    //YOUR ADDRESS
    private String firstName;
    private String lastName;
    private String company;
    private String firstAddress;
    private String secondAddress;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private String otherInfo;
    private String phone;
    private String mobilePhone;
    private String alias;

    private Account() {
    }

    public boolean getGender() {
        return gender;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getDays() {
        return days;
    }

    public int getMonths() {
        return months;
    }

    public int getYears() {
        return years;
    }

    public int getNewsletter() {
        return newsletter;
    }

    public int getOptIn() {
        return optIn;
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

    public String getFirstAddress() {
        return firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostCode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getOtherInfo() {
        return otherInfo;
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
        private boolean gender;
        private String customerFirstName;
        private String customerLastName;
        private String email;
        private String password;
        private int days;
        private int months;
        private int years;
        private int newsletter;
        private int optIn;
        private String firstName;
        private String lastName;
        private String company;
        private String firstAddress;
        private String secondAddress;
        private String city;
        private String state;
        private String postcode;
        private String country;
        private String otherInfo;
        private String phone;
        private String mobilePhone;
        private String alias;

        public Builder gender(boolean gender) {
            this.gender = gender;
            return this;
        }

        public Builder customerFirstName(String customerFirstName) {
            this.customerFirstName = customerFirstName;
            return this;
        }

        public Builder customerLastName(String customerLastName) {
            this.customerLastName = customerLastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder days(int days) {
            this.days = days;
            return this;
        }

        public Builder months(int months) {
            this.months = months;
            return this;
        }

        public Builder years(int years) {
            this.years = years;
            return this;
        }

        public Builder newsletter(int newsletter) {
            this.newsletter = newsletter;
            return this;
        }

        public Builder optIn(int optIn) {
            this.optIn = optIn;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder firstAddress(String firstAddress) {
            this.firstAddress = firstAddress;
            return this;
        }

        public Builder secondAddress(String secondAddress) {
            this.secondAddress = secondAddress;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder postCode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder otherInfo(String otherInfo) {
            this.otherInfo = otherInfo;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder mobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public Builder alias(String alias) {
            this.alias = alias;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.gender = this.gender;
            account.customerFirstName = this.customerFirstName;
            account.customerLastName = this.customerLastName;
            account.email = this.email;
            account.password = this.password;
            account.days = this.days;
            account.months = this.months;
            account.years = this.years;
            account.newsletter = this.newsletter;
            account.optIn = this.optIn;
            account.firstName = this.firstName;
            account.lastName = this.lastName;
            account.company = this.company;
            account.firstAddress = this.firstAddress;
            account.secondAddress = this.secondAddress;
            account.city = this.city;
            account.state = this.state;
            account.postcode = this.postcode;
            account.country = this.country;
            account.otherInfo = this.otherInfo;
            account.phone = this.phone;
            account.mobilePhone = this.mobilePhone;
            account.alias = this.alias;

            return account;
        }
    }
}
