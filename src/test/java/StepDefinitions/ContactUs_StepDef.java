package stepDefinitions;

import java.time.Duration;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUs_StepDef {

	WebDriver driver = DriverFactory.getDriver();
	ContactUsPage cu = new ContactUsPage(driver);
	HomePage home = new HomePage(driver);
	private static final Logger logger = LogManager.getLogger(ContactUs_StepDef.class);

	@When("^I enter the following details in the contact form$")
	public void i_enter_contact_form_details(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		Assert.assertTrue(cu.name_txtbox.isDisplayed() && cu.name_txtbox.isEnabled());
		Assert.assertTrue(cu.email_txtbox.isDisplayed() && cu.email_txtbox.isEnabled());

		Assert.assertTrue(cu.message_txtbox.isDisplayed() && cu.message_txtbox.isEnabled());

		Assert.assertTrue(cu.subject_txtbox.isDisplayed() && cu.subject_txtbox.isEnabled());

		cu.name_txtbox.sendKeys(data.get("name"));
		cu.email_txtbox.sendKeys(data.get("email"));
		cu.subject_txtbox.sendKeys(data.get("subject"));
		cu.message_txtbox.sendKeys(data.get("message"));

	}

	@And("^I upload the file '(.+)'$")
	public void i_upload_the_file(String filePath) {
		// cu.upload_fileBtn.click();
		Assert.assertTrue(cu.upload_fileBtn.isDisplayed() && cu.upload_fileBtn.isEnabled());
		cu.upload_fileBtn.sendKeys(filePath);
	}

	@And("^I click on the submit button$")
	public void i_click_on_submit_button() {
		Assert.assertTrue(cu.submitBtn.isDisplayed() && cu.submitBtn.isEnabled());
		cu.submitBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Alert alert = driver.switchTo().alert();
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
		} catch (Exception e) {
			logger.info("Alert is not displayed");
		}
	}

	@Then("^I should see the success message (.+)$")
	public void i_should_see_success_message(String expectedMessage) {
		boolean isalertSuccessMessageDisplyaed = cu.alertSuccessmessage.isDisplayed();
		Assert.assertTrue(isalertSuccessMessageDisplyaed, "Success Message is not showing");
		// Assert.assertEquals(cu.alertSuccessmessage.getText(), expectedMessage);
		if (cu.alertSuccessmessage.getText().equals(expectedMessage)) {
			System.out.println("matched");
		} else {
			System.out.println("Not Matching");
		}

	}

	@And("^I click on the Home button$")
	public void i_click_on_home_button() throws InterruptedException {
		Assert.assertTrue(cu.homeBtn.isDisplayed());
		cu.homeBtn.click();
		Thread.sleep(2500);
	}

	@Then("^I should be navigated to the Home page$")
	public void i_should_be_navigated_to_home_page() {
		String expURL = "https://automationexercise.com/";
		Assert.assertEquals(driver.getCurrentUrl(), expURL);
	}

	@And("^I navigate to the contactus page$")
	public void I_navigate_to_the_contactus_page() {
		Assert.assertTrue(home.contact_btn.isDisplayed() && home.contact_btn.isEnabled());
		home.contact_btn.click();
	}
}
