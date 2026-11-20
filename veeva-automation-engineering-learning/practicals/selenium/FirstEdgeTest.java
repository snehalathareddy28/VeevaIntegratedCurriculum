package practicals.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstEdgeTest {

    public static void main(String[] args) {

        WebDriver driver = null;

        try {
            // Launch Edge browser
            driver = new EdgeDriver();

            // Maximize browser window
            driver.manage().window().maximize();

            // Open SauceDemo
            driver.get("https://www.saucedemo.com/");
            // Print page information
            System.out.println("Browser: Edge");
            System.out.println("Page Title: " + driver.getTitle());
            System.out.println("Current URL: " + driver.getCurrentUrl());

        } catch (Exception e) {
            System.out.println("Edge test failed: " + e.getMessage());

        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Edge browser closed.");
            }
        }
    }
}