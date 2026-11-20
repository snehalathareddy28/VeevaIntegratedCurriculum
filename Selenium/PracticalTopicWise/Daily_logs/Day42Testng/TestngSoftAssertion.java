
package PracticalTopicWise.Daily_logs.Day42Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestngSoftAssertion {

    WebDriver driver;

    @BeforeMethod
    void openApp() {

        driver = new ChromeDriver();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    void titleCheck() {

        SoftAssert soft = new SoftAssert();

        String actualTitle = driver.getTitle();

        soft.assertEquals(
                actualTitle,
                "OrangeHRM",
                "Page title is not matched"
        );

        soft.assertAll();
    }

    @Test
    void testLogin() {

        SoftAssert soft = new SoftAssert();

        driver.findElement(By.xpath("//input[@placeholder='Username']"))
                .sendKeys("Admin");

        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys("admin123");

        driver.findElement(By.xpath("//button[normalize-space()='Login']"))
                .click();

        soft.assertTrue(
                driver.getCurrentUrl().contains("dashboard"),
                "Login failed! Dashboard not opened"
        );

        soft.assertAll();
    }

    @AfterMethod
    void testClose() {

        if (driver != null) {
            driver.quit();
        }
    }
}
