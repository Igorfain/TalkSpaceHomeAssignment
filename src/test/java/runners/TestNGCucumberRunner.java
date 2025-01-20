package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = {"stepdefinitions", "utils"}, // Include the Hooks package
        plugin = {"pretty", "html:target/cucumber.html"}
)

public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

}
