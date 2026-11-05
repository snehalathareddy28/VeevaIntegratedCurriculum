# Student Management Application

A Java-based student management project containing a console-driven student record prototype and a graphical registration interface built with Java Swing.

## 1. Project Overview

The project explores how Java can be used to collect student information, structure data using classes, and build simple registration workflows.

It currently contains two independent prototypes:

- **Console-based application:** Accepts student details and appends a record to a CSV file.
- **GUI-based application:** Provides a Swing registration form with basic input validation.

The project also includes an abstract `Person` class as a foundation for object-oriented modelling.

## 2. Objectives

- Practise Java classes, objects, constructors, and methods.
- Understand abstraction and encapsulation.
- Accept and validate user input.
- Perform basic file-writing operations.
- Explore graphical interfaces using Java Swing.
- Understand how student records can be represented and stored.

## 3. Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application programming |
| Java Swing | Graphical registration interface |
| Java AWT | GUI layout management |
| FileWriter | Writing student records |
| BufferedWriter | Buffered file output |
| CSV | Simple record storage format |
| IntelliJ IDEA | Development environment |

## 4. Current Project Structure

```text
StudentManagementApp/
├── .gitignore
├── README.md
├── java/
│   ├── Person.java
│   ├── StudentManagement.java
│   └── org/
│       └── example/
│           ├── Main.java
│           └── Student.java
└── src/
    └── Main.java
```

## 5. Implementation Details

### A. Person.java — Abstract Class

Defines common person attributes:

- Roll number
- Name
- Age

Uses private fields with public getter and setter methods.

The abstract `displayDetails()` method establishes a contract for subclasses.

**OOP concept:** Abstraction and encapsulation.

### B. StudentManagement.java — Console Application

Accepts the following information from the user:

- Roll number
- Student name
- Age
- Marks in five subjects
- Grade

Uses `FileWriter` in append mode and `BufferedWriter` to write student records into `Students.csv`.

**Java concepts:** Scanner, exception handling, file handling, try-with-resources, and CSV output.

**Current implementation:** Add-record functionality only.

### C. src/Main.java — Swing Registration Interface

Creates a graphical registration form with:

- Student ID
- Student Name
- Email
- Course
- Submit button

Uses `JFrame`, `JPanel`, `JTextField`, `JButton`, and `JOptionPane`.

The form checks whether the input fields are empty before displaying a registration confirmation message.

**Current implementation:** Basic GUI and empty-field validation. Registration data is not yet persisted.

### D. Student.java

Reserved for the student model. The class is currently a placeholder and can be extended with student-specific attributes and behaviour.

## 6. Console Application Workflow

```text
Start Application
       |
       v
Accept Student Details
       |
       v
Accept Five Subject Marks
       |
       v
Accept Grade
       |
       v
Format CSV Record
       |
       v
Append Record to Students.csv
       |
       v
Display Success Message
       |
       v
End
```

## 7. CSV Record Format

The intended record format is:

```text
RollNo,Name,Age,Mark1,Mark2,Mark3,Mark4,Mark5,Grade
```

Example:

```text
101,Sneha,21,85,90,78,88,92,A
```

The example illustrates the intended format; the current source code needs a correction to write the entered student name instead of the literal word `name`.

## 8. Running the Applications

Open the project in IntelliJ IDEA.

### Console application

Run `StudentManagement.java` from the `java` directory.

The application requests student details and writes the record to `Students.csv` in its working directory.

### Swing application

Run `Main.java` from the `src` directory.

A registration window opens, allowing the user to enter student information and submit the form.

**Note:** These are separate entry points. Run them independently rather than treating them as one integrated application.

## 9. Current Scope and Future Enhancements

The following features are planned improvements, not completed functionality:

- Implement a dedicated `Student` class extending `Person`.
- Add input validation for roll number, age, marks, and grade.
- Implement Read All and Search by Roll Number.
- Implement Update and Delete operations.
- Add duplicate roll-number detection.
- Persist GUI registration data.
- Integrate the console and GUI workflows.
- Separate model, service, and file-handling responsibilities.
- Add automated tests for student record operations.

## 10. Learning Outcomes

This project provides practical exposure to:

- Object-oriented programming fundamentals.
- Abstract classes and access modifiers.
- Console input using `Scanner`.
- Java file output and resource management.
- Basic exception handling.
- GUI development using Java Swing.
- Structured CSV-based data storage.

---

**Project status:** Initial console and GUI prototypes. Full CRUD functionality and integration are future enhancements.