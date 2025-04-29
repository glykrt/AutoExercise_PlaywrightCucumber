package com.automationexercise.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs extends BasePage_StepDefs{

    @When("The user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        loginFlow.performLogin();
    }

    @Then("Logged in as username should be visible")
    public void loggedInAsUsernameShouldBeVisible() {
        assert loginPage.getLoggedInAsLocator().isVisible();
    }

    @When("User clicks on Logout button")
    public void userClicksOnLogoutButton() {
        loginFlow.performLogout();
    }

    @Then("Signup-Login button should be visible again")
    public void signupLoginButtonShouldBeVisibleAgain() {
        assert loginPage.isVisibleSignupButton();
    }

    @When("User enters email {string} and password {string}")
    public void userEntersEmailAndPassword(String email, String password) {
        loginFlow.performLogin(email, password);
    }

    @When("User clicks on delete account button")
    public void userClicksOnDeleteAccountButton() {
        loginFlow.deleteAccount();
    }

    @Then("Browser validation message for field {string} should be {string}")
    public void browserValidationMessageForFieldShouldBe(String field, String expectedMessage) {
        Assert.assertEquals(expectedMessage,loginPage.getLoginErrorMessageText(field));
    }

    @Then("Error message {string} should be visible")
    public void errorMessageShouldBeVisible(String message) {
        Assert.assertEquals(loginPage.getErrorMessage(),message);
    }
}
