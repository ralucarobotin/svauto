package pages;


public class Account {

    //YOUR PERSONAL INFORMATION
    private int genderMale;
    private int genderFemale;
    private String customerFirstName;
    private String customerLastName;
    private String email;
    private String password;
    private int days;
    private String months;
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
    private int postcode;
    private String country;
    private String otherInfo;
    private String phone;
    private String mobilePhone;
    private String alias;

    public int getGenderMale() {
        return genderMale;
    }

    public int getGenderFemale() {
        return genderFemale;
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

    public String getMonths() {
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

    public int getPostcode() {
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
        private int genderMale;
        private int genderFemale;
        private String customerFirstName;
        private String customerLastName;
        private String email;
        private String password;
        private int days;
        private String months;
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
        private int postcode;
        private String country;
        private String otherInfo;
        private String phone;
        private String mobilePhone;
        private String alias;

        public Builder genderMale(final int genderMale){
            this.genderMale = genderMale;
            return this;
        }

        public Builder genderFemale(final int genderFemale){
            this.genderFemale = genderFemale;
            return this;
        }

        public Builder customerFirstName(final String customerFirstName){
            this.customerFirstName = customerFirstName;
            return this;
        }

        public Builder customerLastName(final String customerLastName){
            this.customerLastName = customerLastName;
            return this;
        }

        public Builder email(final String email){
            this.email = email;
            return this;
        }

        public Builder password(final String password){
            this.password = password;
            return this;
        }

        public Builder days(final int days){
            this.days = days;
            return this;
        }

        public Builder months(final String months){
            this.months = months;
            return this;
        }

        public Builder years(final int years){
            this.years = years;
            return this;
        }

        public Builder newsletter(final int newsletter){
            this.newsletter = newsletter;
            return this;
        }

        public Builder optIn(final int optIn){
            this.optIn = optIn;
            return this;
        }

        public Builder firstName(final String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(final String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder company(final String company){
            this.company = company;
            return this;
        }

        public Builder firstAddress(final String firstAddress){
            this.firstAddress = firstAddress;
            return this;
        }

        public Builder secondAddress(final String secondAddress){
            this.secondAddress = secondAddress;
            return this;
        }

        public Builder city(final String city){
            this.city = city;
            return this;
        }

        public Builder state(final String state){
            this.state = state;
            return this;
        }

        public Builder postcode(final int postcode){
            this.postcode = postcode;
            return this;
        }

        public Builder country(final String country){
            this.country = country;
            return this;
        }

        public Builder otherInfo(final String otherInfo){
            this.otherInfo = otherInfo;
            return this;
        }

        public Builder phone(final String phone){
            this.phone = phone;
            return this;
        }

        public Builder mobilePhone(final String mobilePhone){
            this.mobilePhone = mobilePhone;
            return this;
        }

        public Builder alias(final String alias){
            this.alias = alias;
            return this;
        }

        public Account build(){
            Account account =  new Account();
            account.genderMale = this.genderMale;
            account.genderFemale = this.genderFemale;
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

    private Account(){

    }
}
