# Cloud Intro
- the cloud = someone else's computer
- cloud benefits
    - Trade capital expense for variable expense
        - pay for what you use
    - Benefit from massive economies of scale
        - this works both ways: you can easily increase the resources provided by your cloud provider of choice (think increased use of your web service) but you can also scale down easily when the usage dies. Either way, you are still only paying for what you use
    - Stop guessing about capacity
        - due to the ease of scaling resources (both increasing and decreasing) you don't have to worry about over/under paying for hardware, due to the pay for what you use model cloud providers offer
    - Increase in speed and agility
        - your cloud provider handles things like software and hardware upgrades/fixes, and you the consumer of the cloud resources don't have to worry about it. No longer do you need to shut down your service during an upgrade: you may not even know that your cloud provider is upgrade the cloud resource
    - Eliminate overhead cost of maintaining data centers
        - your cloud provider handles things like setting up and maintaining the physical hardware in the data centers they have globally (security & updates are a big part of this)
    - Go global in minutes
        - most cloud providers have global services, so if you want to make it easy for users in other parts of the world to use your service, you can host your service in a data center close to those users, which leads to a better user experience for those customers

# Cloud Models
- Infrastructure as a Service (IaaS)
    - a self-service model for managing remote data center infrastructure (the hardware you interface with in a remote location).
        - this means a cloud provider like AWS is, fundamentally, a IaaS offering
- Platform as a Service (PaaS)
    - PaaS allows organizations to manage their IT infrastructure remotely (building apps, hosting apps, testing apps, etc.). One of the hallmarks of PaaS offerings is they provide the infrastructure and base software to get started with your work, but you must provide the means of interfacing with the software/hardware provided
        - AWS Relational Database Service is a good example of PaaS: Amazon will host the database for you, but you must provide software to integrate with the database (think connecting your app to the database or using dbeaver to view data and make manual queries to the database)
- Software as a Service (SaaS)
    - replaces the traditional on-device software (desktop applications) with licensed  software available over the web for a subscription fee.
        - software like Workday and Salesforce are examples of SaaS

# Regions & Availability Zones
Any location that AWS has data centers in is known as a **Region**. If you want to deploy a service to a specific geographic location then your best bet is to find an AWS Region that is in or close to the geographic location you want to service. Something to keep in mind is that some services provided by AWS (and cloud providers in general) are region based: some regions will not have access to all cloud offerings.

Each region will have **Availability Zones** located in the region: these are data centers located in their respective regions. Unlike Regions, which are disconnected from each other, Availability Zones are connected, meaning that services can be managed and connected to in a Region as long as there is an AZ to host the service.




