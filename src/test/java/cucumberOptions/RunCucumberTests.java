package cucumberOptions;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepsDefinations",
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
      //  tags = "@DataTestDrive"
)
public class RunCucumberTests  {

}