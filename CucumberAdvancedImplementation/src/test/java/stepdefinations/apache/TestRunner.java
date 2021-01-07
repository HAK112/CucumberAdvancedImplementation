package stepdefinations.apache;

import io.cucumber.testng.AbstractTestNGCucumberTests;


@io.cucumber.testng.CucumberOptions(
		features="src/test/resources/Features/Apache",
		glue= {"stepdefinations/apache"},
		monochrome=true,
		plugin= {"pretty", 
				"html:target/HtmlReports.html",
				"json:target/cucumber.json",
				"junit:target/junitReports.xml",
				"rerun:target/cucumber-reports/rerun.txt"
				},
		dryRun = true
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
