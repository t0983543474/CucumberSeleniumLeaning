package cucumberOptions;

import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import managers.FileReaderManager;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepsDefinations",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/TestRunnerCategoryCMS.html",
                "json:target/cucumber-reports/TestRunnerCategoryCMS.json"
        },
        monochrome = true,
        tags = "@No-param"
)
public class RunCucumberTests  {
//    @AfterClass
//    public static void writeExtentReport() {
//        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
//    }
}