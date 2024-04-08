package cucumberOptions;




import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import managers.FileReaderManager;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {
               "Hooks",  "stepsDefinations"
        },
        plugin = {
                "html:target/cucumber-reports/TestRunnerCategoryCMS.html",
                "json:target/cucumber-reports/TestRunnerCategoryCMS.json"
        },
        monochrome = true
//        tags={"@login","@tracking"}
    //    tags = "@No-param"
)
public class RunCucumberTests  {

}