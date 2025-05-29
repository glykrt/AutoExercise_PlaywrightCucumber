package com.automationexercise.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ContactUs_StepDefs extends BasePage_StepDefs {

    @Given("User clicks on Contact Us button")
    public void userClicksOnContactUsButton() {
        contactUsPage.clickContactUsBtn();
    }

    @When("User fills the contact form with {string}, {string}, {string}, {string} and uploads {string} then submits")
    public void userFillsTheContactFormWithAndUploadsThenSubmits(String name, String email, String subject, String message, String filePath) {
        contactUsFlow.contactUsForm(name, email, subject, message, filePath);
    }

    @Then("Verify success message {string} is visible")
    public void verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible(String expectedMessage) {
        Assert.assertEquals(expectedMessage,contactUsPage. getContactSuccessMessageText());
    }

    @When("User submits the contact form with invalid email {string}")
    public void userSubmitsTheContactFormWithInvalidEmail(String email) {
        contactUsFlow.submitFormWithInvalidEmailOnly(email);
    }

    @Then("Browser validation message for email field should be {string}")
    public void browserValidationMessageForEmailFieldShouldBe(String expectedMessage) {
        Assert.assertEquals(expectedMessage,contactUsPage.getContactUsActualMessageText());
    }

    @When("User enters a valid email {string} into the subscription box and submits")
    public void userEntersAValidEmailIntoTheSubscriptionBoxAndSubmits(String email) {
        contactUsFlow.subscribeToNewsletter(email);
    }

    @Then("Success message {string} should be visible")
    public void successMessageShouldBeVisible(String expectedMessage) {
        Assert.assertEquals(expectedMessage,contactUsPage.getSubscriptionSuccessMessage());
    }

    @When("User enters {string} into the subscription box and submits")
    public void userEntersIntoTheSubscriptionBoxAndSubmits(String email) {
        contactUsFlow.attemptToSubscribeWithInvalidEmail(email);
    }

    @Then("Browser validation message should be {string}")
    public void browserValidationMessageShouldBe(String expectedMessage) {
        Assert.assertEquals(expectedMessage,contactUsPage.getSubscriptionEmailValidationMessage());
    }
}
