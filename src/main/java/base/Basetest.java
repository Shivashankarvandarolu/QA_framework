package base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class Basetest {

	protected WebDriver driver;

	@Before
	public void setUp() {
		String browser = ConfigReader.getProperty("browser");
		driver = DriverFactory.initDriver(browser);
	}

	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
