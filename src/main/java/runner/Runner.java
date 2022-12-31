package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src\\test\\java"},
        glue = {"stepDefinitions"},
        dryRun=false
)
public class Runner extends AbstractTestNGCucumberTests {
}
