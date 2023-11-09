package com.opencart.pageobjects;

import com.google.j2objc.annotations.Weak;
import com.opencart.managers.ScrollElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver){
    super(driver);
    }
    @FindBy (xpath = "//input[@id='input-firstname']")
    private WebElement firstNameInput;
    @FindBy (xpath = "//input[@id='input-lastname']")
    private WebElement lastNameInput;
    @FindBy (xpath = "//input[@id='input-email']")
    private WebElement emailInput;
    @FindBy (xpath = "//input[@id='input-password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@id='input-newsletter']")
    private WebElement subscribeButton;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyInput;
    @FindBy (xpath = "//button[normalize-space()='Continue']")

    private WebElement continueBtn;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password, boolean subscribeButon, boolean toggle){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        if (subscribeButon){
            ScrollElement.scrollToTheElement(subscribeButton);
            subscribeButton.click();
        }
        if (toggle){
            ScrollElement.scrollToTheElement(privacyInput);
            privacyInput.click();
        }
    }
    public void clickTheContinueButton(){
        continueBtn.click();
    }


}
