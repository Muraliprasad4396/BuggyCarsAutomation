package buggyCarTestScenarios;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigateScreen {
	
	// Initialize logger
    private static final Logger LOGGER = Logger.getLogger(NavigateScreen.class.getName());
	
	public void navigatePopularMakeTest(WebDriver driver) {
		
		driver.get("https://buggy.justtestit.org/make/c4u1mqnarscc72is00ng");
		
	    // Wait for the page to load 
        Utils utils = new Utils();
        utils.waitForPageObject(driver, By.xpath("//h3[@class='card-header']"));
        
        if(driver.findElement(By.xpath("//h3[@class='card-header']")) != null)
        {
        	LOGGER.info("Navigation to popular make is successful!");
        } else {
        	LOGGER.info("Navigation to popular make is failed.");
        }
        
	}
	
	public void navigatePopularModelTest(WebDriver driver) {
		
		driver.get("https://buggy.justtestit.org/model/c4u1mqnarscc72is00ng|c4u1mqnarscc72is00sg");
		
	    // Wait for the page to load 
        Utils utils = new Utils();
        utils.waitForPageObject(driver, By.xpath("//h4[contains(text(),'Specification')]"));
        
        if(driver.findElement(By.xpath("//h4[contains(text(),'Specification')]")) != null)
        {
        	LOGGER.info("Navigation to popular model is successful!");
        } else {
        	LOGGER.info("Navigation to popular model is failed.");
        }
        
        // Find the Home page (Buggy Rating) option and click it
	    WebElement homePageButton = driver.findElement(By.xpath("//a[@class='navbar-brand']"));
	    homePageButton.click();
	    
	    // Wait for the home page to load 
        utils.waitForPageObject(driver, By.xpath("//h2[contains(text(),'Popular Make')]"));
        
        if(driver.findElement(By.xpath("//h2[contains(text(),'Popular Make')]")) != null)
        {
        	LOGGER.info("Navigation to home screen is successful!");
        } else {
        	LOGGER.info("Navigation to home screen is failed.");
        }
        
	}
	
	public void navigateOverallRatingTest(WebDriver driver) {
		
		driver.get("https://buggy.justtestit.org/overall");
		
	    // Wait for the page to load 
        Utils utils = new Utils();
        utils.waitForPageObject(driver, By.xpath("//th[contains(text(),'Comments')]"));
        
        if(driver.findElement(By.xpath("//th[contains(text(),'Comments')]")) != null)
        {
        	LOGGER.info("Navigation to overall rating is successful!");
        } else {
        	LOGGER.info("Navigation to overall rating is failed.");
        }
        
        // Find the Home page (Buggy Rating) option and click it
	    WebElement homePageButton = driver.findElement(By.xpath("//a[@class='navbar-brand']"));
	    homePageButton.click();
	    
	    // Wait for the home page to load 
        utils.waitForPageObject(driver, By.xpath("//h2[contains(text(),'Popular Make')]"));
        
        if(driver.findElement(By.xpath("//h2[contains(text(),'Popular Make')]")) != null)
        {
        	LOGGER.info("Navigation to home screen is successful!");
        } else {
        	LOGGER.info("Navigation to home screen is failed.");
        }
        
	}
}
