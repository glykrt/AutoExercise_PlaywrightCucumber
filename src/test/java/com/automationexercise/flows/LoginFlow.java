package com.automationexercise.flows;

import com.automationexercise.pages.LoginPage;
import com.microsoft.playwright.Page;
import io.cucumber.datatable.DataTable;

import java.util.Map;

public class LoginFlow {

    private final LoginPage loginPage;

    public LoginFlow(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void performLogin() {
        loginPage.login();
    }

    public void performLogin(String email, String password) {

        loginPage.login(email, password);
    }

    public void performLogout() {
        loginPage.clickLogout();
    }

    public void deleteAccount() {
        loginPage.clickDeleteAccount();
    }


}

