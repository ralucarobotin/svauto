package helpers;

public class AccountBuilder {
    private boolean gender = true;
    private String personalInfo_firstName = Utilities.generateRandomAlphabetic();
    private String personalInfo_lastName = Utilities.generateRandomAlphabetic();
    private String personalInfo_emailField = Utilities.generateEmail();
    private String passwordField = Utilities.generateRandomPassword();
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

    private AccountBuilder(Builder builder) {
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

    public boolean isGender() {
        return gender;
    }

    public String getPersonalInfo_firstName() {
        return personalInfo_firstName;
    }

    public String getPersonalInfo_lastName() {
        return personalInfo_lastName;
    }

    public String getPersonalInfo_emailField() {
        return personalInfo_emailField;
    }

    public String getPasswordField() {
        return passwordField;
    }

    public int getBirthDate_day() {
        return birthDate_day;
    }

    public int getBirthDate_month() {
        return birthDate_month;
    }

    public int getBirthDate_year() {
        return birthDate_year;
    }

    public String getAddress_firstName() {
        return address_firstName;
    }

    public String getAddress_lastName() {
        return address_lastName;
    }

    public String getAddress_company() {
        return address_company;
    }

    public String getAddress_streetAddress() {
        return address_streetAddress;
    }

    public String getAddress_city() {
        return address_city;
    }

    public String getAddress_state() {
        return address_state;
    }

    public String getAddress_postcode() {
        return address_postcode;
    }

    public String getAddress_country() {
        return address_country;
    }

    public String getAddress_mobilePhone() {
        return address_mobilePhone;
    }

    public String getAddress_alias() {
        return address_alias;
    }

    public static class Builder {

        private boolean gender;
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

        public Builder setGender(boolean gender) {
            this.gender = gender;
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

        public Builder setPersonalInfo_firstName(String personalInfo_firstName) {
            this.personalInfo_firstName = personalInfo_firstName;
            return this;
        }

        public Builder setPersonalInfo_lastName(String personalInfo_lastName) {
            this.personalInfo_lastName = personalInfo_lastName;
            return this;
        }

        public Builder setPersonalInfo_emailField(String personalInfo_emailField) {
            this.personalInfo_emailField = personalInfo_emailField;
            return this;
        }

        public Builder setPasswordField(String passwordField) {
            this.passwordField = passwordField;
            return this;
        }

        public Builder setAddress_streetAddress(String address_streetAddress) {
            this.address_streetAddress = address_streetAddress;
            return this;
        }

        public Builder setAddress_city(String address_city) {
            this.address_city = address_city;
            return this;
        }

        public Builder setAddress_state(String address_state) {
            this.address_state = address_state;
            return this;
        }

        public Builder setAddress_postcode(String address_postcode) {
            this.address_postcode = address_postcode;
            return this;
        }

        public Builder setAddress_country(String address_country) {
            this.address_country = address_country;
            return this;
        }

        public Builder setAddress_mobilePhone(String address_mobilePhone) {
            this.address_mobilePhone = address_mobilePhone;
            return this;
        }

        public Builder setAddress_alias(String address_alias) {
            this.address_alias = address_alias;
            return this;
        }

        public AccountBuilder build() {
            return new AccountBuilder(this);
        }
    }
}
