package PracticalTopicWise.Daily_logs.Day45;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderDemo {
    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
    }

    @Test(dataProvider = "dp")
    void testLogin(String email, String pwd, String expected) throws InterruptedException {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Thread.sleep(2000);

        boolean isLoggedIn = !driver.findElements(By.xpath("//h2[normalize-space()='My Account']")).isEmpty();

        if (expected.equalsIgnoreCase("Valid")) {
            if (isLoggedIn) {
                driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
                Assert.assertTrue(true);
            } else {
                Assert.fail("Valid login failed for: " + email);
            }
        } else {
            if (isLoggedIn) {
                driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
                Assert.fail("Invalid login unexpectedly succeeded for: " + email);
            } else {
                Assert.assertTrue(true);
            }
        }
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }


    @DataProvider(name = "dp")
    Object[][] loginData() {
        return new Object[][]{
                {"abc@gmail.com", "test123", "Invalid"},
                {"xyz@gmail.com", "test012", "Invalid"},
                {"john@gmail.com", "test@123", "Invalid"},
                {"pavanol123@gmail.com", "test@123", "Valid"},
                {"johncanedy@gmail.com", "test123", "Invalid"}
        };

    }
}