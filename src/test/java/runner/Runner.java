package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({Search})
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"html:target/cucumber_report.html"},
		features="src/test/java/feature",
		glue="stepdefinitions",
		tags="@baby",
		monochrome=true)
public class Runner {

}
