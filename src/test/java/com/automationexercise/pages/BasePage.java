package com.automationexercise.pages;

import com.microsoft.playwright.Page;

public abstract class BasePage {
    protected Page page;

    protected final String signupLoginBtn = "text=Signup / Login";

    public BasePage(Page page) {
        this.page = page;
    }

    public void clickSignupLogin() {
        page.click(signupLoginBtn);
    }
    public void click(String selector) {
        page.click(selector);
    }

    public void fill(String selector, String text) {
        page.fill(selector, text);
    }

    public void selectOption(String selector, String value) {
        page.selectOption(selector, value);
    }

    public boolean isVisible(String selector) {
        return page.isVisible(selector);
    }
}
