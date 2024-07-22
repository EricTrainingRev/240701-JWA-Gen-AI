# The Old Way: Waterfall
When you are working on a project, there is a key question you need an answer to: can you go back? This may seem like a silly idea, but there are some projects/work that do not allow (or make it very difficult) to "go back" over previous work. Consider projects such as building a bridge, performing brain surgery, or some other difficult and costly endeavor: these projects don't allow for, or are extremely expensive, to "go back" over mistakes that are made, especially the farther along you a in the project/work.

In scenarios where you need to get it right the first time, Waterfall development is appropriate: this is a work philosophy that involves high levels of documentation and contracts, only ever moves forward, and allows for a high level of planning and streamlined execution. 

Pros:
- the end goal of a project is usually very clear due to the high levels of documentation necessary for Waterfall methodologies to work
- while doing your work it is very easy to know what the "next step" is when you finish a task
- it makes it easy to coordinate and reduce confusion between teams
- typically does not require in-depth knowledge of "ceremonies"

Cons:
- because of the heavy reliance on contracts, if a client realizes half through a project they actually want something different, in almost every case they are going to be stuck due to the contracts signed
- a staple of Waterfall projects is a lack of "backwards" movement: if a problem is discovered after something is built or the next "stage" of project work has begun, you can't go back and fix things, you have to create or find a workaround
- in software work in particular, debugging is a difficult process due to many defects not being able to be discovered until the project being worked on is put together

## Waterfall Implementation : V-Model
The V model is an attempt to alleviate the difficulties of testing and debugging an application designed with Waterfall in mind. Instead of having a system where development happens and then testing is done as a separate incremental step, testing and development happen asynchronously in tandem each step of the project. This changes the visual of the project from a single waterfall like visual into more of a V shape: on one side you can visualize the development work and steps that need to be taken, and on the other are all the associated tests that need to be created and executed at each stage of development work. Ideally, the two work together to determine when the next step of development can start.

# The Current Way: Agile
Whereas Waterfall is a stiff and contract heavy, do it right the first time way of doing work, Agile is a more suitable way of approaching software work. There are four main "tenants" of Agile:
- individuals and interactions over process and tools
- working software over comprehensive documentation
- customer collaboration over contract negotiation
- responding to change over a plan

## Common Features of Agile
- Dynamic Project Scopes
- Iterative Development Cycles
- Copious use of Automation Tools

## Agile Terminology
- Epic: a term used to organize functionality 
- User Story: a narrow, particular aspect or feature of an Epic
- Story Points: arbitrary value used to assign "difficulty" or "effort" needed to complete work on a User Story
    - this is "arbitrary" because you as a team will have to adjust the way you assign Story Points to make the assignment actually meaningful and useful for you as a team
- Velocity: the number of Story points associated with completed User Story work during a Sprint
- Sprint: a development cycle, typically going to be a few weeks in length (2-3 weeks)

## Agile Implementation: Scrum
Scrum is one of many ways to implement Agile development, and it will be the focus of how we approach Agile work in training. When you are part of a Scrum there are a few key members of the team or individuals you will interact with:
- **Development Team**: this is the team doing the work (typically small in number)
    - there may be multiple teams working together implementing Scrum: for instance, you may have a development team and a testing team that are working on the same project, same Epics, User Stories, etc., but focusing on different aspects of the work
- **Product Owner**: an individual or group that represents the owners of the product your team is working on
    - think of this person or group as the point of contact for whoever or whatever you are building for
- **Stakeholder**: The entity you are working on a product for
- **Scrum master**: this is an individual leading a Scrum team. This individual is in charge of facilitating conversation, questions, and updates from the Development Team to the Stakeholder. This can be a high level developer, but it is possible that the Scrum Master is just meant to be the communicator between the dev team and the stakeholder
- **Team members** (Scrumlings): members of the Scrum team: depending on how the team/s are organized you may have a mix of development focused, testing focused, or mixed skilled individuals

## Scrum Terms
Scrum is accomplished in three overarching phases:
1. Initial Phase
2. Sprint Cycles
3. Closure Phase

In the initial phase is where planning, organizing teams, determining initial Epics, User Stories, Story Points, and Sprint durations happens. Much of this planning will happen alongside a Product Owner

Sprint Cycles is where the development/testing work is executed after planning. During this phase, based on conversation between the Product Owner/s and Scrum Master/s the scope of the project and other features can be adjusted as needed in order to complete the work the Stakeholders actually want accomplished

Closure Phase is where any final documentation is written up, project work is officially closed, and the team is assigned to a new project. This is where ownership of the project is officially handed from the dev team and Scrum Master to the Product Owner and Stakeholders

There are some key terms used in a Sprint to facilitate conversations between the different entities of the Scrum:
- Backlog: this a  term used to describe the collection of work (dev, testing, logistics, etc) the Development Team is expected to accomplish for the Stakeholders
    - Project Backlog: term used to describe the work that needs to be accomplished in future Sprints
    - Sprint Backlog: term used to describe the work (typically a collection of Epics and/or User Stories) that you plan on completing work on during the current Sprint
- Scrum Ceremonies
    - User Story Planning: this ceremony usually happens during the Initial Phase, and is where Epics and User Stories are organized, Story Points are assigned, and Velocity goals are defined
        - This ceremony can also occur in-between Sprints. This will happen if there is a change needed due to communication with the Product Owner
    - The Scrum (Daily Standup): a meeting to get the dev team and any other associated teams on the same page:
        - giving general updates
        - talking about work that needs to be accomplished for the day
        - discussing blockers
    - Sprint Retrospective
        - happens at the end of every Sprint, the team comes together to discuss how the Sprint went:
            - what went well
            - what can be improved upon
            - note any work that was not finished and needs to be accomplished in the next Sprint
                - may trigger a need for another User Story Planning session
            - Start planning next Sprint based off the Backlog