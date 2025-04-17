package com.automationexercise.utilities;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    private PlaywrightFactory() {
        // private constructor (Singleton)
    }

    public static Page getPage() {
        if (playwright == null) {
            playwright = Playwright.create();
            String browserType = ConfigurationReader.get("browser").toLowerCase();

            switch (browserType) {
                case "chromium":
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
                case "firefox":
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
                case "webkit":
                    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
                default:
                    throw new RuntimeException("Playwright not initialized properly");
            }

            page = browser.newPage();
        }
        return page;
    }

    public static void close() {
        if (playwright != null) {
            playwright.close();
            playwright = null;
            browser = null;
            page = null;
        }
    }
}
