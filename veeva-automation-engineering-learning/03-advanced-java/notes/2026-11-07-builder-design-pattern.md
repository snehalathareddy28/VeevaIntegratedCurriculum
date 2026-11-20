# Builder Design Pattern in Java

**Date:** 07 November 2026  
**Category:** Advanced Java – Creational Design Patterns

## 1. Introduction

Builder is a creational design pattern used to construct complex objects step by step.

It is especially useful when a class has multiple fields and some of those fields are optional.

## 2. Problem Without Builder

Imagine creating a test configuration containing:

- Browser.
- Application URL.
- Timeout.
- Headless mode.

A constructor with many parameters can become difficult to read and maintain.

The Builder pattern makes object creation more readable.

## 3. Builder Pattern Structure

The Builder pattern commonly contains:

1. Product class – the object being created.
2. Builder class – collects configuration values.
3. Build method – creates and returns the final object.

## 4. Implementation

**File:** `TestConfig.java`

```java
public class TestConfig {

    private final String browser;
    private final String url;
    private final int timeout;

    private TestConfig(Builder builder) {

        this.browser = builder.browser;
        this.url = builder.url;
        this.timeout = builder.timeout;
    }

    public String getBrowser() {
        return browser;
    }

    public String getUrl() {
        return url;
    }

    public int getTimeout() {
        return timeout;
    }

    public static class Builder {

        private String browser = "chrome";
        private String url = "https://www.saucedemo.com/";
        private int timeout = 10;

        public Builder browser(String browser) {
            this.browser = browser;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public TestConfig build() {

            if (browser == null || browser.isBlank()) {
                throw new IllegalArgumentException(
                        "Browser cannot be empty");
            }

            if (url == null || url.isBlank()) {
                throw new IllegalArgumentException(
                        "URL cannot be empty");
            }

            if (timeout <= 0) {
                throw new IllegalArgumentException(
                        "Timeout must be positive");
            }

            return new TestConfig(this);
        }
    }
}
```

## 5. Creating Multiple Objects

**File:** `TestConfigBuilderTest.java`

```java
public class TestConfigBuilderTest {

    public static void main(String[] args) {

        TestConfig chromeConfig =
                new TestConfig.Builder()
                        .browser("chrome")
                        .url("https://www.saucedemo.com/")
                        .timeout(10)
                        .build();

        TestConfig firefoxConfig =
                new TestConfig.Builder()
                        .browser("firefox")
                        .url("https://example.com/")
                        .timeout(20)
                        .build();

        System.out.println("Chrome Configuration");

        System.out.println(chromeConfig.getBrowser());
        System.out.println(chromeConfig.getUrl());
        System.out.println(chromeConfig.getTimeout());

        System.out.println("\nFirefox Configuration");

        System.out.println(firefoxConfig.getBrowser());
        System.out.println(firefoxConfig.getUrl());
        System.out.println(firefoxConfig.getTimeout());
    }
}
```

### Expected Output

```text
Chrome Configuration
chrome
https://www.saucedemo.com/
10

Firefox Configuration
firefox
https://example.com/
20
```

## 6. Understanding Method Chaining

Consider:

```java
new TestConfig.Builder()
        .browser("chrome")
        .url("https://www.saucedemo.com/")
        .timeout(10)
        .build();
```

Each setter method returns `this`, which refers to the current Builder object.

This allows multiple method calls to be chained together.

## 7. Singleton vs Builder

| Singleton | Builder |
|---|---|
| Controls number of instances | Controls object construction |
| Usually provides one shared instance | Can create multiple objects |
| Uses `getInstance()` | Uses `build()` |
| Example: ConfigurationManager | Example: TestConfig |

## 8. Interview Questions

**Q1. What is Builder?**

A creational pattern for constructing objects step by step.

**Q2. Why do we use Builder?**

To make complex object creation readable and manageable.

**Q3. What is method chaining?**

Calling multiple methods in a sequence when each method returns an object that supports the next call.

**Q4. Can Builder create multiple objects?**

Yes. Each call to `build()` can return a new object.

## 9. Practical Assignment

- Create a `TestConfig` class.
- Add browser, URL, and timeout fields.
- Implement a nested Builder class.
- Create Chrome and Firefox configurations.
- Add validation for invalid values.
- Print and verify each configuration.

## Learning Outcome

Understand how Builder separates object construction from object representation and supports readable, flexible configuration.