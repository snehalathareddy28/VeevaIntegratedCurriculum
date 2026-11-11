package Day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class XPathDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


            driver.get("https://testautomationpractice.blogspot.com/");
            driver.manage().window().maximize();

            driver.findElement(By.xpath("//input[@id='name']")).sendKeys("sneha");
            driver.findElement(By.xpath("//input[@placeholder='Enter EMail']")).sendKeys("sneha@gmail.com");
            driver.findElement(By.xpath("//input[@placeholder='Enter Phone']")).sendKeys("9010161152");
            driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("ananthapur");
            driver.findElement(By.xpath("//input[@value='female']")).click();
            driver.findElement(By.xpath("//input[@value='sunday']")).click();
            driver.findElement(By.xpath("//input[@value='monday']")).click();
            driver.findElement(By.xpath("//input[@value='tuesday']")).click();
            driver.findElement(By.xpath("//input[@value='wednesday']")).click();
            driver.findElement(By.xpath("//input[@value='thursday']")).click();
            driver.findElement(By.xpath("//input[@value='friday']")).click();
            driver.findElement(By.xpath("//input[@value='saturday']")).click();

            WebElement dropDown = driver.findElement(By.xpath("//select[@id='country']"));

            Select dropdown = new Select(dropDown);

            dropdown.selectByVisibleText("India");

            WebElement color = driver.findElement(By.xpath("//select[@id='colors']"));
            Select colors = new Select(color);
            colors.selectByIndex(1);

        WebElement animals = driver.findElement(By.xpath("//select[@id='animals']"));
        Select animal = new Select(animals);
        animal.selectByIndex(3);



    }
}

