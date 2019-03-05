package tests;

public class Account {
    private String gender;
    private String firstName;
    private String lastName;
    //    private String email;
    private String password;
    //    private int dayOfBirth;
//    private String monthOfBirth;
//    private int yearOfBirth;
//    private boolean newsletterAccept;
//    private boolean specialOffersAccept;
//    private String firstNameAddress;
//    private String lastNameAddress;
//    private String companyAddress;
    private String address1Address;
//    private String address2Address;
    private String cityAddress;
    private String stateOptionAddress;
    private String zipAddress;
    private String countryOptionAddress;
//    private String additionalInfo;
    private String homePhone;
    private String mobilePhone;
//    private String alias;

    private Account(Builder builder) {
        this.gender = builder.gender;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.homePhone = builder.homePhone;
        this.mobilePhone = builder.mobilePhone;
        this.address1Address = builder.address1Address;
        this.cityAddress = builder.cityAddress;
        this.zipAddress = builder.zipAddress;
        this.countryOptionAddress = builder.countryOptionAddress;
        this.stateOptionAddress = builder.stateOptionAddress;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAddress1Address() {
        return address1Address;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public String getZipAddress() {
        return zipAddress;
    }

    public String getCountryOptionAddress() {
        return countryOptionAddress;
    }

    public String getStateOptionAddress() {
        return stateOptionAddress;
    }

    public static class Builder {
        private String gender;
        private String firstName;
        private String lastName;
        //        private String email;
        private String password;
        //        private int dayOfBirth;
//        private String monthOfBirth;
//        private int yearOfBirth;
//        private boolean newsletterAccept;
//        private boolean specialOffersAccept;
//        private String firstNameAddress;
//        private String lastNameAddress;
//        private String companyAddress;
        private String address1Address;
//        private String address2Address;
        private String cityAddress;
        private String stateOptionAddress;
        private String zipAddress;
        private String countryOptionAddress;
//        private String additionalInfo;
        private String homePhone;
        private String mobilePhone;
//        private String alias;

        public Builder gender(String gender) {
            this.gender = gender;
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

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder homePhone(String homePhone) {
            this.homePhone = homePhone;
            return this;
        }

        public Builder mobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public Builder address1(String address){
            this.address1Address = address;
            return  this;
        }

        public Builder city(String city){
            this.cityAddress = city;
            return this;
        }

        public Builder zip(String zip){
            this.zipAddress = zip;
            return this;
        }

        public Builder country(String country){
            this.countryOptionAddress = country;
            return  this;
        }

        public Builder state(String state){
            this.stateOptionAddress = state;
            return this;
        }

        public Account build() {
            return new Account(this);
        }

    }
}
