package com.automationexercise.stepDefs;

import com.automationexercise.utilities.ConfigurationReader;
import com.automationexercise.utilities.PlaywrightFactory;
import com.microsoft.playwright.Page;
import io.cucumber.java.*;

public class Hooks {
    public static Page page;

    @Before
    public void setUp() {
        page = PlaywrightFactory.getPage();
        page.navigate(ConfigurationReader.get("url"));
        page.waitForTimeout(3000);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (page != null && scenario.isFailed()) {
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        PlaywrightFactory.close();
    }
}
