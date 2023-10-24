package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.*;

public class TestExecutionWithPageObjects {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPageFromHeader();

        RegisterPage registerPage = new RegisterPage(driver);

        String randomEmail = RandomDataManager.generateRandomEmail();
        System.out.println(randomEmail);
        String randomPassword = RandomDataManager.generatePassword();
        System.out.println(randomPassword);
        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(),
                randomEmail, randomPassword, true, true);

        registerPage.clickTheContinueButton();
        homePage.navigateToLogOutFromHeader();
        System.out.println("The log out was made successfully");

        homePage.navigateToLoginPageFromHeader();



        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInTheLoginForm(randomEmail, randomPassword);
        loginPage.clickLoginBtn();
        System.out.println("welcome back!");

        homePage.navigateToLogOutFromHeader();
        System.out.println("The Work is Done!");

        DriverManager.getInstance().tearDown();

        System.out.println("The execution is over");

    }
    }