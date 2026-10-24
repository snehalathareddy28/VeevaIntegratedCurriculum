# Jira Agile & Scrum — Daily Training Log

**Date:** 24 October 2026  
**Track:** Testing Foundation  
**Topic:** Jira Project Setup and Scrum Workflow

## 1. Tasks Covered

- Create a Scrum project
- Add team members
- Create an Epic and User Stories
- Assign Story Points
- Create and start a Sprint
- Create Subtasks
- Understand developer and tester responsibilities

## 2. Practical Steps in Jira

### Step 1: Create a Scrum Project
1. Log in to Jira.
2. Select **Projects → Create project** (the menu may vary).
3. Choose the **Scrum** template.
4. Enter the project name and project key.
5. Select the available project-management option.
6. Click **Create**.

### Step 2: Add Team Members
1. Open the project.
2. Go to **Project settings → People** or the project's access settings.
3. Select **Add people**.
4. Enter the team member's name or email.
5. Assign the appropriate role or access level.
6. Confirm the addition.

*Note: The available settings depend on your Jira version and permissions.*

### Step 3: Create an Epic
1. Open the project's **Backlog** or issue-creation menu.
2. Click **Create**.
3. Select **Epic** if the issue-type field is available.
4. Enter the Epic name and description.
5. Save the Epic.

**Example:** Shopping Cart Management

### Step 4: Create User Stories
1. Click **Create**.
2. Select **Story** as the issue type.
3. Enter the summary and description.
4. Add acceptance criteria.
5. Link the Story to the Epic using the Epic Link or Parent field, depending on the Jira version.
6. Save the Story.

Create these example Stories:
- Add a product to the cart.
- Update the product quantity.
- Remove a product from the cart.

### Step 5: Add Story Points
1. Open a User Story.
2. Locate the **Story Points** field, if configured.
3. Enter the team's agreed estimate, such as `3`.
4. Save the changes.

**Remember:** Story Points estimate relative effort and complexity, not fixed working hours.

### Step 6: Create and Start a Sprint
1. Open the **Backlog**.
2. Select **Create sprint**, if available.
3. Move the required Stories into the Sprint.
4. Review the team's capacity and planned work.
5. Define a Sprint Goal.
6. Click **Start sprint**.
7. Set the Sprint duration and confirm.

Only start a Sprint when the team is ready and the plan has been agreed.

### Step 7: Create Subtasks
1. Open a User Story.
2. Select the **More actions** menu or the available Subtask option.
3. Choose **Create subtask**.
4. Enter the task summary and description.
5. Assign the task if appropriate.
6. Save it.

**Example — Story: Add a product to the cart**
- Developer: Implement the add-to-cart function.
- Tester: Verify product addition and quantity updates.

### Step 8: Track Work and Bugs
1. Open the relevant issue on the board or backlog.
2. Update its status according to the team's workflow.
3. To report a defect, select **Create → Bug** if available.
4. Add the steps to reproduce, expected result, actual result, and evidence.
5. Assign or report the bug according to the team's process.
6. After the fix, retest and perform relevant regression checks.

## 3. Practical Example

| Jira item | Example |
|---|---|
| Epic | Shopping Cart Management |
| Story | Add a product to the cart |
| Story Points | 3 |
| Subtask | Verify cart quantity updates |
| Bug | Cart quantity does not update correctly |

## 4. Developer vs Tester

**Developer**
- Implements the required functionality.
- Performs appropriate