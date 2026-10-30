# Week 1 — Testing Foundation
## SDLC, Testing Fundamentals, Jira, Xray, Confluence and Java Environment

**Training Track:** Automation QA Engineering  
**Learning Focus:** Software Development Life Cycle, Testing Fundamentals, Test Management and Development Environment Setup

---

# 1. Learning Objectives

The objective of this week was to understand the software development and testing lifecycle, learn how QA teams manage requirements and defects, practise test case management using Xray, explore Confluence documentation, and prepare a Java development environment using IntelliJ IDEA.

By the end of this learning phase, I focused on understanding how a QA engineer participates in the software development lifecycle and how testing activities are organized and documented in real projects.

# 2. SDLC — Software Development Life Cycle

## 2.1 What is SDLC?

SDLC is a structured process followed by software development teams to plan, design, develop, test, deploy and maintain software applications.

It helps teams develop software systematically while maintaining quality, cost and time efficiency.

## 2.2 Major SDLC Phases

### Phase 1: Requirements Analysis

- Understand customer and business requirements.
- Identify functional and non-functional requirements.
- Define what the application should do.
- Prepare requirement documentation.

**Example — Student Management System:**

- The administrator should be able to register a student.
- The administrator should be able to search for student details.
- The administrator should be able to update student information.

### Phase 2: Design

- Prepare the application architecture.
- Design the user interface.
- Define database structure.
- Decide how different modules communicate.

**Example:**

Designing a student registration form with Student ID, Name, Email, Course and Phone Number fields.

### Phase 3: Coding / Development

- Developers convert requirements and designs into working software.
- Implement application functionality.
- Integrate different modules.

**Example:**

Implementing Java classes and methods for student registration and validation.

### Phase 4: Testing

- Verify application functionality.
- Execute test cases.
- Identify and report defects.
- Retest fixed defects.
- Confirm that requirements are satisfied.

**Example:**

Verify that the application accepts valid student information and displays an appropriate confirmation message.

### Phase 5: Deployment

- Release the tested application into the target environment.
- Configure the application.
- Make the application available to users.

### Phase 6: Maintenance

- Fix defects discovered after release.
- Improve existing functionality.
- Support changing business requirements.

## 2.3 SDLC Flow

```text
Requirements Analysis
        |
        v
      Design
        |
        v
     Coding
        |
        v
     Testing
        |
        v
    Deployment
        |
        v
    Maintenance
```

**QA involvement:** QA participates in understanding requirements, preparing test scenarios, executing tests, reporting defects and validating fixes throughout the development process.

# 3. Fundamentals of Testing

## 3.1 Quality Assurance (QA)

Quality Assurance focuses on improving the processes used to develop software and preventing defects.

Important responsibilities:

- Review requirements.
- Identify possible quality risks.
- Prepare test scenarios and test cases.
- Verify that testing activities follow defined processes.
- Support continuous quality improvement.

**Example:**

Before a student registration feature is released, QA reviews the requirements and identifies possible validation scenarios, such as empty fields, invalid email addresses and duplicate student IDs.

## 3.2 System Integration Testing (SIT)

SIT verifies whether different application modules work correctly when integrated.

**Example — Student Management System:**

- Student Registration communicates with the Student Database.
- Student Search retrieves registered student information.
- Student Update modifies the correct student record.

The purpose is to verify communication and data flow between integrated components.

## 3.3 User Acceptance Testing (UAT)

UAT verifies whether the application satisfies business requirements and is suitable for actual users.

It is generally performed by business users, clients or designated representatives.

**Example:**

An administrator uses the Student Management System and verifies whether they can register, search and update student records as required.

## 3.4 SIT vs UAT

**SIT**
- Focus: Integration between application components.
- Typical participants: Testing and technical teams.
- Example: Verify that registration data reaches the database correctly.

**UAT**
- Focus: Business requirements and user acceptance.
- Typical participants: Business users or client representatives.
- Example: Verify that an administrator can successfully complete student registration.

# 4. Agile vs Waterfall

## 4.1 Agile Methodology

Agile is an iterative and incremental software development approach.

Characteristics:

- Work is divided into smaller iterations called sprints.
- Teams collaborate continuously.
- Requirements can evolve based on feedback.
- Testing is performed throughout development.
- Working software is delivered incrementally.

**Example:**

In a Student Management System, the team may implement registration in one sprint, search functionality in another sprint and profile updates in a later sprint.

## 4.2 Waterfall Methodology

Waterfall is a sequential software development approach.

Characteristics:

- Development follows predefined phases.
- Each phase is generally completed before the next begins.
- Requirements and planning are established early.
- Changes later in development can be more difficult to accommodate.

## 4.3 Agile vs Waterfall — Key Differences

**Agile**
- Iterative development.
- Frequent feedback.
- Flexible to changing requirements.
- Continuous testing and improvement.

**Waterfall**
- Sequential development.
- Phase-based execution.
- Requirements are generally defined early.
- Testing usually follows development.

# 5. Jira — Bug Tracking and Project Management

## 5.1 What is Jira?

Jira is an Atlassian project management and issue-tracking tool used by software teams to manage requirements, development activities, defects and project progress.

## 5.2 Understanding Jira Work Items

### Epic
Represents a large feature or business requirement.

Example: Student Management.

### Story
Represents a requirement from the user's perspective.

Example: As an administrator, I want to register a new student so that student details can be maintained.

### Task
Represents a specific activity that needs to be completed.

Example: Design the student registration form.

### Bug
Represents an error or unexpected application behaviour.

Example: The application accepts an invalid email address.

### Sub-task
Represents a smaller activity under a parent work item.

Example: Implement email validation.

**Example requirement structure:**

```text
Epic: Student Management
    |
    └── Story: Register a New Student
            |
            ├── Task: Design Registration Form
            ├── Task: Implement Validation
            └── Sub-task: Add Email Validation

Related Bug: Invalid Email Accepted
```

A Bug is a separate work item type and can be linked to the related Story.

## 5.3 Bug Lifecycle

A typical defect lifecycle:

```text
Open
  |
  v
In Progress
  |
  v
Fixed
  |
  v
Retesting
  |
  v
Closed
```

If the defect still exists during retesting, it may be reopened.

## 5.4 Severity vs Priority

**Severity:** Indicates the impact of a defect on the application.

**Priority:** Indicates how urgently the defect should be fixed.

Example:

A payment failure may be high severity and high priority because customers cannot complete transactions.

## 5.5 Jira Practical Implementation

**Project practised:** StudentManagement

Practical activities performed:

- Created and explored a Jira Cloud project.
- Created Epics for student management features.
- Created Stories for registration, search and profile management.
- Created Tasks for implementation activities.
- Created Bugs for application defects.
- Updated bug priorities and statuses.
- Assigned and linked related work items.
- Explored Jira workflows and backlog management.

### Example Bugs Practised

**Bug 1: Invalid Email Accepted**

Expected behaviour: The application should reject an invalid email address.

Observed behaviour: The application accepts an invalid email address.

**Bug 2: Duplicate Student IDs Allowed**

Expected behaviour: The application should prevent duplicate student IDs.

Observed behaviour: Duplicate student IDs are accepted.

**Bug 3: Incorrect Search Results**

Expected behaviour: Search should return the correct student records.

Observed behaviour: Search displays incorrect results.

## 5.6 Jira Query Language (JQL)

JQL is used to search, filter and organize Jira work items.

Example 1 — Retrieve all bugs:

```jql
project = "StudentManagement"
AND issuetype = Bug
ORDER BY priority DESC
```

Example 2 — Retrieve high-priority bugs:

```jql
project = "StudentManagement"
AND issuetype = Bug
AND priority = High
```

Example 3 — Retrieve work currently in progress:

```jql
project = "StudentManagement"
AND status = "In Progress"
ORDER BY updated DESC
```

Example 4 — Retrieve all stories:

```jql
project = "StudentManagement"
AND issuetype = Story
ORDER BY created DESC
```

**Practical learning:** Created and explored saved filters for bugs, high-priority bugs, stories, tasks, in-progress work and open work.

# 6. Xray — Test Case Management

## 6.1 What is Xray?

Xray is a test management solution integrated with Jira.

It helps QA teams create, organize, plan, execute and track test cases.

## 6.2 Important Xray Components

### Test
Defines what needs to be tested, including test steps and expected results.

### Precondition
Defines the conditions that must be satisfied before executing a test.

### Test Set
Groups related test cases.

### Test Plan
Organizes the testing scope and the tests planned for a release or feature.

### Test Execution
Records the actual execution of test cases and their results.

## 6.3 Xray Test Lifecycle

```text
Create Test
     |
     v
Add Precondition
     |
     v
Organize Test Set
     |
     v
Create Test Plan
     |
     v
Create Test Execution
     |
     v
Execute Test Steps
     |
     v
Record Results
     |
     v
Review Test Status
```

## 6.4 Practical Xray Implementation

**Project practised:** StudentManagement

Created and explored the following Xray work items:

- Test: STUD-22 — Verify student registration with valid details.
- Precondition: STUD-23 — Student registration page is accessible.
- Test Set: Student Registration Test Set.
- Test Plan: Student Registration Test Plan.
- Test Execution: STUD-26 — Student Registration Test Execution.

### Example Test Case

**Test Case:** Verify student registration with valid details.

**Precondition:** Student registration page is accessible.

**Test Data:**

- Student ID: STU101
- Name: Rahul Kumar
- Email: rahul101@example.com
- Course: CSE
- Phone: 9876543210

**Test Steps:**

Step 1: Open the student registration form.

Expected Result: Registration form should be displayed.

Step 2: Enter valid student details.

Expected Result: Application should accept the entered details.

Step 3: Click the Submit button.

Expected Result: Application should display a successful registration message.

**Execution Result:** Record the actual result for every step and assign the appropriate execution status based on observed behaviour.

## 6.5 Important Test Execution Concepts

**Pass:** Actual result matches the expected result.

**Fail:** Actual result does not match the expected result.

**To Do:** Test has not yet been executed.

**Blocked:** Test cannot be executed because of an unresolved dependency or issue.

A test should only be marked Pass after the expected behaviour has been verified.

# 7. Confluence — Test Documentation

## 7.1 What is Confluence?

Confluence is an Atlassian collaboration and documentation platform.

Teams use it to maintain project documentation, meeting notes, test strategies, requirement details and technical knowledge.

## 7.2 Common Uses

- Project documentation.
- Test plans and test strategies.
- Meeting notes.
- Requirement documentation.
- Knowledge sharing.
- Technical documentation.

## 7.3 Practical Documentation Exercise

**Project:** Student Management — QA Test Documentation

Documentation topics explored:

- Project overview.
- Application requirements.
- Test scenarios.
- Test case documentation.
- Defect details.
- Testing activities.

**Example documentation structure:**

```text
Student Management — QA Documentation
    |
    ├── Project Overview
    ├── Functional Requirements
    ├── Test Scenarios
    ├── Test Cases
    ├── Defect Tracking
    └── Test Execution Summary
```

# 8. IntelliJ IDEA — Development Environment Setup

## 8.1 What is IntelliJ IDEA?

IntelliJ IDEA is an Integrated Development Environment (IDE) used to develop Java applications.

It provides:

- Code editor.
- Code completion.
- Debugging.
- Project management.
- Build and execution support.
- Integration with development tools.

## 8.2 Environment Used

- Programming Language: Java
- JDK: Java 17
- IDE: IntelliJ IDEA
- Operating System: Windows

## 8.3 Basic Java Concepts Practised

- Classes and Objects.
- Variables and Data Types.
- Methods.
- Constructors.
- Encapsulation.
- Conditional Statements.
- Loops.
- Collections.
- Exception-handling fundamentals.

## 8.4 Practical Java Project: Student Registration

Worked with a Java-based Student Registration application using Swing.

Key concepts:

- Creating a graphical registration form.
- Accepting user input.
- Organizing application code using classes.
- Handling button-click events.
- Checking required fields.
- Displaying a registration success message.

**Important implementation limitation:** The current basic registration exercise displays a success message after checking required fields. It does not yet implement persistent database storage, complete email validation or duplicate student ID prevention.

These are useful future enhancements and test scenarios.

# 9. Connecting Development and Testing

The Student Management exercise helped connect software development concepts with QA activities.

**Development perspective:**
- Build a registration form.
- Accept student details.
- Implement input checks.
- Display the application response.

**QA perspective:**
- Verify the registration form is displayed.
- Check valid and invalid input.
- Verify required field validation.
- Check duplicate student IDs.
- Verify successful registration behaviour.
- Report defects when actual behaviour differs from expected behaviour.

This demonstrates how development activities and testing activities complement each other.

# 10. Week 1 Learning Outcomes

After practising the Week 1 topics, I developed an understanding of:

1. SDLC phases and the role of QA.
2. Quality Assurance, SIT and UAT.
3. Agile and Waterfall methodologies.
4. Jira project structure and work item management.
5. Bug reporting, priority, status and linking.
6. JQL filters and Jira dashboards.
7. Xray test creation and test execution workflow.
8. Confluence documentation fundamentals.
9. Java development environment setup using IntelliJ IDEA.
10. Basic Java programming and its application in a Student Registration exercise.

# 11. Practical Work Summary

**Tools explored:**
- IntelliJ IDEA
- Java 17
- Jira Cloud
- Xray
- Confluence
- Git and GitHub

**Practical project used:** StudentManagement

**Evidence of practice:**
- Jira project with Epics, Stories, Tasks and Bugs.
- Saved JQL filters.
- Xray Test, Precondition, Test Set, Test Plan and Test Execution.
- Java Swing Student Registration exercise.
- Confluence QA documentation practice.

# 12. Areas for Further Practice

- Complete and improve the Confluence QA documentation.
- Add more positive and negative test cases.
- Practise complete bug retesting and defect closure.
- Implement actual data persistence and validation in the Java application.
- Improve Java OOP and exception-handling skills.
- Continue with Selenium WebDriver automation.

---

**Week 1 Summary**

This week established the foundation for understanding how software is developed, tested, documented and managed. Through Jira, Xray, Confluence and Java practice, I connected theoretical testing concepts with practical project activities and prepared for the next stage of Automation QA Engineering.
