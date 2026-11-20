
# Singleton Design Pattern – Object Creation Flow

```mermaid
flowchart TD
    A([Program Starts]) --> B[Call getInstance]
    B --> C{Instance is null?}
    C -->|Yes| D[Create ConfigurationManager Object]
    C -->|No| E[Return Existing Object]
    D --> F[Store Object in Static Variable]
    F --> G[Return Instance]
    E --> H[Use ConfigurationManager]
    G --> H
    H --> I[Call getInstance Again]
    I --> E
```

## Key Concepts

- Private constructor prevents external object creation.
- Static variable stores the single instance.
- Public static method provides access.
- Repeated calls return the same instance.

## Expected Result

All references point to the same object.
