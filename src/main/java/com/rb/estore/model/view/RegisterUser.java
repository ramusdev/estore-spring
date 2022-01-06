package com.rb.estore.model.view;

import com.rb.estore.model.User;

public class RegisterUser extends User {
    private String passwordRepeat;

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
}
