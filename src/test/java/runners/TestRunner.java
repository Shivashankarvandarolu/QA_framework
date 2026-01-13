package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions

(features = "src/test/resources/features", // Path to your .feature files
		glue = { "stepdefinitions", "base" },

		plugin = { "pretty", // Console output
				"html:target/cucumber-reports/cucumber.html", // HTML report
				"json:target/cucumber-reports/cucumber.json", // JSON report
				"junit:target/cucumber-reports/cucumber.xml" // JUnit XML report
		}, monochrome = true, // Cleaner console output
		tags = "@smoke" // Run scenarios with @smoke tag

)

public class TestRunner extends AbstractTestNGCucumberTests {
	// Enables parallel execution of scenarios with TestNG
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}