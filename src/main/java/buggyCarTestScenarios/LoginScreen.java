package buggyCarTestScenarios;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginScreen {
	
	// Initialize logger
	private static final Logger LOGGER = LogManager.getLogger(LoginScreen.class.getName());
	
	@Test
	public void loginTest(String username, String password, WebDriver driver) {
		
        // Find the email input element and enter the email address
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='text']"));
        emailInput.sendKeys(username);

        // Find the password input element and enter the password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys(password);

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for the page to load and verify that the login was successful
        Utils utils = new Utils();
        utils.waitForPageObject(driver, By.xpath("//a[contains(text(),'Logout')]"));
        
        int buttonExist = driver.findElements(By.xpath("//a[contains(text(),'Logout')]")).size();
        if (buttonExist != 0) {
        	LOGGER.info("Login successful!");
        } else {
        	LOGGER.info("Login failed.");
        }	
        
	}
}
