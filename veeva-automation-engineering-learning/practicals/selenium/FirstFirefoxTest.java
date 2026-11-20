package practicals.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstFirefoxTest {

    public static void main(String[] args) {

        WebDriver driver = null;

        try {
            // Launch Firefox browser
            driver = new FirefoxDriver();

            // Maximize browser window
            driver.manage().window().maximize();

            // Open SauceDemo
            driver.get("https://www.saucedemo.com/");

            // Print page information
            System.out.println("Browser: Firefox");
            System.out.println("Page Title: " + driver.getTitle());
            System.out.println("Current URL: " + driver.getCurrentUrl());

        } catch (Exception e) {
            System.out.println("Firefox test failed: " + e.getMessage());

        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Firefox browser closed.");
            }
        }
    }
}