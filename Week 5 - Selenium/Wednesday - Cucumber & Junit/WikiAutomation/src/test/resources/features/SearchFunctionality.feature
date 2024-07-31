@SearchFunctionality
Feature: SearchFunctionality

	@REV-TC-12
	Scenario: As a User I want to search for informative articles on Wikipedia so I can learn new things
	Search bar functionality System Test for Wikipedia homepage
		Given The User is on the Wikipedia homepage
		When The User enters puppy in the search bar
		When The User clicks the search button
		Then The User should be redirected to the Puppy Wikipedia article

	@REV-TC-13
	Scenario Outline: As a User I want to use Wikipedia in my own language, so I can understand the articles I read
	Language links verifying functionality System Test
		Given The User is on the Wikipedia homepage
		When The User clicks <language> link
		Then The User should be redirected to <title>

	Examples: 
		| language       | title                            |
		| js-link-box-en | Wikipedia, the free encyclopedia |
		| js-link-box-es | Wikipedia, la enciclopedia libre |
		| js-link-box-it | Wikipedia, l'enciclopedia libera |