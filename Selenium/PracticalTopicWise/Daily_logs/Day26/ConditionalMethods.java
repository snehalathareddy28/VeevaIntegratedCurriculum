package Day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        //isDisplayed
        WebElement logo = driver.findElement(By.xpath(("//img[@class='logoClass']")));
        System.out.println("logo:"+logo.isDisplayed());

        boolean status1 = driver.findElement(By.xpath("//img[@class='logoClass']")).isDisplayed();
        System.out.println(status1);

        //isEnabled
        boolean status2 = driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).isEnabled();
        System.out.println(status2);

        //isSelected
        WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));
        WebElement radio2 = driver.findElement(By.xpath("//input[@value='radio2']"));
        System.out.println("Before selected....");
        System.out.println("radio1:"+radio1.isSelected());
        System.out.println("radio2:"+radio2.isSelected());
        driver.findElement(By.xpath("//input[@value='radio1']")).click();
        driver.findElement(By.xpath("//input[@value='radio1']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());
        System.out.println("After selected....");
        System.out.println("radio1:"+radio1.isSelected());
        System.out.println("radio2:"+radio2.isSelected());
    }
}
