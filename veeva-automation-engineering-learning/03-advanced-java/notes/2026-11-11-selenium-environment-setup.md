# Selenium WebDriver – Environment Setup

**Date:** 11 November 2026  
**Category:** Automation Environment Setup

## 1. Objective

Prepare a Java development environment for Selenium WebDriver automation using IntelliJ IDEA and Maven.

## 2. Required Tools

| Tool | Purpose |
|---|---|
| Java JDK 17 | Java development |
| IntelliJ IDEA | IDE |
| Maven | Build and dependency management |
| Selenium WebDriver | Browser automation |
| Chrome / Firefox / Edge | Browsers under test |
| Git and GitHub | Version control |

## 3. Verify Java Installation

Open Git Bash or PowerShell.

```bash
java -version
```

Verify the compiler:

```bash
javac -version
```

Verify Maven:

```bash
mvn -version
```

Ensure Maven is using the intended Java installation.

## 4. Create Maven Project in IntelliJ

1. Open IntelliJ IDEA.
2. Select New Project.
3. Choose Maven.
4. Select JDK 17.
5. Enter the project name.
6. Create the project.

## 5. Add Selenium Dependency

Add the following dependency inside `pom.xml`:

```xml
<dependencies>

    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.27.0</version>
    </dependency>

</dependencies>
```

Reload Maven after saving the file.

## 6. Maven Project Structure

```text
SeleniumProject/
│
├── src/
│   ├── main/
│   │   └── java/
│   │
│   └── test/
│       └── java/
│
└── pom.xml
```

## 7. Browser Driver Management

Selenium 4.6 and later includes Selenium Manager.

In supported environments, Selenium Manager can automatically discover, download, and manage compatible browser drivers.

The browser itself must still be installed.

For a basic Selenium 4.27.0 setup, manual driver path configuration is generally unnecessary.

## 8. Verify the Maven Project

Run:

```bash
mvn clean compile
```

This checks whether the project compiles successfully.

If TestNG is configured, execute:

```bash
mvn test
```

## 9. Common Setup Problems

| Problem | Possible Solution |
|---|---|
| Java not recognised | Check PATH and JAVA_HOME |
| Maven not recognised | Check Maven installation and PATH |
| Selenium imports unresolved | Reload Maven |
| Browser fails to launch | Check browser installation and Selenium Manager logs |
| Dependency download failure | Check network and Maven repository configuration |

## Learning Outcome

Understand how to create a Java Maven project, configure Selenium dependencies, and prepare a browser automation environment.