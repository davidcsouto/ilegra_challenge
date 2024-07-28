package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = "classpath:blogAgi",
        tags = "@postAgibank",
        plugin = {"json:target/cucumber-report/cucumber.json"}
)

public class Runner extends RunnerWeb {

}
