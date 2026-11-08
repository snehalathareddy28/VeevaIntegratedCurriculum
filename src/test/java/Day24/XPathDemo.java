package Day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class XPathDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(
                    driver, Duration.ofSeconds(15)
            );

            //xpath with single attribute
            driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");

            //xpath with multiple attributes
            driver.findElement(By.xpath("//input[@placeholder='Password'][@id='password']")).sendKeys("secret_sauce");

            //xpath with and,or operators
            driver.findElement(By.xpath("//input[@id='login-button' or @name='login-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='Products']")
        ));

        //xpath with contains
        driver.findElement(
                By.xpath("(//button[contains(@class,'btn_inventory')])[1]")
        ).click();
    }
}