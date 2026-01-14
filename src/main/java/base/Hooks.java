package base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void setUp() {
		String browser = System.getProperty("browser", "chrome");
		WebDriver driver = DriverFactory.initDriver(browser);
		DriverFactory.setDriver(driver);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		DriverFactory.quitDriver();
		// driver.close();
	}
}