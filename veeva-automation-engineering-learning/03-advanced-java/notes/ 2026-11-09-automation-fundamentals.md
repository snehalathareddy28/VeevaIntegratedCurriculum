# Automation Testing Fundamentals

**Date:** 09 November 2026  
**Category:** Software Testing and QA Fundamentals

## 1. Introduction to Software Testing

Software testing is the process of evaluating an application to identify defects and verify that it satisfies specified requirements.

The main objective is to improve software quality and reduce the risk of failures.

## 2. What Is Test Automation?

Test automation is the process of using tools and scripts to execute predefined test cases and compare actual results with expected results.

Example:

A tester manually opens a login page, enters credentials, clicks Login, and checks the result.

An automation script performs the same steps automatically and validates the result.

## 3. Why Is Automation Required?

- Reduces repetitive manual effort.
- Improves repeatability.
- Supports regression testing.
- Enables faster execution of repeated tests.
- Supports cross-browser testing.
- Helps integrate tests into CI/CD pipelines.

## 4. Manual Testing vs Automation Testing

| Manual Testing | Automation Testing |
|---|---|
| Tester executes test steps manually | Scripts execute test steps |
| Human involvement is required | Automated execution is possible |
| Good for exploratory testing | Good for repeatable test scenarios |
| Repeated execution takes time | Repeated execution can be faster |
| Usually lower initial setup | Requires setup and maintenance |
| Human observation is important | Results depend on script assertions |

## 5. Types of Automation Testing

### Smoke Testing

Checks whether critical application functionality works.

### Regression Testing

Checks whether existing functionality continues working after application changes.

### Functional Testing

Verifies whether application features behave according to requirements.

### Data-Driven Testing

Executes the same test logic with different sets of test data.

### Cross-Browser Testing

Verifies application behavior across different browsers.

## 6. Which Test Cases Should Be Automated?

Good candidates include:

- Repetitive test cases.
- Stable application workflows.
- Frequently executed regression tests.
- Critical business functionality.
- Cross-browser scenarios.

Not every test should be automated. Exploratory testing and usability evaluation often require human judgement.

## 7. Basic Automation Testing Lifecycle

1. Analyse requirements.
2. Identify automation candidates.
3. Select automation tools.
4. Prepare the test environment.
5. Develop automation scripts.
6. Execute test cases.
7. Validate actual and expected results.
8. Report defects.
9. Maintain automation scripts.

## 8. Example: Login Test Scenario

**Application:** SauceDemo

| Step | Action | Expected Result |
|---|---|---|
| 1 | Open login page | Login page displayed |
| 2 | Enter username | Username entered |
| 3 | Enter password | Password entered |
| 4 | Click Login | User navigates to inventory |
| 5 | Verify page | Inventory page displayed |

## 9. Advantages and Limitations

**Advantages**
- Repeatability.
- Faster execution for suitable tests.
- Improved test coverage.
- Supports continuous testing.

**Limitations**
- Initial implementation cost.
- Script maintenance.
- Flaky tests.
- Requires programming and debugging skills.

## Interview Questions

**Q1. Why do we need automation testing?**

To execute repeatable tests efficiently and improve testing consistency.

**Q2. Can automation replace manual testing completely?**

No. Both approaches complement each other.

**Q3. Which test cases are good candidates for automation?**

Stable, repetitive, and frequently executed test cases.

**Q4. What is regression testing?**

Testing existing functionality after changes to ensure that previously working features have not broken.

## Learning Outcome

Understand automation testing, its benefits and limitations, and how to identify suitable test cases for automation.