
# Builder Design Pattern – Object Construction Flow

```mermaid
flowchart TD
    A([Start]) --> B[Create Builder Object]
    B --> C[Set Browser]
    C --> D[Set URL]
    D --> E[Set Timeout]
    E --> F[Set Headless Mode]
    F --> G[Call build]
    G --> H[Create TestConfig Object]
    H --> I[Display Configuration]
    I --> J([End])
```

## Key Concepts

- Builder separates object construction from representation.
- Supports readable method chaining.
- Allows optional configuration values.
- Useful for creating automation configurations.
