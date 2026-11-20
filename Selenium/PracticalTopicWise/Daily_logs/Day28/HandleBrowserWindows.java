package Day28;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandleBrowserWindows{
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Set<String> windowIDS = driver.getWindowHandles();

        for(String wind : windowIDS){
                String title = driver.switchTo().window(wind).getTitle();
                System.out.println(title);
            if(title.equals("Human Resources Management Software | OrangeHRM"))
            {
                  driver.close();
                }
        }
    }
}
