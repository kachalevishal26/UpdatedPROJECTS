package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(		
		features ="src\\test\\resources\\features",
		glue = {"stepdefinitions","hooks"},
		monochrome = true,
		tags="@title or @accountsFeatures", 
        plugin = {"pretty",
            "html:target/MyReports/report.html",
            "json:target/MyReports/report.json",
            "junit:target/MyReports/report.xml",
            "rerun:target/rerunfile.txt",
            },
        publish=true,
        dryRun=false 
        )
public class TestRunner {

}
