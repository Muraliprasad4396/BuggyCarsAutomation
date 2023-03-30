package buggyCarTestScenarios;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import buggyCarAutomation.StepDefinitions;


public class Utils {
	
	// Initialize logger
    private static final Logger LOGGER = Logger.getLogger(StepDefinitions.class.getName());
	
    public void waitForPageObject(WebDriver driver, By locator) {
        for (int i = 0; i < 10; i++) {
            try {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
            	LOGGER.log(Level.INFO, "Page object not found yet, waiting...");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void logs() {
		
    	PropertyConfigurator.configure("./src/main/resources/log4j.properties");
    }

}
