# Object-Oriented Programming & Memory Management

**Date:** 29 October 2026  
**Focus:** Encapsulation, inheritance, and Java memory fundamentals

## Objective
Review object-oriented design principles and understand how Java manages objects and references during application execution.

## Technical Areas Reviewed

### 1. Encapsulation
- Bundling data and related methods within a class.
- Applying access modifiers to control visibility.
- Using private fields with public getters and setters.
- Protecting object state through controlled access.

### 2. Inheritance
- Reusing existing class functionality through `extends`.
- Understanding parent-child class relationships.
- Using `super` to access parent-class constructors and members.
- Supporting extensibility while reducing code duplication.

### 3. Memory Management
- Understanding stack and heap memory at a conceptual level.
- Object creation using the `new` keyword.
- References and object reachability.
- Garbage collection and automatic memory reclamation.
- Understanding how unnecessary object references can keep objects reachable.

## Practical Application
Example — encapsulation with controlled data access:

```java
class Student {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }
}
```

## Engineering Takeaways
- Encapsulation protects data integrity.
- Inheritance supports reuse and hierarchical modelling.
- Object references determine whether objects remain reachable.
- Garbage collection reduces the need for manual memory deallocation.

**Outcome:** Strengthened understanding of object-oriented design, data protection, and Java's automatic memory-management model.