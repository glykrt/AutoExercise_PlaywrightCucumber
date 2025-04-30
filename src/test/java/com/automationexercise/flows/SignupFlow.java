package com.automationexercise.flows;

import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.SignupPage;
import io.cucumber.datatable.DataTable;

import java.util.Map;

public class SignupFlow {

    private final LoginPage loginPage;
    private final SignupPage signupPage;

    public SignupFlow(LoginPage loginPage, SignupPage signupPage) {
        this.loginPage = loginPage;
        this.signupPage = signupPage;
    }

    public void registerWithDataTable(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);

        loginPage.enterSignupNameAndEmail(data.get("name"), data.get("email"));
        signupPage.selectTitle(data.get("title"));
        signupPage.enterPassword(data.get("password"));
        signupPage.selectBirthDate(data.get("day"), data.get("month"), data.get("year"));
        signupPage.checkNewsletterAndOffers();
        signupPage.fillAddress(
                data.get("firstName"),
                data.get("lastName"),
                data.get("address"),
                data.get("country"),
                data.get("state"),
                data.get("city"),
                data.get("zipcode"),
                data.get("mobile")
        );
        signupPage.clickCreateAccountButton();
    }

    public void registerWithExistingEmail(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        loginPage.enterSignupNameAndEmail(data.get("name"), data.get("email"));
    }

    public void registerWithInvalidInformation(String password, String firstName, String lastName, String address, String state, String city, String zipcode, String mobile){
        loginPage.enterSignupNameAndEmail();
        signupPage.enterPassword(password);
        signupPage.fillInvalidAddressForm(firstName, lastName, address, state, city, zipcode, mobile);
        signupPage.clickCreateAccountButton();

    }


}
