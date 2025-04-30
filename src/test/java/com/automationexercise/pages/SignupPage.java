package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignupPage extends BasePage {

    private final Locator genderMale;
    private final Locator genderFemale;
    private final Locator passwordInput;
    private final Locator daysDropdown;
    private final Locator monthsDropdown;
    private final Locator yearsDropdown;
    private final Locator newsletterCheckbox;
    private final Locator optinCheckbox;
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator addressInput;
    private final Locator countrySelect;
    private final Locator stateInput;
    private final Locator cityInput;
    private final Locator zipcodeInput;
    private final Locator mobileInput;
    private final Locator createAccountButton;
    private final Locator accountCreatedText;
    private final Locator emailExistsText;

    public SignupPage(Page page) {
        super(page);
        this.genderMale = page.locator("#id_gender1");
        this.genderFemale = page.locator("#id_gender2");
        this.passwordInput = page.locator("#password");
        this.daysDropdown = page.locator("#days");
        this.monthsDropdown = page.locator("#months");
        this.yearsDropdown = page.locator("#years");
        this.newsletterCheckbox = page.locator("#newsletter");
        this.optinCheckbox = page.locator("#optin");
        this.firstNameInput = page.locator("#first_name");
        this.lastNameInput = page.locator("#last_name");
        this.addressInput = page.locator("#address1");
        this.countrySelect = page.locator("#country");
        this.stateInput = page.locator("#state");
        this.cityInput = page.locator("#city");
        this.zipcodeInput = page.locator("#zipcode");
        this.mobileInput = page.locator("#mobile_number");
        this.createAccountButton = page.locator("button[data-qa='create-account']");
        this.accountCreatedText = page.locator("text=Account Created!");
        this.emailExistsText = page.locator("text=Email Address already exist!");
    }

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            genderMale.click();
        } else {
            genderFemale.click();
        }
    }

    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    public void selectBirthDate(String day, String month, String year) {
        daysDropdown.selectOption(day);
        monthsDropdown.selectOption(month);
        yearsDropdown.selectOption(year);
    }

    public void checkNewsletterAndOffers() {
        newsletterCheckbox.check();
        optinCheckbox.check();
    }

    public void fillAddress(String firstName, String lastName, String address, String country, String state, String city, String zipcode, String mobile) {
        firstNameInput.fill(firstName);
        lastNameInput.fill(lastName);
        addressInput.fill(address);
        countrySelect.selectOption(country);
        stateInput.fill(state);
        cityInput.fill(city);
        zipcodeInput.fill(zipcode);
        mobileInput.fill(mobile);
    }

    public void fillInvalidAddressForm(String firstName, String lastName, String address, String state, String city, String zipcode, String mobile){
        firstNameInput.fill(firstName);
        lastNameInput.fill(lastName);
        addressInput.fill(address);
        stateInput.fill(state);
        cityInput.fill(city);
        zipcodeInput.fill(zipcode);
        mobileInput.fill(mobile);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public boolean isAccountCreated() {
        return accountCreatedText.isVisible();
    }

    public boolean isExistAccount() {
        return emailExistsText.isVisible();
    }

    public String getSignupErrorMessageText(String field) {
        Locator fieldLocator = page.locator("input[data-qa='" + field + "']");
        return fieldLocator.evaluate("el => el.validationMessage").toString();
    }
}
