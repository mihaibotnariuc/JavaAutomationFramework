package com.opencart.managers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollElement {
    public static void scrollToTheElement (WebElement element){
        WebDriver driver = DriverManager.getInstance().getDriver();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
