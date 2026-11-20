package Day28;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class NavigationalCommands {
    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver = new ChromeDriver();

        //accepts URL only in the string format (get method)
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //In this we can use URL as String format and URL as object(navigate().to)
        //Method1
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //Method2
        URL myurl = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.navigate().to(myurl);

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.navigate().to("https://testautomationpractice.blogspot.com/");

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().refresh();


    }
}
