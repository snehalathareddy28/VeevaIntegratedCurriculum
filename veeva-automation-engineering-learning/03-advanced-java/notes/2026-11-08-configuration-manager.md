# Automation Configuration Manager Using Singleton and Builder

**Date:** 08 November 2026  
**Category:** Advanced Java – Practical Implementation

## 1. Project Overview

Develop a reusable Java automation configuration manager using Singleton and Builder design patterns.

The application will centralise browser and application settings so that automation tests can reuse configuration values.

## 2. Project Requirements

- Implement a Singleton `ConfigurationManager`.
- Implement a Builder-based `TestConfig`.
- Load values from an external properties file.
- Support browser, URL, and timeout configurations.
- Create multiple test configuration objects.
- Verify Singleton instance uniqueness.

## 3. Project Structure

```text
configuration-manager/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/week3/config/
│       │       ├── ConfigurationManager.java
│       │       ├── TestConfig.java
│       │       └── ConfigurationManagerTest.java
│       │
│       └── resources/
│           └── config.properties
│
└── pom.xml
```

## 4. Configuration Properties

**File:** `config.properties`

```properties
browser=chrome
url=https://www.saucedemo.com/
timeout=10
```

Properties files store configuration in key-value format.

## 5. Singleton ConfigurationManager

**File:** `ConfigurationManager.java`

```java
package com.week3.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {

    private final Properties properties = new Properties();

    private ConfigurationManager() {

        try (InputStream input =
                     getClass().getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new IllegalStateException(
                        "config.properties not found");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load configuration", e);
        }
    }

    private static class Holder {

        private static final ConfigurationManager INSTANCE =
                new ConfigurationManager();
    }

    public static ConfigurationManager getInstance() {
        return Holder.INSTANCE;
    }

    public String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Missing configuration: " + key);
        }

        return value;
    }

    public int getIntProperty(String key) {
        return Integer.parseInt(getProperty(key));
    }
}
```

## 6. Builder-Based TestConfig

**File:** `TestConfig.java`

```java
package com.week3.config;

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

        private String browser;
        private String url;
        private int timeout;

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
                        "Browser is required");
            }

            if (url == null || url.isBlank()) {
                throw new IllegalArgumentException(
                        "URL is required");
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

## 7. Integration Program

**File:** `ConfigurationManagerTest.java`

```java
package com.week3.config;

public class ConfigurationManagerTest {

    public static void main(String[] args) {

        ConfigurationManager manager1 =
                ConfigurationManager.getInstance();

        ConfigurationManager manager2 =
                ConfigurationManager.getInstance();

        System.out.println(
                "Same instance: " + (manager1 == manager2));

        TestConfig config1 =
                new TestConfig.Builder()
                        .browser(manager1.getProperty("browser"))
                        .url(manager1.getProperty("url"))
                        .timeout(manager1.getIntProperty("timeout"))
                        .build();

        TestConfig config2 =
                new TestConfig.Builder()
                        .browser("firefox")
                        .url("https://example.com/")
                        .timeout(20)
                        .build();

        display(config1);
        display(config2);
    }

    private static void display(TestConfig config) {

        System.out.println("\nBrowser: " + config.getBrowser());
        System.out.println("URL: " + config.getUrl());
        System.out.println("Timeout: " + config.getTimeout());
    }
}
```

## 8. Expected Output

```text
Same instance: true

Browser: chrome
URL: https://www.saucedemo.com/
Timeout: 10

Browser: firefox
URL: https://example.com/
Timeout: 20
```

## 9. Important Technical Concepts

| Concept | Application |
|---|---|
| Singleton | One shared ConfigurationManager |
| Builder | Creates multiple TestConfig objects |
| Properties | Reads external configuration |
| ClassLoader | Locates config.properties from resources |
| Validation | Prevents invalid configuration values |

## 10. Practical Validation Checklist

- [ ] ConfigurationManager has a private constructor.
- [ ] Both calls return the same instance.
- [ ] Properties file loads successfully.
- [ ] Browser value is read correctly.
- [ ] URL value is read correctly.
- [ ] Timeout is converted to an integer.
- [ ] Builder creates multiple configurations.
- [ ] Invalid configuration values are rejected.

## Learning Outcome

Build a reusable configuration component that combines Singleton and Builder patterns for automation framework configuration.