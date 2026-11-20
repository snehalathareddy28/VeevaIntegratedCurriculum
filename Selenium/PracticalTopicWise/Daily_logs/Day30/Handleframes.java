package Day30;

import Day31.JavaScriptDemo;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Handleframes {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        //passed frame as webelement
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));

        //frame1
        driver.switchTo().frame(frame1);
        //passed frame as index value
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");
        driver.switchTo().defaultContent();

        //frame2
        driver.switchTo().frame(1);

        //passed frame as webelement
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("welcome2");

        driver.switchTo().defaultContent(); //go back to page

        //Frame3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);

        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java");

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//label[@for='i9']//div[@class='bzfPab wFGF8']")).click();

        driver.findElement(By.xpath("//div[@id='i21']")).click();
        driver.findElement(By.xpath("//div[@id='i24']")).click();

        //if any thing doesn,t work we can use javascript for same process
        WebElement nextbtn = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",nextbtn);

        driver.switchTo().defaultContent();
    }
}
