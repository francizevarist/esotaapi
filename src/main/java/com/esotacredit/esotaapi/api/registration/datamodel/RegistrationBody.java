package com.esotacredit.esotaapi.api.registration.datamodel;

public class RegistrationBody {

    private int countryId;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String email;

    public RegistrationBody() {}

    public RegistrationBody(int countryId, String phoneNumber, String firstName, String lastName, String email) {
        this.countryId = countryId;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
