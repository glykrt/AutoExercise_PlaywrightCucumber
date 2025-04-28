package com.automationexercise.pages;

import com.automationexercise.utilities.ConfigurationReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private final String nameSignupInput = "input[name='name']";
    private final String emailSignupInput = "input[data-qa='signup-email']";
    private final String signupButton = "button[data-qa='signup-button']";
    private final String emailLoginInput = "input[data-qa=login-email]";
    private final String passwordLoginInput = "input[data-qa=login-password]";
    private final String loginButton = "[data-qa=login-button]";
    private final String errorMessage = "Your email or password is incorrect!";

    public LoginPage(Page page) {
        super(page);
    }

    public void enterSignupNameAndEmail(String name, String email) {
        fill(nameSignupInput, name);
        fill(emailSignupInput, email);
        click(signupButton);
    }

    public void enterEmail(String email) {
        fill(emailLoginInput, email);
    }

    public void enterPassword(String password) {
        fill(passwordLoginInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void login() {
        fill(emailLoginInput, ConfigurationReader.get("validEmail"));
        fill(passwordLoginInput, ConfigurationReader.get("validPassword"));
        click(loginButton);
    }

    public void login(String email, String password) {

        if (email.equals("EMPTY_SPACE")) {
            email = "     ";
        }
        if (password.equals("EMPTY_SPACES")) {
            password = "     ";
        }
        fill(emailLoginInput, email);
        page.waitForTimeout(3000);
        fill(passwordLoginInput, password);
        page.waitForTimeout(3000);
        click(loginButton);
        page.waitForTimeout(3000);
    }

    public String getErrorMessage() {
        String errorMessageText = errorMessage;
        return errorMessageText;
    }

    public String getErrorMessageText(String field) {
        String selector = "input[data-qa='login-" + field + "']";
        String validationMessage = (String) page.locator(selector).evaluate("el => el.validationMessage");
        return validationMessage;
    }


}
