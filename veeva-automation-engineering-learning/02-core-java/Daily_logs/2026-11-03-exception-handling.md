# Exception Handling & Robust Java Applications

**Date:** 3 November 2026  
**Focus:** Error handling, exception propagation, and application reliability

## Objective
Review exception-handling mechanisms to prevent unexpected failures from interrupting normal application flow and to improve error reporting.

## Technical Areas Reviewed
- Exception hierarchy: `Throwable`, `Exception`, and `Error`.
- Checked and unchecked exceptions.
- `try`, `catch`, and `finally`.
- `throw` for explicitly throwing an exception.
- `throws` for declaring exceptions that a method may propagate.
- Multiple catch blocks and exception propagation.
- Custom exception classes.
- Try-with-resources for automatic resource closure.

## Practical Application
Example — validating input using a custom exception:

```java
class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

public class ValidationDemo {

    static void validateAge(int age)
            throws InvalidAgeException {

        if (age < 18) {
            throw new InvalidAgeException(
                "Age must be 18 or above"
            );
        }

        System.out.println("Validation successful");
    }

    public static void main(String[] args) {
        try {
            validateAge(16);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

## Engineering Takeaways
- Checked exceptions require handling or declaration.
- Unchecked exceptions generally represent programming or runtime issues.
- Custom exceptions communicate application-specific validation failures.
- Try-with-resources helps close resources safely.
- Meaningful exception messages improve troubleshooting.

**Outcome:** Reinforced defensive programming and exception-management practices for more reliable Java applications.