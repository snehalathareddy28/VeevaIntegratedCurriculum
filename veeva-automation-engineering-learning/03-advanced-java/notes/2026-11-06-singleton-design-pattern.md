# Singleton Design Pattern in Java

**Date:** 06 November 2026  
**Category:** Advanced Java – Creational Design Patterns

## 1. Introduction

Singleton is a creational design pattern that ensures a class has only one instance and provides a common access point to that instance.

It is useful when multiple components of an application need to access the same shared object.

### Real-World Applications

- Configuration management.
- Logging systems.
- Application settings.
- Shared service managers.

## 2. Key Concepts

| Concept | Explanation |
|---|---|
| Private constructor | Prevents direct object creation from outside the class |
| Static instance | Stores the shared instance |
| Static method | Provides access to the instance |
| Lazy initialization | Creates the instance only when required |

## 3. Singleton Implementation

**File:** `ConfigurationManager.java`

```java
public class ConfigurationManager {

    private static ConfigurationManager instance;

    private ConfigurationManager() {
        System.out.println("Configuration Manager Created");
    }

    public static ConfigurationManager getInstance() {

        if (instance == null) {
            instance = new ConfigurationManager();
        }

        return instance;
    }

    public void displayMessage() {
        System.out.println("Singleton is working successfully");
    }
}
```

## 4. Testing Singleton

**File:** `SingletonTest.java`

```java
public class SingletonTest {

    public static void main(String[] args) {

        ConfigurationManager obj1 =
                ConfigurationManager.getInstance();

        ConfigurationManager obj2 =
                ConfigurationManager.getInstance();

        obj1.displayMessage();

        System.out.println("Same instance: " + (obj1 == obj2));
    }
}
```

### Expected Output

```text
Configuration Manager Created
Singleton is working successfully
Same instance: true
```

## 5. How Does It Work?

1. The first call to `getInstance()` checks whether an instance exists.
2. Since the instance is initially null, a new object is created.
3. The object is stored in the static variable.
4. The second call returns the already existing object.
5. Both references point to the same object.

**Important:** `==` compares object references, not the internal values of the objects.

## 6. Thread-Safe Singleton

The basic implementation above is not thread-safe. Multiple threads could create separate objects simultaneously.

A static holder implementation provides thread-safe lazy initialization:

```java
public class ConfigurationManager {

    private ConfigurationManager() {
    }

    private static class Holder {

        private static final ConfigurationManager INSTANCE =
                new ConfigurationManager();
    }

    public static ConfigurationManager getInstance() {
        return Holder.INSTANCE;
    }
}
```

## 7. Advantages

- Controls object creation.
- Avoids unnecessary instances.
- Provides a shared configuration object.
- Supports centralised application management.

## 8. Interview Questions

**Q1. What is Singleton?**

A design pattern that ensures only one instance of a class exists.

**Q2. Why is the constructor private?**

To prevent other classes from directly creating objects.

**Q3. What is lazy initialization?**

Creating an object only when it is first required.

**Q4. Is a basic Singleton implementation thread-safe?**

No. A basic lazy implementation without synchronization or another concurrency-safe approach is not thread-safe.

## 9. Practical Assignment

- Implement Singleton independently.
- Create two references.
- Verify both references point to the same object.
- Try accessing the private constructor from another class and observe the compilation error.

## Learning Outcome

Understand Singleton implementation, object creation control, lazy initialization, and the importance of thread safety.