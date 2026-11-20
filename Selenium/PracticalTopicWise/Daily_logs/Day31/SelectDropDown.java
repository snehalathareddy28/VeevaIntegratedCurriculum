package Day31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectDropDown {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement dropdownELe = driver.findElement(By.id("country"));
        Select dropdown = new Select(dropdownELe);

        //select option from the dropdown
        // dropdown.selectByVisibleText("India");
        //dropdown.selectByValue("india");
        //dropdown.selectByIndex(3);

        //capture the options from the  dropdown
        List<WebElement> options = dropdown.getOptions();
        System.out.println("Total number of options:"+options.size());

        //printing the weboptions
        for(WebElement x : options){
           System.out.println(x.getText());
        }

        //for(int i=0;i<options.size();i++){
         //   System.out.println(options.get(i).getText());
        //}
    }
}
