# Day 1: SDLC Models — Waterfall and Agile

## Concept 1: Waterfall Model

### What I Learned

The Waterfall model is a traditional Software Development Life Cycle (SDLC) model in which development follows a sequential process. Each phase is generally completed before moving to the next phase.

### Waterfall Workflow

Customer → Requirements Gathering → CRS (Customer Requirements Specification) → Business Analyst → Architect → Developer → Test Engineer → Deployment (DevOps Engineer)

### Roles and Responsibilities

1. **Customer:** Explains the business needs and expectations of the software.

2. **CRS Document:** Contains the requirements gathered from the customer and serves as a reference for the development team.

3. **Business Analyst (BA):** Analyzes the requirements, identifies ambiguities, and clarifies doubts to ensure that the requirements are understood correctly.

4. **Architect:** Designs the overall system blueprint based on the analyzed requirements.

5. **Developer:** Implements the software by writing code according to the approved design.

6. **Test Engineer:** Tests the developed application against the specified requirements, identifies defects, and reports them to the development team.

7. **DevOps Engineer:** Supports the release and deployment of the application after the required testing and approvals are completed.

### What Happens When a Bug Is Found?

When a test engineer identifies a bug, it is reported to the development team for investigation and correction. After the developer fixes the defect, the tester performs **retesting** to verify the fix. Regression testing is also performed to check whether existing functionality is affected by the changes.

If the defect is not fixed, it is sent back for further investigation and correction.

### Drawbacks of the Waterfall Model

- **Less flexibility:** Changes in requirements can be difficult to accommodate once development has progressed.
- **Late defect identification:** Major issues may be discovered during the testing phase, increasing the cost of fixing them.
- **Delayed customer feedback:** Customers may not see a working product until later in the development process.
- **Limited early delivery:** Working software is generally delivered after several development phases are completed.
- **Costly changes:** Changes made at later stages may require updates to requirements, design, code, and test cases.

### Real-World Example

Consider an online shopping application developed using the Waterfall model. The requirements and design are finalized before coding begins. Developers implement login, product search, cart, and payment functionality. During testing, the customer requests a major change to the checkout process.

Since development has already progressed, the team may need to modify the design and code and perform testing again. This demonstrates why the Waterfall model can be challenging when requirements change frequently.

---

## Concept 2: Agile Model

### What I Learned

The Agile model is an iterative and incremental approach to software development. The project is divided into smaller development cycles, allowing the team to build, test, review, and improve the software continuously.

Instead of waiting until the entire application is completed, the team delivers smaller pieces of functionality and collects feedback throughout development.

### Agile Workflow

Planning → Design → Development → Testing → Review and Feedback → Next Iteration

### Real-World Example

Consider the same online shopping application developed using Agile. The team may first develop and test the login functionality, then move on to product search, shopping cart, and payment functionality in subsequent iterations.

After each iteration, the team reviews the completed work, gathers feedback, and uses it to improve future development.

### Key Understanding

The main difference between Waterfall and Agile is the way development is organized. Waterfall follows a largely sequential approach, whereas Agile develops software through repeated iterations and encourages continuous feedback and adaptation.

