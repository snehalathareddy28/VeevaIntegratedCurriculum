
# Selenium WebDriver Architecture

```mermaid
flowchart TD
    A[Java Automation Code] --> B[Selenium WebDriver API]
    B --> C[Browser Driver]
    C --> D{Browser}
    D --> E[Google Chrome]
    D --> F[Mozilla Firefox]
    D --> G[Microsoft Edge]
    E --> H[Browser Application]
    F --> H
    G --> H
    H --> I[Execute Browser Commands]
    I --> J[Return Response to Java Code]
```

## Components

1. Java Automation Code – contains test instructions.
2. WebDriver API – provides browser automation methods.
3. Browser Driver – communicates with the browser.
4. Browser – performs the requested actions.
5. Response – returns results to the Java program.
