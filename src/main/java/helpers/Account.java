package helpers;

public class Account {
    private String gender_male;
    private String gender_female;
    private String personalInfo_firstName;
    private String personalInfo_lastName;
    private String personalInfo_emailField;
    private String passwordField;
    private int birthDate_day;
    private int birthDate_month;
    private int birthDate_year;
    private String address_firstName;
    private String address_lastName;
    private String address_company;
    private String address_streetAddress;
    private String address_city;
    private String address_state;
    private String address_postcode;
    private String address_country;
    private String address_mobilePhone;
    private String address_alias;

    private Account(Builder builder) {
        this.personalInfo_firstName = builder.personalInfo_firstName;
        this.personalInfo_lastName = builder.personalInfo_lastName;
        this.personalInfo_emailField = builder.personalInfo_emailField;
        this.passwordField = builder.passwordField;
        this.address_streetAddress = builder.address_streetAddress;
        this.address_city = builder.address_city;
        this.address_country = builder.address_country;
        this.address_state = builder.address_state;
        this.address_postcode = builder.address_postcode;
        this.address_mobilePhone = builder.address_mobilePhone;
        this.address_alias = builder.address_alias;
    }

    public static class Builder {

        private String gender_male;
        private String gender_female;
        private String personalInfo_firstName;
        private String personalInfo_lastName;
        private String personalInfo_emailField;
        private String passwordField;
        private int birthDate_day;
        private int birthDate_month;
        private int birthDate_year;
        private String address_firstName;
        private String address_lastName;
        private String address_company;
        private String address_streetAddress;
        private String address_city;
        private String address_state;
        private String address_postcode;
        private String address_country;
        private String address_mobilePhone;
        private String address_alias;

        public Builder setGender_male(String gender_male) {
            this.gender_male = gender_male;
            return this;
        }

        public Builder setGender_female(String gender_female) {
            this.gender_female = gender_female;
            return this;
        }

        public Builder setBirthDate_day(int birthDate_day) {
            this.birthDate_day = birthDate_day;
            return this;
        }

        public Builder setBirthDate_month(int birthDate_month) {
            this.birthDate_month = birthDate_month;
            return this;
        }

        public Builder setBirthDate_year(int birthDate_year) {
            this.birthDate_year = birthDate_year;
            return this;
        }

        public Builder setAddress_firstName(String address_firstName) {
            this.address_firstName = address_firstName;
            return this;
        }

        public Builder setAddress_lastName(String address_lastName) {
            this.address_lastName = address_lastName;
            return this;
        }

        public Builder setAddress_company(String address_company) {
            this.address_company = address_company;
            return this;
        }


        public Builder(String personalInfo_firstName, String personalInfo_lastName, String personalInfo_emailField, String passwordField, String address_streetAddress, String address_city, String address_country, String address_state, String address_postcode, String address_mobilePhone, String address_alias) {
            this.personalInfo_firstName = personalInfo_firstName;
            this.personalInfo_lastName = personalInfo_lastName;
            this.personalInfo_emailField = personalInfo_emailField;
            this.passwordField = passwordField;
            this.address_streetAddress = address_streetAddress;
            this.address_city = address_city;
            this.address_country = address_country;
            this.address_state = address_state;
            this.address_postcode = address_postcode;
            this.address_mobilePhone = address_mobilePhone;
            this.address_alias = address_alias;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
