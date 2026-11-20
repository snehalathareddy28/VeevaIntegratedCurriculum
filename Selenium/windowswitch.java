import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import java.time.Duration;

public class windowswitch {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://127.0.0.1:5500/first.html");

        // 1. Click first link and switch to second window
        String firstWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("click1")).click();

        String secondWindow = "";
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(firstWindow)) {
                secondWindow = handle;
                driver.switchTo().window(secondWindow);
                break;
            }
        }

        // 2. Click second link and switch to third window
        driver.findElement(By.linkText("click2")).click();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(firstWindow) && !handle.equals(secondWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // 3. Read the heading on the third page
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }
}
