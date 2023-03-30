package buggyCarTestScenarios;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VotingScreen {
	
	// Initialize logger
    private static final Logger LOGGER = Logger.getLogger(VotingScreen.class.getName());

	public void votePopularModelTest(String comment,WebDriver driver) {
		
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
        
        // Find the comment input element and enter the comment
        WebElement commentInput = driver.findElement(By.xpath("//textarea[@id='comment']"));
        commentInput.sendKeys(comment);
       
        // Find the Vote button and click it
	    WebElement voteButton = driver.findElement(By.xpath("//button[contains(text(),'Vote!')]"));
	    voteButton.click();
	    
	    // Wait for the home page to load 
        utils.waitForPageObject(driver, By.xpath("//p[contains(text(),'Thank you for your vote!')]"));
        
        //Validate Success Message
        String successMessage = driver.findElement(By.xpath("//p[contains(text(),'Thank you for your vote!')]")).getText();
        String expectedMessage = "Thank you for your vote!";
        if (successMessage.equals(expectedMessage)) {
        	LOGGER.info("Voting successful!");
        } else {
        	LOGGER.info("Voting failed");
        }
        
        //Validate Comment update
        String tableComment = driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
        if (tableComment.equals(comment)) {
        	LOGGER.info("Comment update successful!");
        } else {
        	LOGGER.info("Comment update failed");
        }
	}
}
