package com.automationexercise.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage{

    public LoginPage(Page page) {
        super(page);
    }

    public void goToSignupForm() {
        clickSignupLogin();
    }

    public void enterSignupNameAndEmail(String name, String email) {
        fill("input[name='name']", name);
        fill("input[data-qa='signup-email']", email);
        click("button[data-qa='signup-button']");
    }
}
