package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith; 
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(glue = {"stepDefinitions"},
        plugin = {"pretty","junit:target/cucumber-reports/Cucumber.xml",
                "json:target/cucumber.json"},
        monochrome = false,
        features = {"src/test/resources/features"}
)
public class TestRunner {
}
