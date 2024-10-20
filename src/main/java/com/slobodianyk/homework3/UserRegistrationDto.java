package com.slobodianyk.homework3;

public class UserRegistrationDto {
    private String email;
    private String phoneNumber;
    private String password;
    private String repeatPassword;

    public UserRegistrationDto(String email, String phoneNumber, String password, String repeatPassword) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

}
