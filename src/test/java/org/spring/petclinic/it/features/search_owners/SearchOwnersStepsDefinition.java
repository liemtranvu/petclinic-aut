package org.spring.petclinic.it.features.search_owners;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.spring.petclinic.it.steps.SearchOwnersSteps;

public class SearchOwnersStepsDefinition {
	
	@Steps
	private SearchOwnersSteps steps;


	@When("^I search owners without any criteria$")
	public void i_search_vets_without_any_criteria() throws Throwable {
		steps.searchOwners();
	}

	@Then("^I shoud get a list of owners$")
	public void i_shoud_get_a_list_of_vets() throws Throwable {
		steps.verifySearchResults();
	}

}
