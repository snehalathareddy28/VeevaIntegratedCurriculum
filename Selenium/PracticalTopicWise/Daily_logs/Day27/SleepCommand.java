package Day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SleepCommand {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //here we are going to use thread.sleep command because we getting NOSuchElement Exception
        Thread.sleep(5000);
        driver.findElement(By.name("username")).sendKeys("Admin");
    }
}
