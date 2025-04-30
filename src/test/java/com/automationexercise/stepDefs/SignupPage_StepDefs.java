package com.automationexercise.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignupPage_StepDefs extends BasePage_StepDefs {

    @Given("The user clicks on the Signup-Login button")
    public void theUserClicksOnTheSignupLoginButton() {
        loginPage.clickSignupLogin();
    }

    @When("The user registers with the following information:")
    public void theUserRegistersWithTheFollowingInformation(DataTable table) {
        signupFlow.registerWithDataTable(table);
    }

    @Then("The account should be created successfully")
    public void theAccountShouldBeCreatedSuccessfully() {
        assert signupPage.isAccountCreated();
    }

    @When("The user registers with existing information:")
    public void theUserRegistersWithExistingInformation(DataTable table) {
        signupFlow.registerWithExistingEmail(table);
    }

    @Then("The user should see the error message")
    public void theUserShouldSeeTheErrorMessage() {
        assert signupPage.isExistAccount();
    }

    @When("The user enters name {string} and email {string}")
    public void theUserEntersNameAndEmail(String name, String email) {
        loginPage.enterSignupNameAndEmail(name,email);
    }

    @Then("Browser validation message for registration field {string} should be {string}")
    public void browserValidationMessageForRegistrationFieldShouldBe(String field, String expectedMessage) {
        Assert.assertEquals(expectedMessage,signupPage.getSignupErrorMessageText(field));
    }


    @When("The user enters invalid data on signup form with password {string}, first name {string}, last name {string}, address {string}, state {string}, city {string}, zipcode {string}, mobile {string}")
    public void theUserEntersInvalidDataOnSignupFormWithPasswordFirstNameLastNameAddressStateCityZipcodeMobile(
            String password, String firstName, String lastName, String address, String state, String city, String zipcode, String mobile) {
        signupFlow.registerWithInvalidInformation(password, firstName, lastName, address, state, city, zipcode, mobile);
    }

}
