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
}
