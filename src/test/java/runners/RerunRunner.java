package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		publish = true,
		features = 	"@target/failed_scenarios.txt",
		glue = {"stepDef"},
		dryRun=false,
		monochrome=true,
		//plugin = {"pretty"}
		plugin = {"pretty",
				//"usage:target/reports/usageReport",
				//"json:target/reports/jsonReport.json",
				//"junit:target/reports/junitReport.xml",
				"html:target/reports/htmlReport.html",
				"rerun:target/failed_scenarios.txt"
			//	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"	
		}
		)
public class RerunRunner {

}
