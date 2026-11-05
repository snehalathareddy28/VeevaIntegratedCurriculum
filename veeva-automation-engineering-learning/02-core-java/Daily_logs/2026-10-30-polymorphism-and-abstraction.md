# Polymorphism & Abstraction in Java

**Date:** 30 October 2026  
**Focus:** Flexible object behaviour and abstraction-based design

## Objective
Understand how polymorphism and abstraction help build extensible applications with reduced dependency on concrete implementations.

## Technical Areas Reviewed

### 1. Polymorphism
- Compile-time polymorphism through method overloading.
- Runtime polymorphism through method overriding.
- Dynamic method dispatch.
- Parent-class references referring to child-class objects.

### 2. Abstraction
- Hiding implementation details while exposing essential behaviour.
- Abstract classes and abstract methods.
- Interfaces as contracts for implementing classes.
- Understanding when to use an interface versus an abstract class.

## Practical Application
Example — runtime polymorphism:

```java
class Notification {
    void send() {
        System.out.println("Sending notification");
    }
}

class EmailNotification extends Notification {
    @Override
    void send() {
        System.out.println("Sending email");
    }
}

public class Main {
    public static void main(String[] args) {
        Notification notification =
            new EmailNotification();

        notification.send();
    }
}
```

The overridden method is selected at runtime based on the actual object type.

## Engineering Takeaways
- Polymorphism allows a common interface to support different behaviours.
- Abstraction separates what an object does from how it does it.
- Interfaces support loosely coupled designs.
- These concepts are useful in notification systems, payment processing, and test automation frameworks.

**Outcome:** Reinforced object-oriented design techniques for building flexible and maintainable Java applications.