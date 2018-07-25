Feature: List all owners.

	I should be able to search list all owners
	So that I can choose any one of them view their detail

	@Dev @Qmg
	Scenario: Search owners without any criteria
		When I search owners without any criteria
		Then I shoud get a list of owners