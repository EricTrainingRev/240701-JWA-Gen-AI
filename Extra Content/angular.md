# Angular
### Angular Introduction
Angular is a popular front end framework used for web development. What nowadays is called "Angular" is actually a reference to any implementation of Angular that comes after Angular 1, the first version of Angular (anything after version 1.x). The first implementation of Angular is called AngularJS. This is because the first version of Angular used Javascript, whereas Angular 2 (Angular) makes use of typescript. 

As a  framework, Angular offers many different features to streamline and enhance the development process:
- Angular is an opinionated framework
- Angular uses typescript
- Angular is open source
- helps create dynamic & single-page applications
- based on components
    - several components together form a tree structure
- Angular is shorthand for Angular 2+
    - first version of angualr is known as AngularJS
- supports various platforms
- Uses consistent design patterns
- provides the tools to get started building right away
- components are decoupled
- easy to test
### Single Page Application
SPAs are web applications that run off a single web page: Gmail, Facebook, and Twitter are good examples of SPAs. What this means is that you stay on the single web page to interact with the application: you never have to refresh or load up a new webpage to interact with the application, which significantly increases the speed of the website. It can also make use of caching, so if you have a poor connection, or need to do work offline, you can still interact with the cached data, and then synchronize your data with the web server when you have a connection again. This type of setup is also user friendly, especially for mobile phones: the fact that you don't have to constantly reload pages makes for a smoother experience.

There are drawback though: a SPA has a much longer INITIAL startup than a traditional web application, due to the fact that the application must load all the data it needs before you start to interact with the application. SPAs also do not work well with search optimization, and they can be vulnerable to Cross-site scripting attacks.
### Package.json
ng init will generate a package.json in the root folder of your angular application: this json contains project information, such as the project name, its description, the entry point for the application ("main"), and more. This json also contains the dependencies and Devdependencies: dependencies are necessary for the application to work, whereas devDependencies are necessary for building the application.
### Typescript
Typescript is a superset of Javascript: anything you can do in in Javascript you can do in Typescript. The key addition of Typescript is its type system: it can enforce type saftey for your code. Another key benefit of Typescript is how configurable it is: in the tsconfig.json file you can turn Typescript features on and off by setting their boolean value (for instance, setting strictTyping to false will turn off the type security Typescript normally provides)

### Variable Types
There are a few main types you can work with in Typescript:
- boolean
- number
- string
- null
    - don't declare this type alone
- undefined
    - don't declare this type alone
- any
    - useful if you are working with complex objects
- Array<Type>
    - can also use [] too indicate an array: number[]
    - arrays are mutable in Typescript
    - can make immutable tuples by declaring types in []: [string, number]
- Enum
    - this is a declared set of named constants, either string or numeric
    - enum Color {Red, Green, Blue}
### Classes / Objects
Typescript makes use of classes and objects: the objects can have state and behavior, and the new keyword is used to instantiate objects.
```typescript
class Greeting {

    //fields
    name: string;

    //constructor
    constructor(name: string) {
        this.name = name;
    }

    //methods
    greet() : string {
        return "Hello, " + this.name;
    }
}
//creating an object
let greeter = new Greeting("James");
greeter.greet(); //returns "Hello, James"
```
Typescript classes do support inheritance, but not multiple inheritance
```Typescript
class Animal {
    move(distanceInMeters: number = 0) {
        console.log(`Animal moved ${distanceInMeters}m.`);
    }
}

class Dog extends Animal {
    // anything you need to pass into the parent constructor goes into super() inside the constructor
    bark() {
        console.log('Woof! Woof!');
    }
}
const dog = new Dog();
dog.bark();  // returns 'Woof! Woof!'
dog.move(10); // returns 'Animal moved 10m.'

```
### Access Modifiers
There are four access modifiers in Typescript:
- public : accessible anywhere
- private: accessible only in the class
    - add a "_" before the variable name of a private field: _myPrivateField
- protected: accessible only in the class and any inheriting classes
- readonly: accessible everywhere but immutable: must be initialized
### Decorators
Typescript, and expecially Angular, makes uses of Decorators to adjust classes, methods, accessors, properties, and parameters. You can adjust the tsconfig json to allow your own "experimental" decorators, but Angular makes use of some built in decorators you should be aware of:
#### NgModule
- @NgModule
    - this decorator provides the metadata necessary for Angular to make use of your modules. NgModule takes metadata and describes how to compile a component's template and how to create an injector at runtime. It identifies the module's own components, directives, and pipes and makes them public through the export property which can be used by external components.
- **declarations**: contains a list of components, directives, and pipes, which belong to this module.
- **imports**: contains a list of modules which are used by the component templates in this module reference. For example, we import BrowserModule to have browser-specific services such as DOM rendering, sanitization, and location.
- **providers**: the list of service providers that the application needs. You need to manually add these to the providers list
- **bootstrap**: contains the root component of the application
#### Component (Component Directive)
- @Component
    - this decorator provides the meta-data necessary for Angular to make use of your component
        - selector: this is the name of the tag you use to render the content of your component
        - templateUrl: this can either be the path to the component.html file, or you can directly define the elements inline via the templateURL itself
        - styleUrls: this is where you put the relative path to the styling guide for the component. Without this you must provide the styling information internally, whether directly in the templateUrl or in the component.html file you link to

Components have various lifecycle hooks you can use to manipulate the dom, these are called automatically by your Angular application at the appropriate time:
- **constructor**(): The constructor of the component class gets executed first, before the execution of any other lifecycle hook events. If we need to inject any dependencies into the component, then the constructor is the best place to do so.
- **ngOnChanges**(): Called whenever the input properties of the component change. It returns a SimpleChanges object which holds any current and previous property values.
- **ngOnInit**():Called once to initialize the component and set the input properties. It initializes the component after Angular first displays the data-bound properties.
- **ngDoCheck**(): Called during all change-detection runs that Angular can't detect on its own. Also called immediately after the ngOnChanges() method.
- **ngAfterContentInit**(): Invoked once after Angular performs any content projection into the component’s view.
- **ngAfterContentChecked**(): Invoked after each time Angular checks for content projected into the component. It's called after ngAfterContentInit() and every subsequent ngDoCheck().
- **ngAfterViewInit**(): Invoked after Angular initializes the component's views and its child views.
- **ngAfterViewChecked**(): Invoked after each time Angular checks for the content projected into the component. a It called after ngAfterViewInit() and every subsequent ngAfterContentChecked().
- **ngOnDestroy**(): Invoked before Angular destroys the directive or component.
### Directives
We have already looked at Component Directives (shorthanded to Components) but there are two other directives to be aware of: Structural and Attribute directives. Directives are Angular's way of manipulating the DOM: components are the most verbose means of doing so: they alter the details of how the components should be processed, instantiated, and used at runtime. Structural and Attribute directives allow for dynamic interactions with the DOM
### Structural Directives
Structural Directives are how you should be dynamically manipulating the DOM: you should never need to manually interact with it. There are three built in structural directives: *ngIf, *ngFor, and *ngSwitch
#### *ngIf
You can add *ngIf to your elements to control whether they are added to the DOM or not via a boolean statement. A true value will result in the element being rendered on the dom, a false value will result in the element not being rendered (or a part of) the dom. This is not hiding the element: it is removing it entirely from the dom
```html
<p *ngIf="true">
  Expression is true, this paragraph is in DOM.
</p>
<p *ngIf="false">
  Expression is false, this paragraph is not in DOM.
</p>
```
you can also use else blocks by delcaring them in the logical statement. You would use an ng-template element to represent the else block
```html
<div *ngIf="5>10; else elseBlock">  
5 is greater than 10....
</div>  
<ng-template #elseBlock>  
10 is greater than 5... 
</ng-template> 
```
#### *ngFor
you can add *ngFor to your elements to dynamically display content from an iterable data type. For instance, if iterating through an array, you could use *ngFor to iterate through the contents and add them to an ordered or unordered element
```html
<!-- assume there is an array with the numbers 1-5 in it for this example -->
<ul *ngFor="let number of numbers">
    <li>{{number}}</li>
</ul>
```
#### ngSwitch
this structural directive makes use of three different directives: ngSwitch, *ngSwitchCase, and *ngSwitchDefault. You use them like you would a regular switch case: ngSwitch determines what is being checked, and then any switch cases that match are rendered. If none match then the switch default is created and rendered
```html
<!-- container and inner element are not real, just placeholders -->
<container_element [ngSwitch]="switch_expression">  
    <inner_element *ngSwitchCase="match-1">...</inner_element>  
    <inner_element *ngSwitchCase="match-2">...</inner_element>  
    <inner_element *ngSwitchCase="match-3">...</inner_element>  
    <inner_element *ngSwitchDefault>...</inner_element>  
</container_element>
```
### Attribute Directives
Attribute directives are Angular's way of affecting the look and behavior of DOM elements: ngClass and ngStyle are the built in way of doing this
#### ngClass
ngClass lets you assign CSS classes to an element in three different ways: declaring them via string literals, declaring them inside an array, or via an object where the class is the key and a boolean statement determines whether they are applied or not
```html
<style>
.red { 
    background-color: red;
}
.size20 {
    font-size: 20px; 
    font-style: italic;
}
</style>
<h3 [ngClass]="'red size20'"> background will be red, text size will be 20px </h3>
<div [ngClass]="['red','size20']"> Red Background, Text with Size 20px  </div>
<div [ngClass]="{'red':false,'size20':true}">Text with Size 20px</div>
```
#### ngStyle
ngStyle lets you do inline styling based upon an expression.
```html
<some-element [ngStyle]="objExp">...</some-element>
```
you can create your own custom attributes using the ng generate directive command
```cli
ng g d <name of directive>
```
This will create a directive ts file and test file, the ts file will look somehting like this (assume name of directive was text)
```typescript
import { Directive} from '@angular/core';

@Directive({
  selector: '[appText]'
})
export class TextDirective {
	//You can add custom styling of DOM Elements here....
    constructor() {
    
    }
}
```
Once you have set up your directive you apply it as an attribute to your element
```html
<p appText> Text inside....</p>
```
### Data Binding
There are two ways of "binding" data in Angular (binding is the transfering of information between components and the DOM): one way and two way
#### One Way Data Binding
- **String Interpolation**
    - Angular uses {{this}} format to perform string interporlation. You can place a field, object key, list index, etc. in between the double curly brackets and the DOM will display the value you provided
```typescript
export class Component{
    name: string = "John";
}
```
```html
<p>Hello {{name}}</p>
```
- **Property Binding**
    - property binding is where you add [] around the attribute you are working with, and instead of providing a hard-coded value for the attribute you provide a value via the component instead
    - for a string value you can use either string interpolation or property binding, for a non-string value of an attribute you should use property binding
```typescript
export class Component{
    link: string = "link-to-some-image-url";
}
```
```html
<!-- string interpolaiton would work here as well, just remove the [] -->
<img [src]="link"> 
```
- **Event Binding**
    - Event binding is the process of linking an event on the DOM (click, mouse over, etc) to a function in the component. The transfer of information is one way from the DOM to the component
```html
<button (click)="someFunction()">Click me for some function</button>
```
#### Two Way Data Binding
The problem with one way data binding is the singular flow of information: to allow the DOM and component to communicate with each other you can use two way data binding, which makes use of both event and property binding [()]
#### ngModal
Angular has a built in means of two way data binding: ngModal, which is tied to the FormsModule. To make use of this means of binding you must import the FormsModule into the main module of your Angular application. Note that you will both declare the import at the top of the module, and inside the imports array.
```typescript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms'; // here is the import
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule // here it is added to the imports array
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```
Once you have imported the FormsModule you can use ngModel to do two way binding: any changes made either to the DOM or to the component will affect the value associated with the binding
```html
<!-- this assumes there is a field called name in the component ts file -->
<span>Enter your name<span>
<input type="text" [(ngModel)]="name">
<p>Hello {{name}}!</p>
```
### Pipes
#### Built In Pipes
Pipes are Angular's way of transforming content on the DOM: they provide a consistent and fluid means of transforming content on the DOM. You do this by adding the pipe character | and then the name of the pipe. If you want to adjust the pipe you add a colon : and then the adjusting paramaters. Even if you are hard coding the value you still want to use the string interpolation format.
```html
<p>{{someString | uppercase}}</p>
<p>{{3.14 | number:3.4-6}}</p> <!-- output: 003.1400 3 is minimum number places, 4-6 is minimum to maximum decimal places-->
```
There are many built in pipes Angular provides:
- date
- number
- currency
- percent
- slice
- lowercase
- uppercase
- titlecase
- json
- async
#### Custom Pipes
Sometimes you will need to transform data in ways that Angular provides no default means for: in these instances you can create a custom pipe via the command ng g p NewPipeName. This will create a pipe ts file and a testing file, and it will automatically update the root app.module file with the dependency information for the pipe (import will be declared at the top of the file and added to the declaration array).
```cli
ng g p WordCount
```
```typescript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
// Custom Pipe imported here by Angular CLI
import { WordcountPipe } from './wordcount.pipe';

@NgModule({
  declarations: [
    AppComponent,
    WordcountPipe // added here by Angular CLI 
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```
This will create a base pipe ts file for us as well that we can make functional
```typescript
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'wordCount'
})
export class WordCountPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
```
The custom pipe we created makes use of the PipeTransform interface to gain access to the transform function. this function takes the value the pipe is being applied to and transforms it in some way, which we need to implement. In this case, our pipe is going to return the number of unique words of a string it is provided
```typescript
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'wordCount'
})
export class WordCountPipe implements PipeTransform {

  transform(value: string, ...args: any[]): number {
    return value.trim().split(" ").length;
  }

}
```
```html
<p> {{ "Angular is an application design framework" | wordcount}} </p>
<!--output '6' -->

```
the pipe above will take in a string, remove any starting or trailing white space, convert the string into a list of substrings seperated by a space, and then return the length of that list. The import statement above is what allows the @Pipe decorator to be used, and for the interface to be implemented. The name key in the Pipe decorator is used to indicate how to reference the pipe in your component html. 

In the example above we did not make use of the ...args parameter: this is used to provide further context to the pipe, and does not need to be a vararg. See the pipe below, which returns a number raised to the power provided, or the default one:
```typescript
@Pipe({name: 'powerUp'})
export class powerUpPipe implements PipeTransform {
  transform(value: number, power?: number): number {
    return Math.pow(value, isNaN(power) ? 1 : power);
  }
}
```
the pipe above will transform a number into its value when raised to the power provided(1 by default if no number is provided)
```html
<p> {{ 2 | powerUp }} </p>
<!--output '2' -->
<p> {{ 2 | powerUp : 3}} </p>
<!--output '8' -->
<p> {{ 5 | powerUp : 2}} </p>
<!--output '25' -->
```
### Services
Services are used in Angular to share business logic, models, data, or functions with different components of an Angular application. They use a singleton design patter, so all components that make use of a service are making use of the SAME service, and all its resources are shared. This synergizes well with the Dependency Injection design pattern: this is where a resource recieves its dependencies externally via a service, in the case of Angular. This is particularly useful for removing boilerplate code, and when multiple components need access to the same material. The command to create a service is ng g s ServiceName
```cli
ng g s EmployeeList
```
```typescript
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor() { }
}
```
The @Injectable() decorator marks a class as a service class that can be injected. The @Injectable() decorator has a providedIn property where we specify the provider of the decorated service class with the 'root' as a default, or any other module of our application. If you select root you need to make sure to add your service to the app.module file
```typescript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { WordcountPipe } from './wordcount.pipe';
import { EmployeeService } from './employee.service';

@NgModule({
  declarations: [
    AppComponent,
    WordcountPipe // added here by Angular CLI 
  ],
  imports: [
    BrowserModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
```
A service is available in the component and any sub components, but not others. You can make it available to all components by adding it to the root module (typically app.module). To make use of dependency injection you declare the service in the constructor and give it an access modifier: Angular will handle the injection itself. For this example the Employee Service returns a list of employees: useful if you have multiple modules that need to get employee information
```typescript
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
    getEmployees() : object {
        return [
        {"id" : 12 , "name" : "poko", "age" : 22 },
        {"id" : 13 , "name" : "Joseph", "age" : 25 },
        {"id" : 14 , "name" : "Alex", "age" : 35 }
    ];
  }
}
```
Now any component can use the getEmployees() method if it makes use of DI via declaring the service in its constructor with an access modifier
```typescript
// in the component
    public employees:object =[];
    constructor(private _employeeService : EmployeeService){
            this.employees = _employeeService.getEmployees();
```
### HTTPClient
The HTTPClient allows you to make HTTP requests the Angular way: you could just make use of async await and fetch, but the preffered way of making HTTP requests in Angular is to subscribe to observables. The HTTPClient provides means of making get, post, put, and delete methods easily (there are some others, but these will be our focus). The flow looks something like this when using the HTTPClient:
1. define the HTTP request using (preferably) a service where you have defined the HTTPClient.
```typescript
constructor(private http: HttpClient) { }

  // Http Headers: use these to provide meta data about the request
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  functionName(dataForBody): Observable<any>{
      return this.http.post<any>(url, dataForBody, this.httpOptions)
  }
```
this is incomplete though: you could get some sort of exception with the request (either client-side or server-side) so you will want to pipe() your method. An empty pipe will simply return the observable, wherase you can call two support methods: retry(num) determines how many times Angular should attempt to retry the request upon a fail, and catchError(someFunctionReference) is called if the the request fails
```typescript
constructor(private http: HttpClient) { }

  // Http Headers: use these to provide meta data about the request
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  // Error handling
  errorHandl(error) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }


  functionName(dataForBody): Observable<any>{
      return this.http.post<any>(url, dataForBody, this.httpOptions).pipe(retry(1),catchError(this.errorHandl))
  }
```
2. use dependency injection to use the service you created in step one to add it to the component you are using and create a function to make the HTTP Request
```typescript
    constructor(private httpService : HTTPService){}
    someObject = {
        "key1" : 18,
        "key2" : "Grace",
        "key3" :false
    };
    ngOnInit(){
        this.httpService.functionName(this.someObject)
        );
    } 
```
Now similar to creating the HTTP request function, simply calling the request is not enough: it returns an observable, and we need to do something with that observable. The Angular way is to "subscribe" to the observable, which is done by calling the subscribe() function on the http request function. subscribe uses a callback function to interact with the content of the observable
```typescript
    constructor(private httpService : HTTPService){}
    someObject = {
        "key1" : 18,
        "key2" : "Grace",
        "key3" :false
    };
    ngOnInit(){
        this.httpService.functionName(this.someObject).subscribe(dataOfObservable =>{/* do something with dataOfObservable */});
    } 
```
### Observable
An observable is an object that can transfer information between parts of an Angular application. They can be used for event handling, asynchronous programming, and for handling multiple values. Observables make use of the pipe() and subscribe() methods: pipe is used to handle either returning the observable or throwing an exception, while subscribe is used to do something with the data returned by the observable. You can manually create an observable by importing of and observable from "rxjs". After you make your observer by  implementing a next, error, and complete method, you can pass in the observer into the subscribe function called by the observable.
```typescript
import {Observable, of } from "rxjs";

export class AppComponent {
// Create simple observable that emits three values
myObservable = of(1, 2, 3);

// Create observer object
myObserver = {
  next: x => console.log('Observer got a next value: ' + x),
  error: err => console.error('Observer got an error: ' + err),
  complete: () => console.log('Observer got a complete notification'),
};

// Execute with the observer object
constructor(){
  this.myObservable.subscribe(this.myObserver);
}
// Logs:
// Observer got a next value: 1
// Observer got a next value: 2
// Observer got a next value: 3
// Observer got a complete notification
  
}
```
### Subjects
Reactive Extensions for JavaScript (RxJS) is how Angular makes use of special kinds of observables called subjects. At their core, subjects allow multiple observers to subscribe to the same observable. By default an RxJS Observable is unicast, i.e. each subscribed observer has an independent execution of the Observable, whereas multicast means that the Observable execution is shared by multiple Observers. Notice how in the example below the first observer also interacts with the material provided to the second observer.
```typescript
import { Subject } from "rxjs";
export class AppComponent implements OnInit{
  ngOnInit(){
      const subject = new Subject();
      //First Observer
      subject.subscribe({
         next: (data) => console.log('First observer prints '+ data)
      });
      subject.next(1);
      //Second Observer
      subject.subscribe({
         next: (data) => console.log('Second observer prints '+ data)
      });
      subject.next(34);
      subject.next(14);
   }
//Logs:
//First observer prints 1
//First observer prints 34
//Second observer prints 34
//First observer prints 14
//Second observer prints 14
}
```
There are a few other specific subscribers you can use: see their info in gitlab for more info
### Routing
Because Angular apps are single page applications you need to have a way to change what you are looking at in the browser without actually changing your web page to a new one: Angular handles this with routing. There is a RouterModule that contains the necesary services and directives to make routing work.The router defines navigation of views on a single page and interprets URL links to determine which views to create or destroy, and which components to load or unload. A routing component imports the Router module, and its template contains a RouterOutlet element where it can display views produced by the router.

An easy way to get started with an Angular app using routing is to run the command ng new name --routing
```cli
ng new {name} --routing
```
You will want to make sure you have a tag in the head of the index.html called base with an href attribute set to "/": this will allow Angular to construct the urls you need while running
```html
<base href="/">
```
create the components you will be switching between and make sure they are added to the ROUTING module.ts file
```typescript
// without components
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

```
```typescript
// with components: ignore the poor naming, I forgot Angular auto-adds Component to the end of the Component name you create
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstComponentComponent } from './components/first-component/first-component.component';
import { SecondComponentComponent } from './components/second-component/second-component.component';

// this is where you determine the url path for the component and what component that url links to
const routes: Routes = [
  {path:"first-component", component:FirstComponentComponent},
  {path:"second-component", component:SecondComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
```
You now can make use of the router outlet element that works as a placeholder for whatever component you are currently switched to: clicking a link to a new component will change the content of the router outlet element to the content of the new component. You can use anchor elements to link between components: it needs a routerLink attribute with the url for the component that was set in the router module, and a routerLinkActive attribute to determine if the link is active or not.
```html
  <ul>
    <li><a routerLink="/first-component" routerLinkActive="active">First Component</a></li>
    <li><a routerLink="/second-component" routerLinkActive="active">Second Component</a></li>
  </ul>
  <!-- components will be rendered in the router-outlet element below -->
<router-outlet></router-outlet>
```
--------------------------------------------------------------------------------------------
 ***
 ***
 ***
OLD NOTES ARE BELOW: KEEPING THEM AROUND TO POSSIBLY MERGE WITH THE NEW NOTES ABOVE
 ***
 ***
 ***
--------------------------------------------------------------------------------------------


### Angular setup
1. make sure you have Node.js installed
    - https://nodejs.org/en/
    - the download and install can take a while, make sure you get it set up ahead of time
2. get the angular command line interface
    - npm install -g @angular/cli
        - the g means to install it globally
3. once you have both node and the angular cli installed you can run the command "ng new" to create a new application
    - ng is used for angular commands, npm for node package manager. For angular projects you will primarily use ng
    - ng new my-app creates an angular project with the name MyApp
    - don't enforce strict typing
    - will want routing in the future
    - use regular css
### Basic Angular CLI Commands
- ng --version
    - checks version of Angular CLI
- ng new
    - creates an angular app
- ng generate (ng g)
    - create things in your application
        - components (ng g c OR ng g component)
        - service (ng g s OR ng g service)
        - module (ng g m OR ng g module)
        - class (ng g class)
        - pipe (ng g pipe)
        - directive (ng g direective)
- ng serve
    - runs app locally on port 4200
- ng test
    - runs unit tests
- ng e2e 
    - runs end to end tests (depricated, use your own selenium tests)
- ng build
    - used for deployment
### Basic Angular Starting App
There are a few base folders and files to be aware of
- package.json
    - this contains all the different dependencies for the project
        - contains some ng commands as well
- .gitignore
    - useful for preventing unneccesary files from being pushed to your github repository
- node modules folder
    - contains the dofferent modules your angular application uses
    - this is a very large folder, and it should not be pushed to your repo
- src folder
    - this is where the bass app, assest, and environment folders are. Will do the majority of our work here
        - inside the app you have some starting component files, 
            - app.component.css provides styling for the html template
            - app.component.html is the html template for the component
            - app.component.spec.tes (unit testing with Jasmine, don't actually need)
            - app.component.ts is the typescript file for the component
            - app.module.ts is used to manage the application
                - in the module bootstrap tells us what class our app opens with
### Angular Terms
There are many terms that will be thrown around when learning Angular: these are some of the core concepts of Angular you need to know:
- component
    - components are the visual aspect of Angular
    - this includes both the html of the module and the Typescript
- module
    - modules are the "managers" of Angular
    - the app.module is the main manager of your application
- service
    - "behind the scenes" worker of angular
    - you can create services and then inject them into your components to decouple the implementation of your code from the components themselves
- directive
    - directives are custom HTML used in Angular (think custom tags and attributes). There are three different kinds of directives
        - component directive (html tag to reference component)
            - contents of component will replace tag in html
            ```html
            <!-- inside the app.component.html -->
            <h1>This is a normal header</h1>
            <my-component-directive></my-component-directive>
            ```
            ```html
            <!-- inside the my-component html template -->
            <h3>This smaller header is inside the "my-component" html template</h3>
            <p>this content will be rendered on the dom where the my-component-directive element is</p>
            ```
        - structural directive (property)
            - built into angular
            - attributes on html tags
                - start with *ng
                - *ngIf, *ngFor, *ngSwitch, *ngCase
                    - can manipulate the dom using logic controlled by directives
                    - example: <tr *ngFor="let pet of pets">{{pet}}</tr>
                    - example: <button *ngIf="userLoggedIn">Hello {{username}}</button>
        - attribute directive (property)
            - affect the look of an element
            - some built in, can make custom ones
            - p appColor
            - p appHighlight
            - very similar to css classes
- data binding
    - angular template syntax (something you can use in html that is special to Angular) that allows communication between your typescript and html
        - makes html easier to read
    - four types of data binding
        - interpolation
            - similar to string interpolation
                - p {{variableOrObject.property}}/p
        - property
            - img [src]="typscriptForURL"
                - square brackets indicate your value is coming from your typescript
        - event
            - button (click)="typscriptHere"
                - if you call a function you need to add the () for the function
    - two way binding
        - uses "banana in a box" [()]
        - main one we will use is ngModel
            - input [(ngModel)]="usernameInput" type="text
                - usernameInput is a variable in our typescript
                - every time a change is made to the input, the value of the variable changes
                - ngModel is used to bind the value of an element with a typescript field
- pipes
    - makes use of template syntax for formatting/filtering data
        - {{object.date|date}} will format a date
        - {{object.money|currency:'USD'}} will format currency
    - you can make your own custom pips
        - ng g pipe nameOfPipe
            - this generates a TS class with a transform method
            - takes in the value and any parameters
                - transforms or performs some function upon said data
- services
    - code that could be reusable and/or more complicated logic to be **provided** to components
    - services go into the "providers" array in the app module
    - a service is a dependency to a component if that component needs it
    - dependency injection is providing a dependency manually instead of the dependency being acquired automatically
        - angular uses constructor injection
            - specify dependency as a constructor parameter, the framework provides it when the class is instantiated
            - constructor(fetchService:FetchService){ this.fetchService = fetchService; }
                - angular looks in the module providers array for a match and passes that in
            - constructor(private fetchServ:FetchService){}
                - by setting the access level Angular will automatically create a field for this service
    - the benefit of dependency injection is that it provides loose coupling
        - code is a little more flexible than a hard-codeded solution
- HTTPClient
    - a module made for sending HTTP requests
    - Fetch returns Promise objects
    - HTTP Client returns an observable (uses rxjs module)
        - similar to promises, allow asynchronous codes
        - unlike promises, observables work like a stream of events
            - allow you to "observe" a stream of events
            - fetch is easier to use, but angular apps most likely will use HTTPClient, so get familiar with it
                - to use HTTPClientModule, add it to the imports array in the app.module.ts file
                - then set up inject for HTTPClient object where it is needed (constructor(private http:HttPClient))
                - to use it: this.http.get(http://url).pipe(map(resp=> resp as obj));
                    - returns an observable
        - to use an observable you have to subscribe to it
            - assign the response of your http.get to a variable
                - to use the observable use the subscribe method
                    - observable.subscribe(resp=>{code here})