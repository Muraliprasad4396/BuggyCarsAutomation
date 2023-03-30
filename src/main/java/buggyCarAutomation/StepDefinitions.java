package buggyCarAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import buggyCarTestScenarios.LoginScreen;
import buggyCarTestScenarios.NavigateScreen;
import buggyCarTestScenarios.ProfileScreen;
import buggyCarTestScenarios.RegisterScreen;
import buggyCarTestScenarios.Utils;
import buggyCarTestScenarios.VotingScreen;

@Test
public class StepDefinitions {
	
	public void LoginCase() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        // Create an instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Buggy login page URL
        driver.get("https://buggy.justtestit.org/");
        
        // Wait for the page to load home page
        Utils utils = new Utils();
        utils.waitForPageObject(driver, By.xpath("//h1[@class='display-4']"));
        
		LoginScreen loginScreen = new LoginScreen();
		
		//positive scenario
		loginScreen.loginTest("Murali@123", "Pass@123", driver);
		
		// Close the browser
        driver.quit();
        
	}
	
	public void RegisterCase() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        // Create an instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Buggy login page URL
        driver.get("https://buggy.justtestit.org/");
        
        // Wait for the page to load home page
        Utils utils = new Utils();
        utils.waitForPageObject(driver, By.xpath("//h1[@class='display-4']"));
        
		RegisterScreen registerScreen = new RegisterScreen();
		
		// Register scenario
		registerScreen.registerTest("Murali@777", "Murali","Prasad", "Pass123!", "Pass123!", driver);
		
		// Close the browser
        driver.quit();
	}
	
	public void NavigateCase() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        // Create an instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Buggy login page URL
        driver.get("https://buggy.justtestit.org/");
        
        // Wait for the page to load home page
        Utils utils = new Utils();
        utils.waitForPageObject(driver, By.xpath("//h1[@class='display-4']"));
        
        NavigateScreen navigateScreen = new NavigateScreen();
		
		//Navigation to popular make page
        navigateScreen.navigatePopularMakeTest(driver);
        
        //Navigation to popular model page
        navigateScreen.navigatePopularModelTest(driver);
        
        //Navigation to popular overall rating page
        navigateScreen.navigateOverallRatingTest(driver);
		
		// Close the browser
        driver.quit();
	}
	
	public void VotingCase() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        // Create an instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Buggy login page URL
        driver.get("https://buggy.justtestit.org/");
        
        // Wait for the page to load home page
        Utils utils = new Utils();
        utils.waitForPageObject(driver, By.xpath("//h1[@class='display-4']"));
        
        //Voting validation
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.loginTest("Murali@777", "Pass123!", driver);
        VotingScreen votingScreen = new VotingScreen();
        votingScreen.votePopularModelTest("Test Comment",driver);
		
		// Close the browser
        driver.quit();
	}
	
	public void ProfileCase() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        // Create an instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Buggy login page URL
        driver.get("https://buggy.justtestit.org/");
        
        // Wait for the page to load home page
        Utils utils = new Utils();
        utils.waitForPageObject(driver, By.xpath("//h1[@class='display-4']"));
        
		ProfileScreen profileScreen = new ProfileScreen();
		
		// Update profile
		LoginScreen loginScreen = new LoginScreen();
        loginScreen.loginTest("Murali@999", "Pass123!", driver);
		profileScreen.updateProfileTest("Male", "27","Dominion road", "1234567", driver);
		
		// Close the browser
        driver.quit();
	}
	
	public void logFile() {
	
		// Generate log file
		Utils utils = new Utils();
		utils.logs();
	
	}

}
