package com.automationexercise.pages;

import com.microsoft.playwright.Page;

public class SignupPage extends BasePage{

    private final String genderMaleLocator = "#id_gender1";
    private final String genderFemaleLocator = "#id_gender2";
    private final String passwordLocator = "#password";
    private final String daysLocator = "#days";
    private final String monthsLocator = "#months";
    private final String yearsLocator = "#years";
    private final String newsletterLocator = "#newsletter";
    private final String optinLocator = "#optin";
    private final String firstNameLocator = "#first_name";
    private final String lastNameLocator = "#last_name";
    private final String addressLocator = "#address1";
    private final String countryLocator = "#country";
    private final String stateLocator = "#state";
    private final String cityLocator = "#city";
    private final String zipcodeLocator = "#zipcode";
    private final String mobileLocator = "#mobile_number";
    private final String createAccountButtonLocator = "button[data-qa='create-account']";
    private final String accountCreatedTextLocator = "text=Account Created!";
    private final String emailExistsTextLocator = "text=Email Address already exist!";



    public SignupPage(Page page) {
        super(page);
    }

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            click(genderMaleLocator);
        } else {
            click(genderFemaleLocator);
        }
    }

    public void enterPassword(String password) {
        fill(passwordLocator, password);
    }

    public void selectBirthDate(String day, String month, String year) {
        page.selectOption(daysLocator, day);
        page.selectOption(monthsLocator, month);
        page.selectOption(yearsLocator, year);
    }

    public void checkNewsletterAndOffers() {
        click(newsletterLocator);
        click(optinLocator);
    }

    public void fillAddress(String firstName, String lastName, String address,String country, String state, String city, String zipcode, String mobile) {
        fill(firstNameLocator, firstName);
        fill(lastNameLocator, lastName);
        fill(addressLocator, address);
        page.selectOption(countryLocator, country);
        fill(stateLocator, state);
        fill(cityLocator, city);
        fill(zipcodeLocator, zipcode);
        fill(mobileLocator, mobile);
    }

    public void clickCreateAccountButton() {
        click(createAccountButtonLocator);
    }

    public boolean isAccountCreated() {
        return isVisible(accountCreatedTextLocator);
    }

    public boolean isExistAccount(){
        return isVisible(emailExistsTextLocator);
    }

    public String getSignupErrorMessageText(String field) {
        String selector = "input[data-qa='" + field + "']";
        String validationMessage = (String) page.locator(selector).evaluate("el => el.validationMessage");
        return validationMessage;
    }
    public void fillInvalidAddressForm(String firstName, String lastName, String address, String state, String city, String zipcode, String mobile){
        fill(firstNameLocator, firstName);
        fill(lastNameLocator, lastName);
        fill(addressLocator, address);
        fill(stateLocator, state);
        fill(cityLocator, city);
        fill(zipcodeLocator, zipcode);
        fill(mobileLocator, mobile);
    }

}

