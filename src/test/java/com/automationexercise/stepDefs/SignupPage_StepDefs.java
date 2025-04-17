package com.automationexercise.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Map;

public class SignupPage_StepDefs extends BasePage_StepDefs {

    @Given("The user clicks on the Signup-Login button")
    public void theUserClicksOnTheSignupLoginButton() {
        loginPage.clickSignupLogin();
    }

    @And("The user registers with the following information:")
    public void theUserRegistersWithTheFollowingInformation(DataTable table) {
        signupFlow.registerWithDataTable(table);
    }

    @Then("The account should be created successfully")
    public void theAccountShouldBeCreatedSuccessfully() {
        assert signupPage.isAccountCreated();
    }
}
