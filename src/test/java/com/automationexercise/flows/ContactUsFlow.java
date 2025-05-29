package com.automationexercise.flows;

import com.automationexercise.pages.ContactUsPage;

public class ContactUsFlow {

    private ContactUsPage contactUsPage;

    public ContactUsFlow(ContactUsPage contactUsPage) {
        this.contactUsPage = contactUsPage;
    }

    public void contactUsForm(String name, String email, String subject, String message, String filePath){
        contactUsPage.fillContactForm(name, email, subject, message);
        contactUsPage.chooseFile(filePath);
        contactUsPage.prepareToAcceptAlert();
        contactUsPage.clickSubmit();

    }

    public void submitFormWithInvalidEmailOnly(String email) {
        contactUsPage.enterInvalidEmail(email);
        contactUsPage.clickSubmit();
    }

    public void subscribeToNewsletter(String email) {
        contactUsPage.enterEmailAndSubscribe(email);
        contactUsPage.clickSubscribe();
    }

    public void attemptToSubscribeWithInvalidEmail(String email) {
        if (email.equals("EMPTY_SPACE")) email = "     ";
        if (email.equals("spaces@gmail.com")) email = "     @gmail.com";
        contactUsPage.enterEmailAndSubscribe(email);
        contactUsPage.clickSubscribe();
    }




}
