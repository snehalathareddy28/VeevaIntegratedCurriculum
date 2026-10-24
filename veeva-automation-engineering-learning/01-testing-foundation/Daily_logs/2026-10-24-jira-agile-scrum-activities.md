Daily Training Log — 2026-10-24
Topic: Agile Scrum Activities in Jira
1. What is Agile?
Agile is a software development approach in which a team builds and delivers software in small increments, gets feedback, and adapts its plan.

Example: An online shopping application can be developed in stages: login, product search, cart, and payment.
2. What is Scrum?
Scrum is an Agile framework where a team works in fixed-length periods called Sprints to deliver a useful product increment.

Scrum roles
- Product Owner: Orders and prioritizes work in the Product Backlog.
- Scrum Master: Helps the team understand and follow Scrum.
- Developers: Build and deliver the product increment. Testing specialists can be part of this team.
3. What is Jira?
Jira is a project and issue-tracking tool used to plan work, manage stories and tasks, track bugs, and monitor progress.

Example: A team uses Jira to manage the development and testing of an online shopping application.
4. Creating a Jira project
1. Log in to Jira.
2. Open Projects or the project-creation area (labels can differ by Jira version).
3. Select Create project.
4. Choose a Scrum template.
5. Enter the project name and project key.
6. Select the required project type or management style.
7. Create the project.
Example project: Online Shopping Application.
5. Adding users or people
1. Open the project.
2. Go to Project settings or People.
3. Select Add people, if available.
4. Enter the person's account or email address.
5. Assign the appropriate role or access level.
6. Confirm.
The exact steps depend on Jira permissions and whether access is managed at project or organization level.
6. Epic
An Epic is a large body of related work that can be divided into smaller stories.

Example Epic: User Authentication
- User Registration
- User Login
- User Logout
- Forgot Password
Create an Epic
1. Open the project backlog or issue-creation screen.
2. Select Create and choose Epic as the issue type.
3. Enter the Epic name and summary.
4. Save the Epic.
7. User Story
A User Story describes a feature from the user's point of view.

Common format:
As a [user], I want [feature], so that [benefit].

Example:
As a customer, I want to log in securely so that I can access my account.

Create a Story
1. Open the backlog.
2. Select Create and choose Story.
3. Enter the summary and description.
4. Save the Story.
5. Link it to the relevant Epic using the Epic Link or Parent field, depending on the Jira version.
8. Story Points
Story Points estimate the relative effort, complexity, and uncertainty of completing a story.

Illustrative examples
- Small change: 1 point
- Login feature: 3 or 5 points
- Complex payment integration: 8 points
Story points are relative estimates; they do not directly represent hours. Teams agree on their own estimation scale.

Add Story Points
1. Open the Story.
2. Find the Story Points field.
3. Enter the team's estimate.
4. Save the changes.
The field may need to be enabled or configured in some projects.
9. Sprint
A Sprint is a fixed-length period during which the Scrum Team works toward a Sprint Goal.

Example: A two-week Sprint to develop and test login and registration.

Create and start a Sprint
1. Open the Scrum backlog.
2. Select Create sprint.
3. Move selected Stories into the Sprint.
4. Agree on a Sprint Goal and check team capacity.
5. Select Start sprint.
6. Set the duration and dates.
7. Confirm the start.
The selected work then appears on the active Sprint board.
10. Subtasks
A Subtask divides an issue into smaller pieces of work.

Example Story: Customer Login
- Developer: Build the login page.
- Developer: Implement login functionality.
- Tester: Prepare login test cases.
- Tester: Execute login tests.
Create a subtask
1. Open the parent Story.
2. Select Create subtask or Add subtask.
3. Enter its summary and description.
4. Assign it to a team member.
5. Save it.
Available options depend on project configuration and permissions.
11. Sprint life cycle
1. Sprint Planning: Agree on the Sprint Goal and select work.
2. Sprint Execution: Developers and testers collaborate on Stories.
3. Daily Scrum: Inspect progress toward the Sprint Goal and adapt the plan.
4. Testing and defect fixing: Testers execute tests and report defects; developers fix them; testers retest and perform regression testing as needed.
5. Sprint Review: Inspect the completed Increment with stakeholders.
6. Sprint Retrospective: Discuss what went well and how the team can improve.
12. Developer and tester responsibilities
Developer
- Understand requirements and acceptance criteria.
- Implement and review code.
- Collaborate with testers.
- Fix reported defects.
Tester
- Understand requirements and acceptance criteria.
- Prepare test scenarios and test cases.
- Execute tests and record results.
- Report defects in Jira.
- Retest fixes and perform regression testing.
Important: Developers and testers work together throughout the Sprint. Testing does not begin only after the Sprint is finished.
13. Important Jira terms
- Project: Workspace for organizing related work.
- Epic: Large body of related work.
- Story: User-focused feature or requirement.
- Subtask: Smaller piece of work under an issue.
- Story Points: Relative effort estimate.
- Product Backlog: Ordered list of product work.
- Sprint Backlog: Sprint Goal, selected Product Backlog items, and the plan to deliver them.
- Sprint Board: Visual view of work and its status.
- Bug: An issue representing unexpected or incorrect behavior.
Quick revision
Project → Epic → Stories → Story Points → Sprint Planning → Sprint Execution → Testing and Defect Fixing → Sprint Review → Sprint Retrospective

Remember: the team follows its agreed Definition of Done to determine whether work is complete.