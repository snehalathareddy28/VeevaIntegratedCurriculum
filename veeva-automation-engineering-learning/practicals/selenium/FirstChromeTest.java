package practicals.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstChromeTest {

    public static void main(String[] args) {

        WebDriver driver = null;

        try {
            // Launch Chrome browser
            driver = new ChromeDriver();

            // Maximize browser window
            driver.manage().window().maximize();

            // Open SauceDemo
            driver.get("https://www.saucedemo.com/");

            // Print page information
            System.out.println("Browser: Chrome");
            System.out.println("Page Title: " + driver.getTitle());
            System.out.println("Current URL: " + driver.getCurrentUrl());

        } catch (Exception e) {
            System.out.println("Chrome test failed: " + e.getMessage());

        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Chrome browser closed.");
            }
        }
    }
}