# HTTP
Hyper Text Transfer Protocol (HTTP) is a request/response system for transfering data across the web. A client makes a request to a web server that returns a response: the content of the request and response is determined by the service being used. The specifics of these resources will be covered in more depth later, but for the time being you should be aware that all requests have a "method", and all responses have a status code.

## HTTP Method
A Request method is used to help the web service determine what kind of action the user is trying to make:
- GET: a GET request is the user trying to retrieve data from the web service
    - think viewing all items you have added to a shopping cart
    - GET requests can not send data in their "body", unlike the other methods
- PUT: a PUT request is the user trying to replace data in the web service
    - think replacing a shirt in your shopping cart with a similar option suggested by the vendor
- PATCH: a PATCH request is the user trying to update data in the web service
    - think changing the number battery packs in your shopping cart from 5 to 3
- POST: a POST request is the user trying to create some kind of data
    - think adding a new item in to your shopping cart
- DELETE: a DELETE request is the user trying to remove data from the web service
    - think clearing your shopping cart

Keep in mind this list is not exhaustive, and there is no system in place that requires these methods to be associated with their given actions, but it is a commonly used convention, and HTTP requests require having an associated method.

## HTTP Status codes
A Response will have an associated status code that provides a quick indicator about how the user Request was handled
- 100 level
    - continue: things are fine, the HTTP request is moving on
    - not commonly seen
- 200 level
    - success: the intended action was completed
- 300 level
    - redirect: the request either triggered another request, or the user must provide more input to complete whatever initial request was made
- 400 level
    - client error: the user request failed in some way due to the user making a mistake
        - incorrect login credentials
        - attempting to withdraw more money than available
        - trying to access a restricted resource
- 500 level
    - server error: the web service could not handle the request because something has failed server side
        - this is a developer error, not a user error. You don't want your applications returning 500 status codes

Note that the different levels have various status codes to indicate specific feedback. For instance, the 201 status code is typically used for indicating that a new resource was successfully created (think uploading a new picture to your social media account). 401 is the unauthorized code, which could be returned if you try to access a service reserved for a manager or subscriber to a service.