# Week 3 – Practical Review and Learning Summary

**Date:** 13 November 2026  
**Training Period:** 05 November – 13 November 2026

## 1. Week 3 Overview

This week focused on Advanced Java design patterns and the fundamentals of browser test automation.

The learning journey covered reusable Java object creation, configuration management, and Selenium environment setup.

## 2. Topics Studied

### Advanced Java

- Singleton design pattern.
- Builder design pattern.
- Private constructors.
- Static methods and variables.
- Lazy initialization.
- Method chaining.
- Object creation and validation.

### Configuration Management

- Java Properties class.
- Reading external configuration files.
- Browser configuration.
- Application URL configuration.
- Timeout configuration.
- Reusable configuration objects.

### Automation Fundamentals

- Manual testing vs. automation testing.
- Advantages and limitations of automation.
- Automation test case selection.
- Regression testing.
- Smoke testing.
- Data-driven testing.

### Selenium

- Selenium IDE.
- Selenium WebDriver.
- Selenium Grid.
- Java Maven project setup.
- Browser driver management.
- Chrome, Firefox, and Edge automation.

## 3. Design Pattern Comparison

| Feature | Singleton | Builder |
|---|---|---|
| Category | Creational | Creational |
| Purpose | Controls instance creation | Controls object construction |
| Main method | `getInstance()` | `build()` |
| Example | ConfigurationManager | TestConfig |

## 4. Practical Project Summary

### Automation Configuration Manager

**Project requirements:**

- Create a Singleton ConfigurationManager.
- Read values from `config.properties`.
- Build TestConfig objects using Builder.
- Support multiple browser configurations.
- Validate configuration values.
- Verify Singleton instance uniqueness.

### Selenium Browser Automation

**Project requirements:**

- Create a Maven Selenium project.
- Add Selenium dependency.
- Launch Chrome.
- Launch Firefox.
- Launch Edge.
- Open SauceDemo.
- Print page title and URL.
- Close browser sessions.

## 5. Interview Preparation

**Q1. What is Singleton?**

A creational design pattern that ensures only one instance of a class exists.

**Q2. What is Builder?**

A design pattern used to construct objects step by step.

**Q3. Why do we use a Properties file?**

To store configuration values separately from application source code.

**Q4. What is Selenium WebDriver?**

An API that allows automation scripts to control web browsers.

**Q5. What is Selenium Grid?**

A tool for running Selenium tests across multiple machines and browser environments.

**Q6. What is Maven?**

A Java build automation and dependency management tool.

**Q7. What is regression testing?**

Testing existing application functionality after changes to identify unintended failures.

**Q8. What is the difference between close() and quit()?**

`close()` closes the current window, while `quit()` closes all windows associated with the WebDriver session and ends the session.

## 6. Practical Completion Tracker

- [ ] Singleton implementation.
- [ ] Builder implementation.
- [ ] ConfigurationManager integration.
- [ ] Properties file loading.
- [ ] Multiple TestConfig objects.
- [ ] Singleton uniqueness verification.
- [ ] Automation fundamentals.
- [ ] Selenium suite overview.
- [ ] Maven Selenium environment setup.
- [ ] Chrome browser automation.
- [ ] Firefox browser automation.
- [ ] Edge browser automation.

## 7. Final Learning Outcome

Develop foundational knowledge of Java design patterns and apply them to a reusable automation configuration component.

Understand the Selenium automation ecosystem, prepare a Java Maven environment, and execute basic cross-browser automation scripts.

## 8. Next Learning Focus

Continue developing Selenium automation skills through:

- WebElement interactions.
- Locators: ID, Name, CSS Selector, XPath.
- Browser navigation.
- Dropdowns and checkboxes.
- Alerts and frames.
- Explicit waits.
- TestNG.
- Page Object Model.

**Portfolio:** [VeevaIntegratedCurriculum](https://github.com/snehalathareddy28/VeevaIntegratedCurriculum)