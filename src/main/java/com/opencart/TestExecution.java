package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import org.openqa.selenium.*;

public class TestExecution {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();
       // New Window Code
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://andreisecuqa.host/");
        Thread.sleep(1000);

        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));

        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Register']"));
        registerOption.click();
        System.out.println(driver.getCurrentUrl());
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        String firstName = RandomDataManager.generateFirstName();
        firstNameInput.sendKeys(firstName);
        System.out.println(firstName);
        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));
        String lastName = RandomDataManager.generateLastName();
        lastNameInput.sendKeys(lastName);
        System.out.println(lastName);
        WebElement emailAddressInput = driver.findElement(By.cssSelector("#input-email"));
        String randomEmail = RandomDataManager.generateRandomEmail();
        emailAddressInput.sendKeys(randomEmail);
        System.out.println(randomEmail);
        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String randomPassword = RandomDataManager.generatePassword();
        passwordInput.sendKeys(randomPassword);
        System.out.println(randomPassword);
        WebElement subscribeInput = driver.findElement(By.xpath("//input[@id='input-newsletter']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", subscribeInput);
        Thread.sleep(500);
        subscribeInput.click();
        WebElement privacyPolicyInput = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicyInput.click();
        WebElement confirmButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        confirmButton.click();





        Thread.sleep(3000);

        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(currentWindowName);
        driver.get("https://tekwill.md/");
        Thread.sleep(1000);
        System.out.println(driver.getTitle());
        driver.quit();
        System.out.println("The execution is over");
    }
    }