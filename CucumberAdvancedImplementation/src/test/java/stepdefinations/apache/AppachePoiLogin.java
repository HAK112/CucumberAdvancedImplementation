package stepdefinations.apache;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.ExcelReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SignInPage;


public class AppachePoiLogin {
	
	WebDriver driver = null;
	SignInPage signInPage; 
	ExcelReader reader = null; 
	
	@Before
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 		
	}
	
	@After
	public void browserClose() {
		driver.close(); 
	}
	

	
	@Given("User navigates to the login page")
	public void user_navigates_to_the_login_page() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		signInPage = new SignInPage(driver);
	}

	@When("User fills the form from given sheetname {string} and {int}")
	public void user_fills_the_form_from_given_sheetname_and(String sheetname, Integer rowNumber) throws InvalidFormatException, IOException {
		reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("src/test/resources/ExcelData/login.xlsx", sheetname);
		String EmailAddress = testData.get(rowNumber).get("Email");
		String Password = testData.get(rowNumber).get("Password");
		signInPage.setEmail(EmailAddress);
		signInPage.setPassword(Password);
	}
	@When("Clicks on signin button to login")
	public void clicks_on_signin_button_to_login() {
	    signInPage.clickSignInButton();
	}

	@Then("User will be navigated to the home page")
	public void user_will_be_navigated_to_the_home_page() throws InterruptedException {
	    Assert.assertEquals(signInPage.getPageTitle(), "MY ACCOUNT");
	    Thread.sleep(3000);
	}
}