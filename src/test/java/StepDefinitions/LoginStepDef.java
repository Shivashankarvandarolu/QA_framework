package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.DriverFactory;
import base.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUp_Loginpage;
import pages.SignupPage;

public class LoginStepDef {

	WebDriver driver = DriverFactory.getDriver();

	// private WebDriver driver;
	private LoginPage login = new LoginPage();
	private SignUp_Loginpage slpage = new SignUp_Loginpage(DriverFactory.getDriver());
	private HomePage home = new HomePage(DriverFactory.getDriver());
	private SignupPage spage = new SignupPage(DriverFactory.getDriver());
	private static final Logger logger = LogManager.getLogger(LoginStepDef.class);

	public LoginStepDef() {
		this.driver = DriverFactory.getDriver();
		// ✅ fetch driver after Hooks has run

	}

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
	public void i_entered_details_for_creating_an_account(DataTable datatable) {

		Map<String, String> data = datatable.asMap(String.class, String.class);

		// Title selection
		if (data.get("title").equalsIgnoreCase("Mr")) {
			spage.mrRadioBtn.click();
		} else {
			spage.mrsRadioBtn.click();
		}

		// Password
		spage.passwordTxtbox.sendKeys(data.get("password"));

		// Date of Birth
		new Select(spage.day_dropdown).selectByValue(data.get("day"));
		new Select(spage.month_dropdown).selectByVisibleText(data.get("month"));
		new Select(spage.year_dropdown).selectByVisibleText(data.get("year"));

		// Checkboxes
		if (!spage.signUpForNewsLetter_Checkbox.isSelected()) {
			spage.signUpForNewsLetter_Checkbox.click();
		}

		if (!spage.Receivespecialoffer_checkbox.isSelected()) {
			spage.Receivespecialoffer_checkbox.click();
		}

		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				spage.firstName_txtbox);

		// Address Details
		spage.firstName_txtbox.sendKeys(data.get("firstName"));
		spage.lastName_txtbox.sendKeys(data.get("lastName"));
		spage.company_txtbox.sendKeys(data.get("company"));
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				spage.address1_txtbox);
		spage.address1_txtbox.sendKeys(data.get("address1"));
		spage.address2_txtbox.sendKeys(data.get("address2"));

		// Country
		new Select(spage.countryDropdown).selectByVisibleText(data.get("country"));

		// State / City / Zip / Mobile
		spage.state_txtbox.sendKeys(data.get("state"));
		spage.city_txtbox.sendKeys(data.get("city"));
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				spage.zipcode_txtbox);
		spage.zipcode_txtbox.sendKeys(data.get("zipcode"));
		spage.mobile_number_txtbox.sendKeys(data.get("mobile"));

		spage.createAccount_button.click();
	}

	@Then("^verify the account creation is completed or not$")
	public void verify_the_account_creation_is_completed_or_not() throws InterruptedException {
		Assert.assertTrue(spage.accountCreated_txt.isDisplayed());
		Assert.assertEquals("ACCOUNT CREATED!", spage.accountCreated_txt.getText(), "Not Matching");
		Assert.assertTrue(spage.congratulation_txt.isDisplayed(), "Congratulation message is not showing");
		Assert.assertTrue(spage.continueBtn.isDisplayed());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", spage.continueBtn);
		// spage.continueBtn.click();
		Thread.sleep(1000);
	}

	@And("^I should be able to see the name '(.+)'$")
	public void i_should_be_able_to_see_the_name(String expectedName) throws InterruptedException {

		Thread.sleep(2000);

		Assert.assertTrue(spage.logoutBtn.isDisplayed());

		Assert.assertTrue(spage.deleteaccount_Btn.isDisplayed());

		Assert.assertTrue(spage.userName.isDisplayed());

		if (spage.userName.getText().contains(expectedName)) {
			logger.info("Matching");
		} else {
			logger.info("Not Matching");
		}

	}

	@And("^I enter password '(.+)'$")
	public void I_enter_password(String password) {
		Assert.assertTrue(slpage.login_password.isDisplayed() && slpage.login_password.isEnabled());
		slpage.login_password.sendKeys(password);
	}

	@Then("^I click on the login button$")
	public void I_click_on_the_login_button() {
		Assert.assertTrue(slpage.loginBtn.isDisplayed() && slpage.loginBtn.isEnabled());
		slpage.loginBtn.click();
	}

	@And("^I enter email '(.+)' in log in email address$")
	public void enterEmailinLoginInemailtextbox(String email) {
		Assert.assertTrue(slpage.login_email.isDisplayed() && slpage.login_email.isEnabled());
		slpage.login_email.sendKeys(email);
	}

	@When("^I log out of the application$")
	public void i_log_out_of_the_application() {
		Assert.assertTrue(spage.logoutBtn.isDisplayed() && spage.logoutBtn.isEnabled());
		spage.logoutBtn.click();
	}

	@Then("^I should see the Signup/Login page$")
	public void i_should_see_the_signup_login_page() {

		boolean isLoginVisible = slpage.loginToYourAccount_txt.isDisplayed();

		Assert.assertTrue(isLoginVisible, "Signup/Login page is not displayed");
	}

	@Then("I should see a login error validation message")
	public void i_should_see_login_error_message() {
		boolean validationMessageIsDisplayed = slpage.inValidEmail_password_validaiton_txt.isDisplayed();
		Assert.assertTrue(validationMessageIsDisplayed,
				"When User added Invalid password, the Validation message is not displayed");
	}

	@When("^I am on Login or Sign up Page$")
	public void i_am_on_login_or_signup_page() {

		String actURL = driver.getCurrentUrl();
		String expURL = "https://automationexercise.com/login";
		Assert.assertEquals(expURL, expURL);
	}

	@Then("^I should see a signup validation text message$")
	public void verify_signup_validation_text_message() {

		boolean signupvalidationMessageIsDisplayed = slpage.emailAlreadyExist_ValidationTxt.isDisplayed();
		Assert.assertTrue(signupvalidationMessageIsDisplayed,
				"When User trying to signup with existing email ID, Signup Validation message is not displayed");
	}
}
