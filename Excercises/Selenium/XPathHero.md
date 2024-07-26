# Xpath Hero

## Important Resources
- [XPath Hero](https://github.com/adamranieri/XPath-Hero)
- [XPath cheatsheet](https://devhints.io/xpath)

## Time
- 2 hours

### Description
Using the html documents in the repo linked under Important Resources, try to extract information using xpath (as described in questions.md in the linked repo). In google chrome you can select elements using xpath by typing $x("xpath string") into the DevTools Console.

### Associate Instructions
1. Open up html files in chrome
2. For each bullet point in questions.md, write an xpath to locate the specified element(s).

### Example

```html
<!DOCTYPE html>
<html>
    <head>
        <title>Example</title>
    </head>
    <body>
        <div class="inputs">
            <input id="exInput" class="demo" type="text">
             <input id="ex2Input" class="demo" type="password">
        </div>
  
    </body>
    
</html>
```
- To select the input element for password - we have a few options.
- Absolute
    - /html/body/div/input[2]
- Relative
    - //input[@type='password']
    - //div/input[2]
    - //div/input[@type='password']
    - etc.


