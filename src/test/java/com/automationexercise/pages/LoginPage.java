package com.automationexercise.pages;

import com.automationexercise.utilities.ConfigurationReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private final Locator nameSignupInput;
    private final Locator emailSignupInput;
    private final Locator signupButton;
    private final Locator emailLoginInput;
    private final Locator passwordLoginInput;
    private final Locator loginButton;
    private final Locator errorMessageLocator;

    public LoginPage(Page page) {
        super(page);
        this.nameSignupInput = page.locator("input[name='name']");
        this.emailSignupInput = page.locator("input[data-qa='signup-email']");
        this.signupButton = page.locator("button[data-qa='signup-button']");
        this.emailLoginInput = page.locator("input[data-qa='login-email']");
        this.passwordLoginInput = page.locator("input[data-qa='login-password']");
        this.loginButton = page.locator("[data-qa='login-button']");
        this.errorMessageLocator = page.locator("p:has-text('Your email or password is incorrect!')");
    }

    public void enterSignupNameAndEmail(String name, String email) {
        nameSignupInput.fill(name);
        emailSignupInput.fill(email);
        signupButton.click();
    }

    public void enterSignupNameAndEmail() {
        nameSignupInput.fill(ConfigurationReader.get("newUsername"));
        emailSignupInput.fill(ConfigurationReader.get("newEmail"));
        signupButton.click();
    }

    public void enterEmail(String email) {
        emailLoginInput.fill(email);
    }

    public void enterPassword(String password) {
        passwordLoginInput.fill(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login() {
        emailLoginInput.fill(ConfigurationReader.get("validEmail"));
        passwordLoginInput.fill(ConfigurationReader.get("validPassword"));
        loginButton.click();
    }

    public void login(String email, String password) {
        if (email.equals("EMPTY_SPACE")) email = "     ";
        if (password.equals("EMPTY_SPACES")) password = "     ";
        emailLoginInput.fill(email);
        passwordLoginInput.fill(password);
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessageLocator.textContent().trim();
    }

    public String getLoginErrorMessageText(String field) {
        Locator fieldLocator = page.locator("input[data-qa='login-" + field + "']");
        return fieldLocator.evaluate("el => el.validationMessage").toString();
    }
}
