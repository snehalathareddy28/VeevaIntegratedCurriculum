package Day31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down
        js.executeScript("window.scrollBy(0, 500)");

        Thread.sleep(2000);

        // Scroll further down
        js.executeScript("window.scrollBy(0, 500)");

        Thread.sleep(2000);

        // Scroll to top
        js.executeScript("window.scrollTo(0, 0)");

        Thread.sleep(2000);

        driver.quit();
    }
}