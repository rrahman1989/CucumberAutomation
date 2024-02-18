import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
features = {"C:/Users/rahma/OneDrive/Desktop/New_Eclipse_Workspace/cucumber-zephyr-project/src/test/resources/features/example.feature:8"},
plugin = {"json:target/cucumber-reports/1.json"},
monochrome = false,
glue = { "com.cucumber" })
public class ExampleIT {
}
