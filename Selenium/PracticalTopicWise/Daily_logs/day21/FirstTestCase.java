package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/");

        // Get actual title
        String act_title = driver.getTitle();

        // Print actual and expected titles
        System.out.println("Actual Title: " + act_title);
        System.out.println("Expected Title: Your Store");

        if (act_title.equals("Your Store")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        driver.quit();
    }
}
