# Testing
According to the ANSI/IEEE 1059 standard, Software testing is a process of analyzing a software item to detect the differences between existing and required conditions (i.e. defects/errors/bugs) and to evaluate the features of the software item. In other words, testing is the process of checking a system and/or its components against specification to determine whether or not the system meets those requirements.

Software testing can be done either manually (by a human using the system) or it can be automated by writing tests with code. Usually when we discuss software testing we are referring to the latter. There are many existing software libraries and frameworks in many languages that can assist with testing. Writing tests is a crucial way to ensure the quality and effectiveness of a piece of software.

Testing should not be...
* Optional
* An afterthought
* A chore
* Time-consuming
* Strictly about code coverage

When creating and executing tests, you want to make sure that you:
* Clarify and unambiguously state the requirements of the system
* Ensure software meets the stakeholders' expectations, and helps achieve business objectives
* Can easily identify areas that do not meet requirements
* Quickly and easily make changes to your application and tests if needed
* Assure product quality

### Software Quality
A term heard often when discussing testing is Quality Assurance. Though there are similarities to testing and quality assurance, there are some key differences to keep in mind. For starters, let's examine what quality means. Quality can describe an application's conformance with:
* Functional aspects and Structure aspects
* Both focused on finally meeting stakeholders' expectations

Quality Assurance therefore refers to the maintenance of a desired level of quality in a service or product, especially by means of attention to every stage of the process of delivery or production. 
Quality assurance also:
* Ensures that the correct process is followed to develop software and focuses on avoiding defects from getting introduced in software. 
* Should be maintained throughout each step of the development process, unlike testing which is often reserved for finding issues after the creation of a product. 
* Emphasizes the usage of standard software development processes and practices to guarantee quality.
* Increases chances of developing a final product that is bug-free and meets stakeholders' requirements

In order to ensure quality is maintained, Quality Control is utilized. 
Quality Control is...
* A system of maintaining standards in manufactured products by testing a sample of the output against the specification.
* Checks if the product/software that has been developed works as per requirements specifications.
* Focuses on finding defects in the product/software.

An integral part of this quality control process is the [Software Testing Life Cycle](#testing-life-cycle). Thus, we write tests as part of a quality control mechanism to keep software quality high.

## Testing Pyramid
When determining costs for tests, it is useful to keep the "Testing Pyramid" in mind. This "Test Pyramid" is a visual representation of the cost vs abundance of tests based on certain "levels" of testing. More tests exist at the lower level of the pyramid than at the top because they exist at a lower level of abstraction (unit tests), whereas fewer exist at the top and focus on a higher layer of abstraction (system tests, UI tests, UAT).

* Unit Testing
  * Most micro-level of testing
  * Test each component without dependencies
  * Usually requires data mocking
  * Unit testing tools include Junit and TestNg
* Integration Testing
  * Test components with dependencies
  * Check that components work with one another correctly
  * Logically related modules are tested as a group
  * Integration testing tools include selenium and protractor
* System Testing
  * Test the entire application as a whole
  * Ensure the entire application works without errors
* User Acceptance Testing (UAT)
  * Test all requirements/user stories are met
  * Simulate an end-user to guarantee that users can actually perform all the tasks the request and are supposed to
  * Generally UAT is handled by a physical user
  * Two General forms of UAT, Alpha and Beta
    * Alpha Testing
      * First round of UAT (normally this is in-house builds and teams)
    * Beta Testing
      * Testing done "out-of-house"

## Testing Principles
- Testing Reveals Defects, Not their absence
    - 0 defects discovered does not mean there are no defects in the tested software
- Exhaustive Testing is not possible
    - testing should be focused on critical features/requirements first
- Test early
    - the sooner testing is started the more robust and meaningful the testing will be
- Defects Cluster
    - any feature/requirement with one or more defects warrants extra testing
    - defects tend to cascade, especially if the defect is at the start of any data transformation or if other features require the data involved in the defect
- Pesticide Paradox
    - your tests will eventually exhaust all defects they can find: when this happens it is worth considering additional tests to accommodate the addition of new features or requirements
- Test Context Matters
    - similar to exhaustive testing not being possible, the context of what you are testing should determine how you perform your testing
- Absence of Error Fallacy
    - just because there are no defects does not mean your application is good