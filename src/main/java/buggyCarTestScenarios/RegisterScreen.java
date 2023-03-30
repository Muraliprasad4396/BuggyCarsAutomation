package buggyCarTestScenarios;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterScreen {
	
	// Initialize logger
    private static final Logger LOGGER = Logger.getLogger(RegisterScreen.class.getName());
	
	public void registerTest(String myUsername, String firstName ,String lastName,String myPassword, String confirmPassword, WebDriver driver) {

		// Find the Register button and click it
	    WebElement registerButton = driver.findElement(By.xpath("//a[@class='btn btn-success-outline']"));
	    registerButton.click();
	    
	    // Wait for the page to load and verify that the login was successful
        Utils utils = new Utils();
        utils.waitForPageObject(driver, By.xpath("//h2[contains(text(),'Register with Buggy Cars Rating')]"));
        
        // Fill in the registration form
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='lastName']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement confirmPasswordInput = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Register')]"));
        
        usernameInput.sendKeys(myUsername);
        passwordInput.sendKeys(myPassword);
        confirmPasswordInput.sendKeys(confirmPassword);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);

        // Submit the form
        submitButton.click();
        
        // Wait for the page to load and verify that the login was successful
        utils.waitForPageObject(driver, By.xpath("//div[@class='result alert alert-success']"));
        
        //Validate Success Message
        String successMessage = driver.findElement(By.xpath("//div[@class='result alert alert-success']")).getText();
        String expectedMessage = "Registration is successful";
        if (successMessage.equals(expectedMessage)) {
        	LOGGER.info("Registration successful!");
        } else {
        	LOGGER.info("Registration failed.");
        }
	}
}
