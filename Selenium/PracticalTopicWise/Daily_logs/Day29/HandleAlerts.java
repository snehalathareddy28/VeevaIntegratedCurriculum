package Day29;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {
    public static  void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        //normal alert with ok button
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Thread.sleep(5000);
        //driver.switchTo().alert().accept();
        Alert myalert = driver.switchTo().alert();
        System.out.print(myalert.getText());
        myalert.accept();

        //2 confirmation Alert - ok & Cancel
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept(); // close alert using ok button
        driver.switchTo().alert().dismiss(); // close alert using cancel button

        //3 Prompt alert - Input box
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Thread.sleep(5000);

        Alert alert1 = driver.switchTo().alert();
        alert1.sendKeys("Welcome");
        myalert.accept();


    }
}
