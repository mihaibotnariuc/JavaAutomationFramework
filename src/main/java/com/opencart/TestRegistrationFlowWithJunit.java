package com.opencart;
import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.BeforeAll;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class TestRegistrationFlowWithJunit {
    static WebDriver driver;
    static HomePage homePage;
    static RegisterPage registerPage;

    @BeforeAll
    public static void executeThisMethodBeforeAllTheTestes(){
        System.out.println("Execution of the tests suite has started");
    }
    @BeforeEach
    public void executeTheCodeBeforeEachTest(){
        System.out.println("The code is executed before each test case");
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.navigateToRegisterPageFromHeader();
    }
    @Test
    @DisplayName("The registration of new user with valid data redirects to the Account Page")
    public void registerWithValidCredentialsTest() throws InterruptedException {
        System.out.println("This is the test #1");
        String randomEmail = RandomDataManager.generateRandomEmail();
        System.out.println(randomEmail);
        String randomPassword = RandomDataManager.generatePassword();
        System.out.println(randomPassword);
        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(),
                randomEmail, randomPassword, true, true);
        registerPage.clickTheContinueButton();
        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();

        boolean doesTheCorrectUrlContainSuccessAccountRoute = driver.getCurrentUrl().contains("route=account/success");
        Assertions.assertTrue(doesTheCorrectUrlContainSuccessAccountRoute, "The current url:" + currentUrl +" contains:route=account/success ");

    }
    @Test
    @DisplayName("The user is remaining on Register page when trying to register with invalid password")
    public void registerWithInvalidPasswordTests() throws InterruptedException {
        System.out.println("This is the test #2");
        String randomEmail = RandomDataManager.generateRandomEmail();
        System.out.println(randomEmail);
        String randomPassword = RandomDataManager.generatePassword();
        System.out.println(randomPassword);
        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(),
                randomEmail, "1", true, true);
        registerPage.clickTheContinueButton();
        Thread.sleep(56);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://andreisecuqa.host/index.php?route=account/register&language=en-gb";
        Assertions.assertEquals(expectedUrl, actualUrl, "The urls should be equals");
    }
    @Test
    @DisplayName("The error message is displayed when is used invalid password to the register flow")
    public void errorMessageIsDisplayedWhenInvalidPasswordIsUsedForRegisterFlow() throws InterruptedException {
        System.out.println("This is the test #2");
        String randomEmail = RandomDataManager.generateRandomEmail();
        System.out.println(randomEmail);
        String randomPassword = RandomDataManager.generatePassword();
        System.out.println(randomPassword);
        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(),
                randomEmail, "1", true, true);
        registerPage.clickTheContinueButton();
        Thread.sleep(500);
        String expectedErrorMessageForInvalidPassword = "Password must be between 4 and 20 characters!";
       String actualErrorMessage = driver.findElement(By.id("error-password")).getText();
        Assertions.assertEquals(expectedErrorMessageForInvalidPassword, actualErrorMessage);
    }
    @AfterEach
    public void afterEachTestCase(){
        DriverManager.getInstance().tearDown();
        System.out.println("The test case executions has been finished");
    }
    @AfterAll
    public static void afterAllTestCases(){
        System.out.println("All tests has been executed");
    }

}

