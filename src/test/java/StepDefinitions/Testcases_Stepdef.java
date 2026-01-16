package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class Testcases_Stepdef {
	WebDriver driver = DriverFactory.getDriver();
	HomePage home = new HomePage(driver);

	@And("^I navigate to the testcases page$")
	public void I_navigate_to_the_testcases_page() throws InterruptedException {
		Assert.assertTrue(home.testcases_Btn.isDisplayed());
		home.testcases_Btn.click();
		Thread.sleep(2000);
	}

	@Then("^I should see all the test cases$")
	public void IshouldSeeallthetestcases() {

		List<WebElement> lists = driver.findElements(By.xpath("//h4[@class='panel-title']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (WebElement a : lists) {
			js.executeScript("arguments[0].scrollIntoView(true);", a);
			String testcase = a.getText().toString();
			System.out.println(testcase);
			js.executeScript("arguments[0].click()", a);
//				//a.click();
//				List<WebElement> steps = a.findElements(By.xpath("//div[@class='panel-collapse in']//ul[1]//li"));
//				for (WebElement b : steps) {
//					String step = b.getText();
//					System.out.println(step);
//				}

		}

	}
}
