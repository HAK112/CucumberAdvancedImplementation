package stepdefinations.background;

import io.cucumber.testng.AbstractTestNGCucumberTests;


@io.cucumber.testng.CucumberOptions(
		features="src/test/resources/Features/Background",
		glue= {"stepdefinations/background"},
		monochrome=true,
		plugin= {"pretty", 
				"html:target/HtmlReports.html",
				"json:target/cucumber.json",
				"junit:target/junitReports.xml",
				"rerun:target/cucumber-reports/rerun.txt"
				},
		dryRun = false
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
