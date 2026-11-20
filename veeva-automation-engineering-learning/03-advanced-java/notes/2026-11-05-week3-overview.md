# Week 3 – Advanced Java and Introduction to Test Automation

**Date:** 05 November 2026  
**Training Period:** 05 November – 13 November 2026  
**Focus:** Design Patterns and Test Automation Fundamentals

## 1. Learning Objectives

The objective of this week is to understand reusable software design patterns and apply them to build maintainable, flexible, and loosely coupled Java applications.

Additionally, this week introduces browser automation using Selenium WebDriver.

By the end of this week, I aim to:

- Understand Singleton and Builder design patterns.
- Develop reusable Java configuration components.
- Read application settings from external configuration files.
- Understand manual testing versus automation testing.
- Explore the Selenium automation suite.
- Configure a Selenium Maven project.
- Execute my first browser automation scripts.

## 2. Topics Covered

### Advanced Java – Design Patterns

**Singleton Pattern**
- Ensuring only one instance of a class exists.
- Private constructors.
- Static instance management.
- Centralised configuration management.

**Builder Pattern**
- Step-by-step object creation.
- Method chaining.
- Handling optional configuration values.
- Creating multiple objects with different configurations.

### Automation Fundamentals
- Introduction to test automation.
- Manual testing vs. automation testing.
- Benefits and limitations of automation.
- Identifying automation candidates.

### Selenium Introduction
- Selenium IDE.
- Selenium WebDriver.
- Selenium Grid.
- Browser automation fundamentals.

## 3. Hands-on Practical Project

### Automation Configuration Manager

Build a reusable Java configuration manager using Singleton and Builder patterns.

**Functional requirements:**

1. Create a Singleton `ConfigurationManager`.
2. Create a Builder-based `TestConfig`.
3. Read browser configuration.
4. Read application URL.
5. Read timeout values.
6. Create multiple `TestConfig` objects.
7. Verify that only one `ConfigurationManager` instance exists.

### Sample Configuration

```properties
browser=chrome
url=https://www.saucedemo.com/
timeout=10
```

## 4. Selenium Practical

Set up Selenium WebDriver and execute browser-launch scripts using:

- Chrome
- Firefox
- Microsoft Edge

## 5. Tools and Technologies

| Tool | Purpose |
|---|---|
| Java 17 | Programming |
| IntelliJ IDEA | Development environment |
| Maven | Dependency management |
| Selenium WebDriver | Browser automation |
| Git | Version control |

## 6. Expected Learning Outcome

Understand the importance of design patterns, implement reusable Java components, and gain foundational knowledge of browser automation.

**Next Topic:** Singleton Design Pattern.