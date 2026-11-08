package Day22;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
public class Practice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/?utm_source=chatgpt.com");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total no of links in whole wesite:"+links.size());

        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total number of images in website:"+images.size());
        
        driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.name("email")).sendKeys("swetharedyy911@gmail.com");
        driver.findElement(By.name("password")).sendKeys("sneha123");
        driver.findElement(By.cssSelector(".btn.btn-default")).click();
        driver.close();
    }
}
