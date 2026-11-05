# Java I/O & File-Based CRUD Operations

**Date:** 4 November 2026  
**Focus:** File handling, buffered I/O, and persistent data operations

## Objective
Review Java I/O mechanisms and apply file-handling concepts to structured record storage and retrieval.

## Technical Areas Reviewed
- Java File I/O and the `File` class.
- `FileReader` and `FileWriter`.
- `BufferedReader` and `BufferedWriter`.
- Reading files line by line using `readLine()`.
- Writing and appending data to files.
- Try-with-resources for resource management.
- CSV-based data storage and parsing.
- CRUD operations: Create, Read, Update, and Delete.

## Practical Application — Student Record Management

Considered a menu-driven student record system using CSV file storage.

**Student data fields:**
- Roll Number
- Name
- Age
- Marks in five subjects
- Grade

**Functional operations:**

| Operation | Description |
|---|---|
| Add Record | Add a new student record |
| Read All | Display all student records |
| Read by Roll Number | Retrieve a specific student |
| Read by Name | Search student records by name |
| Delete | Remove a record using roll number |
| Update | Modify existing student details |
| Exit | Terminate the application |

## Example — Buffered File Reading

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadDemo {
    public static void main(String[] args) {

        try (BufferedReader reader =
                 new BufferedReader(
                     new FileReader("students.csv"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(
                "File operation failed: " + e.getMessage()
            );
        }
    }
}
```

## Suggested Application Structure

- `Student.java` — student data model.
- `StudentService.java` — student record operations.
- `CSVFileHandler.java` — file reading and writing.
- `Main.java` — menu-driven application entry point.

## Engineering Takeaways
- Buffered I/O supports efficient file reading and writing.
- Append mode preserves existing records when adding new data.
- CSV files provide a simple format for structured record storage.
- Update and delete operations require reading and rewriting the relevant file data.
- Proper exception handling helps manage missing files and I/O failures.

**Outcome:** Consolidated Java file-handling concepts and the design of persistent, file-based CRUD applications.