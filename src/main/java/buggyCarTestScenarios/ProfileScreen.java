package buggyCarTestScenarios;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileScreen {
	
	// Initialize logger
    private static final Logger LOGGER = Logger.getLogger(ProfileScreen.class.getName());
	
	public void updateProfileTest(String gender, String age, String address, String phone, WebDriver driver) {
		
		WebElement profileButton = driver.findElement(By.xpath("//a[contains(text(),'Profile')]"));
		profileButton.click();
	    
	    // Wait for the page to load and verify that the login was successful
        Utils utils = new Utils();
        utils.waitForPageObject(driver, By.xpath("//input[@id='gender']"));
        
        // Fill in the registration form
        WebElement genderInput = driver.findElement(By.xpath("//input[@id='gender']"));
        WebElement ageInput = driver.findElement(By.xpath("//input[@id='age']"));
        WebElement addressInput = driver.findElement(By.xpath("//textarea[@id='address']"));
        WebElement phoneInput = driver.findElement(By.xpath("//input[@id='phone']"));
        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
        
        genderInput.clear();
        ageInput.clear();
        addressInput.clear();
        phoneInput.clear();
        genderInput.sendKeys(gender);
        ageInput.sendKeys(age);
        addressInput.sendKeys(address);
        phoneInput.sendKeys(phone);

        // Submit the form
        saveButton.click();
        
        // Wait for the page to load and verify that the profile update was successful
        utils.waitForPageObject(driver, By.xpath("//div[@class='result alert alert-success hidden-md-down']"));
        
        //Validate Success Message
        String successMessage = driver.findElement(By.xpath("//div[@class='result alert alert-success hidden-md-down']")).getText();
        String expectedMessage = "The profile has been saved successful";
        if (successMessage.equals(expectedMessage)) {
        	LOGGER.info("Profile update successful!");
        } else {
        	LOGGER.info("Profile update failed.");
        }
		
	}

}
