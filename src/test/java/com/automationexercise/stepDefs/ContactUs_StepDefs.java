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
        Assert.assertEquals(expectedMessage,contactUsPage.getSuccessMessageText());
    }
}
