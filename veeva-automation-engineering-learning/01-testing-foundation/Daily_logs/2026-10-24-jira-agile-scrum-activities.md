Jira Agile & Scrum Workflow
Engineering Learning Log · 24 October 2026
Learning track: Testing Foundation
Focus: Agile delivery, Scrum planning, and quality assurance in Jira

1. Learning Objective
Understand how a Scrum team uses Jira to organize work from a high-level business requirement through user stories, sprint planning, development, testing, and review.

By the end of this session, I should be able to explain the purpose of Epics, User Stories, Story Points, Sprints, Subtasks, and the main Scrum events—and describe how a tester contributes throughout the sprint.
2. Why This Matters in Software Engineering
Software teams need a shared way to understand requirements, agree on priorities, divide work, communicate progress, and identify defects. Agile provides an iterative approach to delivery, Scrum provides a framework for working in time-boxed Sprints, and Jira helps teams record and track that work.

Key distinction
- Agile is a set of values and principles for adaptive software development.
- Scrum is a framework for delivering work iteratively through Sprints.
- Jira is a work-management tool that teams can configure to support Scrum or other workflows.
3. The Jira Work Hierarchy
Work item	Purpose	Example: Online Shopping
Epic	Groups related work toward a larger outcome	Shopping Cart Experience
User Story	Describes a user need or capability	As a customer, I want to add a product to my cart so I can buy it later.
Subtask	Breaks a story into smaller pieces of work	Implement add-to-cart action; test quantity updates
Bug / Defect	Records behavior that does not meet expectations	Cart total does not update after quantity changes


Note: Exact issue types and hierarchy can vary by Jira configuration. In many Jira setups, subtasks belong to a standard issue such as a Story, while Epics group related Stories.

4. End-to-End Scrum Workflow in Jira
Business goal
    ↓
Create a Jira Scrum project
    ↓
Define an Epic
    ↓
Create User Stories and acceptance criteria
    ↓
Estimate effort with Story Points
    ↓
Prioritize and select work during Sprint Planning
    ↓
Create and start the Sprint
    ↓
Develop, test, review defects, and collaborate daily
    ↓
Sprint Review
    ↓
Sprint Retrospective
    ↓
Apply feedback to the next Sprint
Step 1 — Create a Scrum Project
1. Open Jira and choose the option to create a project.
2. Select the Scrum template if it matches the team's workflow.
3. Enter a project name and project key.
4. Choose the available project-management style and create the project.
Why it matters: A project provides a shared place for the team's backlog, board, issues, and progress. Menu names and available options depend on the Jira version and permissions.
Step 2 — Add Project Members
1. Open the project's people or access settings.
2. Add the appropriate team members or groups, if permitted.
3. Confirm that each person has the access needed for their role.
Quality consideration: Access should follow the team's permissions policy. Do not grant broader access than someone needs.
Step 3 — Create an Epic
Create an Epic to represent a larger outcome that can be delivered through several related stories.

Example Epic: Shopping Cart Experience

Possible stories:
- Add a product to the cart.
- Change the quantity of a cart item.
- Remove a product from the cart.
- Display the updated cart total.
Good practice: Write the Epic around an outcome, not merely a list of unrelated technical tasks.
Step 4 — Create User Stories and Acceptance Criteria
A useful user-story format is:
As a [type of user], I want [capability], so that [benefit].

Example

As a customer, I want to update a product's quantity in my cart so that I can purchase the correct amount.

Example acceptance criteria
- Given a product is in the cart, when the customer increases its quantity, then the displayed quantity updates.
- The cart subtotal reflects the updated quantity and product price.
- The system prevents quantities that violate the application's defined rules.
- The updated total remains correct after another cart item is changed.
Acceptance criteria should be clear enough for developers and testers to understand what successful behavior means.
Step 5 — Estimate with Story Points
Story Points express a team's relative estimate of effort, complexity, and uncertainty. They are not a guaranteed number of hours or days.

A team might use a scale such as 1, 2, 3, 5, 8, and 13. The team should agree on how it uses its scale.

When estimating, consider:
- Complexity of the change
- Amount of work involved
- Unknowns and technical risk
- Dependencies on other work
Important: A 5-point story is not automatically five hours. Story Points are most useful when applied consistently by the team.
Step 6 — Plan and Start a Sprint
During Sprint Planning, the team discusses the Sprint Goal, selects suitable backlog items, and agrees on a realistic plan.
1. Review prioritized backlog items.
2. Clarify requirements and acceptance criteria.
3. Discuss dependencies and capacity.
4. Estimate or confirm estimates according to the team's process.
5. Add selected work to the Sprint.
6. Agree on a Sprint Goal and start the Sprint when ready.
A Sprint is a fixed-length period of work. Scrum Sprints are one month or less; many teams use a two-week Sprint.
Step 7 — Break Work into Subtasks
Subtasks can make ownership and progress clearer when a story needs multiple activities.

Example story: Update cart item quantity
Example subtask	Possible owner
Implement quantity update behavior	Developer
Validate quantity and total calculations	Developer / team
Prepare positive and negative test scenarios	Tester
Execute tests and record defects	Tester
Retest fixes and run relevant regression tests	Tester / team


These are example assignments, not mandatory role boundaries. Developers and testers should collaborate throughout delivery.
Step 8 — Track Progress and Handle Defects
During the Sprint, team members update issues according to the team's workflow and discuss blockers during the Daily Scrum.

A defect report should ideally include:
- Clear title and observed behavior
- Steps to reproduce
- Expected result and actual result
- Test data and environment
- Relevant screenshots, logs, or evidence
- Severity or priority according to the team's process
After a fix is available, the tester verifies the original failure and performs appropriate regression testing.
5. Scrum Events and Their Purpose
Event	Purpose
Sprint Planning	Agree on why the Sprint is valuable and what work is feasible
Daily Scrum	Inspect progress toward the Sprint Goal and adapt the plan
Sprint Review	Inspect the increment with stakeholders and discuss feedback
Sprint Retrospective	Identify improvements to team collaboration and quality
Sprint	The time-box that contains the work and Scrum events


Remember: Testing is not a final phase that begins only after development ends. Quality is a shared responsibility throughout the Sprint.
6. Developer and Tester Collaboration
Developer contribution
- Understand requirements and acceptance criteria.
- Implement and review code.
- Perform suitable unit or component testing.
- Fix defects and collaborate on technical risks.
Tester contribution
- Review stories and acceptance criteria early.
- Identify gaps, ambiguities, and risks.
- Design positive, negative, boundary, and regression scenarios as appropriate.
- Execute tests, record reproducible defects, and verify fixes.
- Communicate quality risks and remaining uncertainty.
Shared responsibility: The whole team works toward a usable increment that meets its Definition of Done.
7. Practical Quality Checklist
Before considering a story complete, check the team's Definition of Done and ask:
- [ ] Are the acceptance criteria clear and satisfied?
- [ ] Have relevant positive and negative scenarios been considered?
- [ ] Have important boundary conditions been tested where applicable?
- [ ] Are defects recorded with enough information to reproduce them?
- [ ] Have fixes been retested and relevant regression checks completed?
- [ ] Is the required evidence or documentation available?
- [ ] Does the work satisfy the team's Definition of Done?
This is a learning checklist, not a replacement for the team's actual Definition of Done or test strategy.
8. Key Terms for Interview Revision
Term	Concise explanation
Product Backlog	Ordered list of work that may improve the product
Sprint Backlog	Sprint Goal, selected backlog items, and the team's plan for delivering them
Epic	Larger body of related work
User Story	User-focused description of a need
Acceptance Criteria	Conditions that define acceptable behavior for a story
Story Points	Relative estimate of effort, complexity, and uncertainty
Sprint Goal	The single objective that gives the Sprint focus
Definition of Done	Shared quality criteria for an increment to be considered complete
Regression Testing	Checking that a change has not adversely affected existing behavior
Retrospective	Event for identifying ways to improve how the team works


9. Interview-Ready Explanation
Question: How does Jira support Agile testing in Scrum?

Jira helps a Scrum team organize requirements as Epics and Stories, record acceptance criteria, estimate and prioritize work, and plan it into Sprints. During the Sprint, developers and testers collaborate, update issue status, record defects, and verify fixes. The team reviews the increment and reflects on improvements at the end of the Sprint. Jira supports visibility and coordination, while the team's process and Definition of Done guide how quality is achieved.

Question: What is the difference between Story Points and hours?

Story Points are relative estimates that account for effort, complexity, and uncertainty. They do not directly convert to hours. Teams use them to compare work items and improve planning consistency.

Question: When should testers be involved?

Testers should be involved early—while requirements and acceptance criteria are being discussed—and continue through test design, execution, defect reporting, retesting, and regression testing. This helps identify ambiguity and risk before the end of the Sprint.
10. Learning Reflection
Use this section to record only what was actually completed during training.
- Concepts covered: Agile, Scrum workflow, Jira work items, Story Points, Sprint planning, and tester collaboration.
- Hands-on tasks completed: Add the Jira actions personally performed during the session.
- Challenge or question: Record any step that was unclear or blocked by permissions.
- Next practice goal: Create a sample Epic and Story, write acceptance criteria, and prepare test scenarios for the story.
11. Quick Revision
- Agile emphasizes adaptation and delivering value.
- Scrum organizes work into fixed-length Sprints.
- Jira helps teams plan and track work; it does not replace communication or engineering judgment.
- Epics group related Stories; Stories describe user needs; Subtasks divide work.
- Acceptance criteria make expected behavior testable.
- Story Points are relative estimates, not hours.
- Developers and testers collaborate throughout the Sprint.
- The Definition of Done sets the shared criteria for completion.
Documentation standard: Keep examples clearly labeled, record hands-on work honestly, and update this log when the concepts are practiced in Jira.