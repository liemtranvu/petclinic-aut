package org.spring.petclinic.it;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.logging.Level;


public class SharedWebDriver extends EventFiringWebDriver {
	
	
	private static final String SELENIUM_DRIVER_PROPERTY = "selenium.driver";
    private static WebDriver SHARED_DRIVER;
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {        	
        	SHARED_DRIVER.quit();
        }
    };

    static {
        String driver = System.getProperty(SELENIUM_DRIVER_PROPERTY);
        if(driver == null) {
            SHARED_DRIVER = new PhantomJSDriver();
            ((PhantomJSDriver) SHARED_DRIVER).setLogLevel(Level.FINEST);
            SHARED_DRIVER.navigate().to("http://localhost:8080");
        }else {
            SHARED_DRIVER = sharedWebDriver();
        }
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }
    
    private static WebDriver sharedWebDriver() throws WebDriverException {
		try {
			Class<?> delegate = Class.forName(System.getProperty(SELENIUM_DRIVER_PROPERTY,"org.openqa.selenium.phantomjs.PhantomJSDriver"));
			return (WebDriver)delegate.newInstance();
		} catch (ClassNotFoundException cnfe) {
			throw new WebDriverException("Driver class not found", cnfe);
		} catch (Exception e) {
			throw new WebDriverException(e);
		}
		
	}    

    public SharedWebDriver() {
        super(SHARED_DRIVER);
    }
    
    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }
    
    @Override
    public void quit() {}
    
    WebDriver getProxiedDriver(){
    	return SHARED_DRIVER;
    }
  
}