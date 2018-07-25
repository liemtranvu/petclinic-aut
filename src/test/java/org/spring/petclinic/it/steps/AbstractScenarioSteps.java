package org.spring.petclinic.it.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.spring.petclinic.it.CustomWebDriver;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.webdriver.WebDriverFacade;

import java.util.Iterator;
import java.util.List;

public abstract class AbstractScenarioSteps extends ScenarioSteps{

	private static final long serialVersionUID = 8547006922417764911L;
	
	@Override
	public CustomWebDriver getDriver() {	
		return ((org.spring.petclinic.it.CustomWebDriver)((WebDriverFacade)super.getDriver()).getProxiedDriver());
	}

	public WebElement findLinkByHref(String href) {
		List<WebElement> anchors = getDriver().findElements(By.tagName("a"));
		Iterator<WebElement> i = anchors.iterator();

		while(i.hasNext()) {
			WebElement anchor = i.next();
			if(anchor.getAttribute("href").contains(href)) {
				return anchor;
			}
		}
		return null;
	}

}
