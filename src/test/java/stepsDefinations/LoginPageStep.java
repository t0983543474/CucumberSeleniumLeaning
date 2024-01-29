package stepsDefinations;

import pageObjects.LandingPageObject;
import pageObjects.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPageObject;
import pageUI.LandingPageUI;
import pageUI.LoginPageUI;

import java.util.List;
import java.util.Map;

public class LoginPageStep {

    WebDriver driver;
    LoginPageObject loginPage;

    public LoginPageStep(){
        driver = Hooks.openAndQuitBrowser();
        loginPage = PageGeneratorManager.loginPageObject(driver);
    }


    @When("I enter my email and then click next page")
    public void i_enter_my_email_and_then_click_next_page() {
        loginPage.inputEmailPhake(driver,"trang@gmail.com" );
        loginPage.clickNexttoPage(driver);

    }

    @When("I choose No i dont")
    public void i_choose_no_i_dont() {
        loginPage.clickNoIDontWant(driver);
    }
    @When("I enter email and password")
    public void i_enter_email_and_password() {

        loginPage.inputEmailAndPassword(driver, "trang113@yopmail.com", "1234qwer");
    }
    @When("I sign on")
    public void i_sign_on() {

        loginPage.clickSignIn(driver);
    }



    @When("I enter my email {string} and then click next page")
    public void i_enter_my_email_and_then_click_next_page(String email) {
        driver.findElement(By.cssSelector("span.form-input input")).sendKeys(email);
        driver.findElement(By.xpath("//button//span[text()='Next']")).click();

    }
    @When("I enter email {string} and password is {string}")
    public void i_enter_email_and_password_is(String email, String password) {
        driver.findElement(By.cssSelector("ctb-input[formcontrolname='email'] input")).clear();
        driver.findElement(By.cssSelector("ctb-input[formcontrolname='email'] input")).sendKeys(email);

        driver.findElement(By.cssSelector("ctb-input[formcontrolname='password'] input")).sendKeys(password);

    }

    @When("I enter email new email and password")
    public void i_enter_email_new_email_and_password(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<Map<String, String>> loginInfor = dataTable.asMaps(String.class, String.class);

        driver.findElement(By.cssSelector("ctb-input[formcontrolname='email'] input")).clear();
        driver.findElement(By.cssSelector("ctb-input[formcontrolname='email'] input")).sendKeys(loginInfor.get(0).get("email"));

        driver.findElement(By.cssSelector("ctb-input[formcontrolname='password'] input")).sendKeys(loginInfor.get(0).get("password"));

//        for(Map<String, String> login : loginInfor){
//
//        }

    }

}
