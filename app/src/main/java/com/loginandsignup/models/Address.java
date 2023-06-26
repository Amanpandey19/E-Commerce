package com.loginandsignup.models;

public class Address {
    String name;
    String city;
    String address;
    String pinCode;
    String phone_number;

    public Address() {
    }

    public Address(String name, String city, String address, String pinCode, String phone_number) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.pinCode = pinCode;
        this.phone_number = phone_number;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
