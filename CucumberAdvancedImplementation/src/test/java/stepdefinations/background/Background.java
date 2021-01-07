package stepdefinations.background;

import java.util.concurrent.TimeUnit;

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


public class Background {
	
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
	
//	@BeforeStep
//	public void beforeStep() {
//		System.out.println("Runs before every step");
//	}
//	
//	@AfterStep(order=1)
//	public void afterStep() {
//		System.out.println("Runs after every step");
//	}
//	
//	@AfterStep(order=2)
//	public void afterStep1() {
//		System.out.println("Runs after every step1");
//	}
	
	@Given("User navigates to the login page")
	public void user_navigates_to_the_login_page() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		signInPage = new SignInPage(driver);
	}

	@When("User fills the login form with username and password")
	public void user_fills_the_login_form_with_username_and_password() {
		signInPage.setEmail("tester@test.com");
		signInPage.setPassword("tester123");
	}
	@When("Clicks on signin button to login")
	public void clicks_on_signin_button_to_login() {
	    signInPage.clickSignInButton();
	}

	@Then("User will be navigated to the accountpage")
	public void user_will_be_navigated_to_the_home_page() {
	    Assert.assertEquals("My account - My Store",signInPage.getPageTitle());
	}
	
	@Then("page title of the page should have MyAccount")
	public void user_will_be_navigated_to_the_my_Account_page() {
	    Assert.assertEquals("My account - My Store",signInPage.getPageTitle());
	}
	
	@When("user hovers on the navbar")
	public void user_hovers_on_the_navbar() {
	}
	
	@Then("logout button will exist on the right side")
	public void logout_button_will_exist_on_the_right_side() {
		Assert.assertTrue(signInPage.logoutButtonExists());
	}
}