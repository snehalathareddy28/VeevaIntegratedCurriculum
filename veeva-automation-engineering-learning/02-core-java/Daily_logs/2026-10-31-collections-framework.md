# Java Collections Framework

**Date:** 31 October 2026  
**Focus:** Dynamic data structures and collection selection

## Objective
Review Java collection types and understand how to select suitable data structures based on data access, uniqueness, and key-value requirements.

## Technical Areas Reviewed

| Collection | Purpose |
|---|---|
| `ArrayList` | Resizable list with index-based access |
| `LinkedList` | List implementation supporting operations at both ends |
| `HashSet` | Stores unique elements |
| `HashMap` | Stores key-value pairs |
| `List` | Ordered collection that permits duplicates |
| `Set` | Collection that prevents duplicate elements |
| `Map` | Key-value data structure with unique keys |

## Practical Application
Example — storing and retrieving student records using a `HashMap`:

```java
import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sneha");
        students.put(102, "Rahul");

        System.out.println(students.get(101));

        students.remove(102);

        for (Map.Entry<Integer, String> entry
                : students.entrySet()) {
            System.out.println(
                entry.getKey() + " : " + entry.getValue()
            );
        }
    }
}
```

## Engineering Takeaways
- Choose `List` when order and duplicate elements matter.
- Choose `Set` when uniqueness is required.
- Choose `Map` for efficient key-based lookup.
- Collection choice affects performance, readability, and data-management behaviour.

**Outcome:** Reinforced collection selection and data-handling techniques applicable to record-management and enterprise applications.