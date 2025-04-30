package com.automationexercise.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class ContactUsPage extends BasePage {

    private final Locator nameInput;
    private final Locator emailInput;
    private final Locator subjectInput;
    private final Locator messageTextArea;
    private final Locator submitButton;
    private final Locator uploadFile;
    private final Locator successMessage;

    public ContactUsPage(Page page) {
        super(page);
        this.nameInput = page.locator("input[name='name']");
        this.emailInput = page.locator("input[name='email']");
        this.subjectInput = page.locator("input[name='subject']");
        this.messageTextArea = page.locator("#message");
        this.uploadFile = page.locator("input[name='upload_file']");
        this.submitButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));
        this.successMessage = page.locator(".status.alert.alert-success");
    }

    public void fillContactForm(String name, String email, String subject, String message) {
        nameInput.fill(name);
        page.waitForTimeout(3000);
        emailInput.fill(email);
        page.waitForTimeout(3000);
        subjectInput.fill(subject);
        page.waitForTimeout(3000);
        messageTextArea.fill(message);
        page.waitForTimeout(3000);

    }
    public void chooseFile(String filePath){
        uploadFile.setInputFiles(Paths.get(filePath));
    }

    public void prepareToAcceptAlert() {
        page.onceDialog(dialog -> {
            System.out.println("Popup message: " + dialog.message());
            dialog.accept();
        });
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String getSuccessMessageText() {
        String actualMessage = successMessage.innerText();
        return actualMessage;
    }

}
