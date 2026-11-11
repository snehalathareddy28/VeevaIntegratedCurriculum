package Day22;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import  org.openqa.selenium.By;
public class LocatorsDemo {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.demoblaze.com/index.html/");
        driver.manage().window().maximize();

        //name locator
        //driver.findElement(By.name("search")).sendKeys("Mac");

        //id locator
        //boolean logodispalystatus = driver.findElement(By.id("logo")).isDisplayed();
        //System.out.println(logodispalystatus);

        //linktext & partialLinkText
        //driver.findElement(By.linkText("Tablets")).click();
        //driver.findElement(By.partialLinkText("Tab")).click();

        //tagName and Class --> this both are used for locating group of web element nto for specific web element
        //EX: we need to measure a no of links elements in a webpage
        List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
        for(WebElement x : headerLinks){
            System.out.println(x);
        }
        System.out.println("total no of link elements in header:"+headerLinks.size());

        //if need to count all link elements in web
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("total number of links:"+links.size());

        //if we need to find all image elements in web
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("total images:"+images.size());
    }
}
