package com.automationexercise.stepDefs;

import com.automationexercise.flows.ContactUsFlow;
import com.automationexercise.flows.LoginFlow;
import com.automationexercise.flows.SignupFlow;
import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.SignupPage;
import com.microsoft.playwright.Page;

public abstract class BasePage_StepDefs {

    Page page = Hooks.page;

    LoginPage loginPage = new LoginPage(page);
    SignupPage signupPage = new SignupPage(page);
    ContactUsPage contactUsPage = new ContactUsPage(page);

    SignupFlow signupFlow = new SignupFlow(loginPage, signupPage);
    LoginFlow loginFlow = new LoginFlow(loginPage);
    ContactUsFlow contactUsFlow = new ContactUsFlow(contactUsPage);


}
