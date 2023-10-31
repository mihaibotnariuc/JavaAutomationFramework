package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class HomePage {
    WebDriver driver = DriverManager.getInstance().getDriver();
    com.opencart.pageobjects.HomePage homePage = new com.opencart.pageobjects.HomePage(driver);



    @Given("The Homepage is displayed")
    public void theHomepageIsDisplayed() {
        driver.get("https://andreisecuqa.host/");
        System.out.println("The driver accessed the home page");
    }

    @And("RegisterPage is accessed from Homepage buttons")
    public void registerpageIsAccessedFromHomepageButtons() {
        System.out.println("The second step is executed");
    }

    @When("the registerLink from Header menu is clicked")
    public void theRegisterLinkFromHeaderMenuIsClicked() {
        homePage.navigateToRegisterPageFromHeader();
        System.out.println("The Register Link has been accessed from the Header Menu");
    }
}
