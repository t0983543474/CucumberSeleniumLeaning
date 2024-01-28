package stepsDefinations;

import cucumberOptions.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.LandingPageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageUI.LoginPageUI;

public class LandingPageStep {
    WebDriver driver;
    LandingPageObject landingPage ;

    public LandingPageStep(){
        driver = Hooks.openAndQuitBrowser();
        landingPage = PageGeneratorManager.landingPageObject(driver);
    }

    @Given("I go to login page")
    public void i_go_to_login_page() {

        landingPage.clickIconToLoginPage();

    }


}
