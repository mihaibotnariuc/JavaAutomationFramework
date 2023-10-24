package com.opencart.pageobjects;

import com.opencart.managers.ScrollElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//input[@id='input-email']")
    private WebElement emailInput;
    @FindBy (xpath = " //input[@id='input-password']")
    private WebElement passwordInput;
    @FindBy (xpath = "//button[normalize-space()='Login']")
    private WebElement loginBtn;
    public void fillInTheLoginForm (String username, String password){
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }
    public void clickLoginBtn(){
        ScrollElement.scrollToTheElement(loginBtn);
        loginBtn.click();
    }
}

