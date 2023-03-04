package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"@target/rerunfile.txt"},
		glue = {"StepDefinition","Hooks"},
		monochrome = true,
	    tags="", 
        plugin = {"pretty",
            "html:target/Reports/report.html",
            "json:target/Reports/report.json",
            "junit:target/Reports/report.xml",
            "rerun:target/rerunfile.txt",
            },
        publish=true
        )


public class FailedScenarioTestRunner {

}
