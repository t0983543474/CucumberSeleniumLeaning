package stepsDefinations;

import cucumberOptions.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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

    @Then("Go to landing page")
    public void go_to_landing_page() {
        Assert.assertTrue(landingPage.isLandingPage());
    }
    @Then("Display My Gabage")
    public void display_my_gabage() {
        Assert.assertTrue(landingPage.isLoggined());
        driver.quit();
    }





}
