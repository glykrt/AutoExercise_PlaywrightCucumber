package com.automationexercise.stepDefs;

import com.automationexercise.flows.SignupFlow;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.SignupPage;
import com.microsoft.playwright.Page;

public abstract class BasePage_StepDefs {

    Page page = Hooks.page;
    LoginPage loginPage = new LoginPage(page);
    SignupPage signupPage = new SignupPage(page);
    SignupFlow signupFlow = new SignupFlow(loginPage, signupPage);


}
