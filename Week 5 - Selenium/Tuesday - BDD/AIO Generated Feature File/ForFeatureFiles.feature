# This tag is the name of the Folder the Test Case was saved in inside AIO
@ForFeatureFiles
Feature: ForFeatureFiles
	# this is the ID of the Test Case in AIO
	@REV-TC-10
	Scenario: BDD Scenario
	Showcasing a Scenario in Gherkin
		Given some initial starting step
		When Something happens
		Then expected final condition
	# this is the ID of the Test Case in AIO
	@REV-TC-11
	Scenario Outline: BDD Scenario Outline
	Showcasing Scenario Outline
		Given Initial step
		When action <Data>
		Then expected final condition
	# This examples section was set in the dataset section of the Test Case in AIO
	Examples: 
		| Data  |
		| one   |
		| two   |
		| three |