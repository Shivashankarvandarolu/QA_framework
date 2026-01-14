package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = {
        "src/test/resources/features/login.feature",
        "src/test/resources/features/signup.feature"
    },
    glue = "stepDefinitions",
    monochrome = true
)
public class TestRunnerLoginandSignup extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
