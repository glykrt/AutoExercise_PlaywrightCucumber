package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public abstract class BasePage {
    protected final Page page;

    protected final Locator signupLoginBtn;
    protected final Locator logoutBtn;
    protected final Locator deleteAccountBtn;
    protected final Locator loggedInAsText;
    protected final Locator contactUsBtn;

    public BasePage(Page page) {
        this.page = page;
        this.signupLoginBtn = page.locator("a[href='/login']");
        this.logoutBtn = page.locator("a[href='/logout']");
        this.deleteAccountBtn = page.locator("a[href='/delete_account']");
        this.loggedInAsText = page.locator("//*[contains(text(),'Logged in as')]");
        this.contactUsBtn = page.locator("a[href='/contact_us']");
    }

    public void clickSignupLogin() {
        signupLoginBtn.click();
    }

    public void clickLogout() {
        logoutBtn.click();
    }

    public void clickDeleteAccount() {
        deleteAccountBtn.click();
    }

    public void clickContactUsBtn(){
        contactUsBtn.click();
    }

    public boolean isVisibleSignupButton() {
        return signupLoginBtn.isVisible();
    }

    public Locator getLoggedInAsLocator() {
        return loggedInAsText;
    }
}
