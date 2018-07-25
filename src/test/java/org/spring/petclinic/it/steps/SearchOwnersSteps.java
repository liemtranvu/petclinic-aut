package org.spring.petclinic.it.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.spring.petclinic.it.Action;

public class SearchOwnersSteps extends AbstractScenarioSteps{

	private static final long serialVersionUID = -9058480755359036208L;

	public void searchOwners(){
		
		getDriver().takeAction(new Action() {
			public void apply(WebDriver d) {
		    	WebElement link  = findLinkByHref("/owners/find");
		    	link.click();
			}
		});
	}
	
	public void verifySearchResults(){
		getDriver().waitUntil(5, new ExpectedCondition<Boolean>() {
		    public Boolean apply(WebDriver d) {
		        return d.findElement(By.id("search-owner-form")).isDisplayed();
		    }
		});	 	
	}	
}
