package PracticalTopicWise.Daily_logs.Day42Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class TestngAnnotations {
    WebDriver driver;

    @BeforeMethod
    void  openApp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test
    void titleCheck(){
        //boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        //System.out.println("Is displayed :"+status);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,"OrangeHRM","not matched");
    }

    @Test
    void testLogin(){
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"login failed! dashboard not opened");
    }

    @AfterMethod
    void testClose(){
        driver.close();
    }

}
