package StepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUp_Loginpage;
import pages.signupPage;

public class LoginStepDef {

	private WebDriver driver = DriverFactory.getDriver();
	private LoginPage login = new LoginPage();
	private DriverFactory driverFactory = new DriverFactory();
	private SignUp_Loginpage slpage = new SignUp_Loginpage(DriverFactory.getDriver());
	private HomePage home = new HomePage(DriverFactory.getDriver());
	private signupPage spage = new signupPage(DriverFactory.getDriver());
	private static final Logger logger = LogManager.getLogger(LoginStepDef.class);

	@When("I open the '(.+)' browser")
	public void i_open_the_browser(String browser) {
		logger.info("Opening the Browser");
		DriverFactory.initDriver(browser);
	}

	@When("^I added URL '(.+)'$")
	public void i_added_url(String url) {

		logger.info("Trying to open application : {}", url);
		driver.get(url);
	}

	@Then("^I should able to see the homepage$")
	public void I_should_able_to_see_the_homepage() {
		String HomePageTitle = driver.getTitle();
		Assert.assertEquals(HomePageTitle, "Automation Exercise");
	}

	@And("^I navigate to the New User Signup page$")
	public void navigate_to_signup_page() {

		// Assert.assertTrue(home.signUp_login_btn.isDisplayed());
		home.signUp_login_btn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(slpage.newUserSignup_txt));

		Assert.assertTrue(slpage.newUserSignup_txt.isDisplayed());
		logger.info("New User SignUp Text displayed");

		Assert.assertTrue(slpage.signUp_name_txtbox.isDisplayed());
		logger.info("New User SignUp Text displayed");

		Assert.assertTrue(slpage.signup_email.isDisplayed());
		logger.info("New User SignUp email text box displayed");

		Assert.assertTrue(slpage.signUpBtn.isDisplayed());
		logger.info("New User SignUp Button displayed");

	}

	@When("^I enter name '(.+)'$")
	public void enter_name(String name) {
		logger.info("Trying to add the name : {}", name);

		slpage.signUp_name_txtbox.sendKeys(name);

	}

	@And("^I enter email '(.+)'$")
	public void enter_email(String email) {
		logger.info("Trying to add the email : {}", email);

		slpage.signup_email.sendKeys(email);

	}

	@And("^I click on the Signup button$")
	public void click_signup_button() throws InterruptedException {
		logger.info("Trying to signup by clicking on signup button");

		slpage.signUpBtn.click();
		Thread.sleep(1000);
		WebElement createAccount_element = spage.createAccount_button;
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				createAccount_element);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(createAccount_element));
		Assert.assertTrue(createAccount_element.isDisplayed() && createAccount_element.isEnabled());
	}

	@Then("^I should navigate to the signup page$")
	public void i_should_navigate_to_the_signup_page() {
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("signup"));
		logger.info("As expected user navigated to the signup page");

	}

	@And("^I entered details for creating an account$")
	public void i_entered_details_for_creating_an_account() {

	}

}
