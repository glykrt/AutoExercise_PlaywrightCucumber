package com.automationexercise.utilities;

import com.microsoft.playwright.Page;

public class BrowserUtils {

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentUrl(Page page) {
        return page.url();
    }

    public static void takeScreenshot(Page page, String path) {
        page.screenshot(new Page.ScreenshotOptions().setPath(java.nio.file.Paths.get(path)));
    }

    public static void scrollToElement(Page page, String selector) {
        page.evalOnSelector(selector, "element => element.scrollIntoView()");
    }

}
