package org.spring.petclinic.it;

import org.openqa.selenium.WebDriver;
import net.thucydides.core.webdriver.DriverSource;

public class WebDriverProvider implements DriverSource {
	
	public WebDriver newDriver() {
		return new CustomWebDriver();
	}

	public boolean takesScreenshots() {
		return true;
	}

}
