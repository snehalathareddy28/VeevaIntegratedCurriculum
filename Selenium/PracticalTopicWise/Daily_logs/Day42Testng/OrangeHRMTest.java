package PracticalTopicWise.Daily_logs.Day42Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

/*
1)open application
2)test logo presence
3)login
4)close
 */

public class OrangeHRMTest {
    WebDriver driver;

    @Test(priority = 1)
    void openApp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    void testLogo(){
        boolean status = driver.findElement(By.xpath("//div[@class=\"orangehrm-login-branding\"]")).isDisplayed();
        System.out.println("tittle dispalyed :"+status);
    }

    @Test(priority = 3)
    void testLogin(){
        driver.findElement(By.cssSelector("input[name = 'username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name = 'password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type = 'submit']")).click();
    }

    @Test(priority = 4)
    void closeApp(){
        driver.quit();
    }
}
