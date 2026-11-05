# Lambda Expressions & Functional Interfaces

**Date:** 2 November 2026  
**Focus:** Concise functional programming in Java

## Objective
Review lambda expressions and functional interfaces to reduce boilerplate code and support functional-style programming.

## Technical Areas Reviewed
- Lambda expression syntax and parameters.
- Functional interfaces and the single abstract method concept.
- Built-in functional interfaces:
  - `Predicate<T>` — evaluates a condition.
  - `Function<T, R>` — transforms an input into an output.
  - `Consumer<T>` — performs an operation on an input.
  - `Supplier<T>` — supplies a value.
- Lambda expressions with collections and Streams.
- Method references using `::`.

## Practical Application
Example — using a lambda expression to filter data:

```java
import java.util.List;
import java.util.function.Predicate;

public class LambdaDemo {
    public static void main(String[] args) {
        List<Integer> numbers =
            List.of(10, 15, 20, 25, 30);

        Predicate<Integer> isEven =
            number -> number % 2 == 0;

        numbers.stream()
            .filter(isEven)
            .forEach(System.out::println);
    }
}
```

## Engineering Takeaways
- Lambda expressions provide concise implementations of functional interfaces.
- Functional interfaces enable behaviour to be passed as method arguments.
- Method references simplify certain lambda expressions.
- Lambdas integrate naturally with Streams and collection operations.

**Outcome:** Reinforced functional programming techniques for writing concise, reusable, and readable Java code.