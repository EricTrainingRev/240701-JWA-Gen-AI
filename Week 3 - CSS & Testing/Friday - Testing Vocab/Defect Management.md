# Defect Management

## Feature vs Defect
Because a defect is nothing more and nothing less than deviation from expected behavior, this means that when a defect is discovered it needs to be determined whether the defect is and adverse deviation or a beneficial deviation from expected behavior. It may turn out that your team and the product owner really like this unintended behavior, which turns into the classic "it's not a bug, it's a feature!" scenario. To actually determine whether a defect is an unintended feature or not there is a Defect Lifecyle you can go through

## Defect Lifecycle
1. A defect is reported and a ticket is **opened**
2. The defect is **assigned** to someone
    - this can be a whole team or it can be an individual
3. The team/individual assesses the defect
    - the defect can't be reproduced, and so it is **rejected**
        - a "rejected" defect simply means it has been classified in such a way the testing team is confident an end user will not be able to reproduce it
    - the defect can be reproduced, but the root cause, the error that is producing the defect, can't be determined. In these scenarios the defect will typically be **reassigned**
    - the defect can be reproduced, and the product owner has determined they really like the unintended outcome, so the feature has its documentation updated to include the defect
    - the defect can be reproduced, and the underlying error that is causing the defect is discovered and the issue is **resolved**
4. one changes are made the feature that had a defect is retested to verify it works as intended, and if any new defects are discovered then new reports are created
5. assuming no new reports are made, the defect is **closed**

## Defect Reporting
Before actually progressing through the Defect Lifecycle, you need to know what information should be included in the Defect report. While there is no universal standard, there are some common categories to include in a Defect Report:
- id*
- associated Test Objective
- associated Test Object*
- release version of Test Object
- environment information
    - operating system
    - browser used
    - jdk used
    - terminal used
    - user data
    - etc.
- summary: what actually went wrong*
    - typically the same as the actual results of a Test Case execution
- steps to replicate
    - steps taken in the Test Case, and where to expect the defect to occur
- general comment
- etc.

## Severity vs Priority
Anytime a defect is discovered and a Defect Report is created, it is ideal to include two metrics alongside the defect: a severity score and a priority score. The higher the severity of the defect, the more "broken" your application is. You are indicating that there are a significant number of requirements that can not be fulfilled by the end user or system itself due to the defect. Priority is a separate metric that indicates how quickly you believe the defect should be handled. Despite the two being closely related, they are not always the same.

For example, if you are testing a login feature, which does function correctly (meaning the requirements are met) but a competitors logo is in place of your own, you could make the argument that a defect report on the matter would be marked with low severity (ability to log in is not compromised) but the priority is high (the company is giving free marketing to a competitor, and it could cause confusion about whether the user is on the correct website or not).

## Defect Logging
Anytime a defect is reported it should be logged, no matter what the resolution of the defect is. This helps a company to better track the problematic features of a service and to find where long term issues reside in the code.
