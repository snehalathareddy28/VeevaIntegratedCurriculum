# First Selenium WebDriver Automation Script

**Date:** 12 November 2026  
**Category:** Selenium Practical Implementation

## 1. Objective

Create and execute the first Selenium WebDriver scripts using Java.

The objective is to:

- Launch Chrome.
- Launch Firefox.
- Launch Microsoft Edge.
- Navigate to a website.
- Retrieve the page title.
- Retrieve the current URL.
- Close the browser session.

## 2. Chrome Browser Automation

**File:** `ChromeLaunchTest.java`

```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLaunchTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            driver.manage().window().maximize();

            driver.get("https://www.saucedemo.com/");

            System.out.println("Browser: Chrome");
            System.out.println("Title: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());

        } finally {

            driver.quit();
        }
    }
}
```

## 3. Firefox Browser Automation

**File:** `FirefoxLaunchTest.java`

```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLaunchTest {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        try {

            driver.manage().window().maximize();

            driver.get("https://www.saucedemo.com/");

            System.out.println("Browser: Firefox");
            System.out.println("Title: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());

        } finally {

            driver.quit();
        }
    }
}
```

## 4. Microsoft Edge Browser Automation

**File:** `EdgeLaunchTest.java`

```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeLaunchTest {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        try {

            driver.manage().window().maximize();

            driver.get("https://www.saucedemo.com/");

            System.out.println("Browser: Edge");
            System.out.println("Title: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());

        } finally {

            driver.quit();
        }
    }
}
```

## 5. Explanation of Important Methods

| Method | Explanation |
|---|---|
| `new ChromeDriver()` | Starts a Chrome browser session |
| `new FirefoxDriver()` | Starts a Firefox browser session |
| `new EdgeDriver()` | Starts an Edge browser session |
| `driver.get()` | Opens a website |
| `driver.getTitle()` | Retrieves the page title |
| `driver.getCurrentUrl()` | Retrieves the current URL |
| `maximize()` | Maximizes the browser window |
| `driver.quit()` | Ends the browser session |

## 6. Expected Execution Flow

```text
Start Java Program
       |
       v
Create WebDriver
       |
       v
Launch Browser
       |
       v
Maximize Window
       |
       v
Open SauceDemo
       |
       v
Print Title and URL
       |
       v
Close Browser
       |
       v
End Program
```

## 7. Important Difference: close() vs quit()

**driver.close()**
- Closes the current browser window.
- The session may remain active if other windows exist.

**driver.quit()**
- Closes all windows associated with the WebDriver session.
- Ends the WebDriver session.

## 8. Practical Checklist

- [ ] Chrome launched successfully.
- [ ] Firefox launched successfully.
- [ ] Edge launched successfully.
- [ ] SauceDemo opened successfully.
- [ ] Page title printed.
- [ ] Current URL printed.
- [ ] Browser session closed successfully.

## Learning Outcome

Understand the basic WebDriver lifecycle and successfully launch different browsers using Java.