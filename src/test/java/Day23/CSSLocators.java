package Day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CSSLocators {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            driver.get("https://automationexercise.com/");

            // Navigate to Products page
            WebDriverWait wait = new WebDriverWait(
                    driver, Duration.ofSeconds(15));

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("a[href='/products']"))).click();

            // Wait for search box
            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("search_product")));

            // Enter search text
            searchBox.sendKeys("women");

            // Click search button
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("submit_search"))).click();

            System.out.println("Search completed!");

        } finally {
            driver.quit();
        }
    }
}