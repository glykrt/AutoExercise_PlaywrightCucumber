package com.automationexercise.pages;

import com.microsoft.playwright.Page;

public class SignupPage extends BasePage{


    public SignupPage(Page page) {
        super(page);
    }

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            click("#id_gender1");
        } else {
            click("#id_gender2");
        }
    }

    public void enterPassword(String password) {
        fill("#password", password);
    }

    public void selectBirthDate(String day, String month, String year) {
        selectOption("#days", day);
        selectOption("#months", month);
        selectOption("#years", year);
    }

    public void checkNewsletterAndOffers() {
        click("#newsletter");
        click("#optin");
    }

    public void fillAddress(String firstName, String lastName, String address, String state, String city, String zipcode, String mobile) {
        fill("#first_name", firstName);
        fill("#last_name", lastName);
        fill("#address1", address);
        fill("#state", state);
        fill("#city", city);
        fill("#zipcode", zipcode);
        fill("#mobile_number", mobile);
    }

    public void clickCreateAccountButton() {
        click("button[data-qa='create-account']");
    }

    public boolean isAccountCreated() {
        return isVisible("text=Account Created!");
    }
}
