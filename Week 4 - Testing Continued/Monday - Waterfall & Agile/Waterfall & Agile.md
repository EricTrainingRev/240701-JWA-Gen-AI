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