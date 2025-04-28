package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public abstract class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    private final String signupLoginBtn = "a[href='/login']";
    private final String logoutBtn = "a[href='/logout']";
    private final String deleteAccountBtn = "a[href='/delete_account']";
    private final String loggedInAs = "//*[contains(text(),'Logged in as')]";

    public void clickSignupLogin() {
        page.click(signupLoginBtn);
    }

    public void clickLogout() {
        page.click(logoutBtn);
    }

    public void clickDeleteAccount() {
        page.click(deleteAccountBtn);
    }

    public Locator getLoggedInAsLocator() {
        return page.locator(loggedInAs);
    }

    public boolean isVisibleSignupButton(){
      return isVisible(signupLoginBtn);
    }

    public void click(String selector) {
        page.click(selector);
    }

    public void fill(String selector, String text) {
        page.fill(selector, text);
    }

    public boolean isVisible(String selector) {
        return page.isVisible(selector);
    }

    public Locator getLocator(String selector) {
        return page.locator(selector);
    }
}
