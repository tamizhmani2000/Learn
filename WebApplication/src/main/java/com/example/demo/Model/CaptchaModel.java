package com.example.demo.Model;

public class CaptchaModel {

    private String userName;
    private String recaptchaToken;

    public String getUserName() {
        return userName;
    }

    public void setRecaptchaToken(String token) {
        this.recaptchaToken = token;
    }

    public String getRecaptchaToken() {
        return recaptchaToken;
    }

    public void setUserName(String uname) {
        this.userName = uname;
    }

}