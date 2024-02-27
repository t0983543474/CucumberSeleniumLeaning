package stepsDefinations;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.LandingPageObject;
import pageObjects.PageGeneratorManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPageObject;

import java.util.List;
import java.util.Map;

public class LoginPageStep {

    WebDriver driver;
    LoginPageObject loginPage;
    LandingPageObject landingPage;
    TestContext testContext;

    public LoginPageStep(TestContext context){
        driver = new Hooks().openAndQuitBrowser();
        testContext = context;
        testContext.scenarioContext.setContext(Context.DRIVE, driver);
        loginPage = PageGeneratorManager.loginPageObject(driver);
        landingPage = PageGeneratorManager.landingPageObject(driver);
    }


    @When("I enter my email and then click next page")
    public void i_enter_my_email_and_then_click_next_page() {
        loginPage.inputEmailPhake(driver,"trang@gmail.com" );
        testContext.scenarioContext.setContext(Context.LOGIN_URL,"trang@gmail.com" );
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
        loginPage.inputEmailPhake(driver,email );
        loginPage.clickNexttoPage(driver);

    }
    @When("I enter email {string} and password is {string}")
    public void i_enter_email_and_password_is(String email, String password) {

        loginPage.inputEmailAndPassword(driver, email, password);

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

        loginPage.inputEmailAndPassword(driver, loginInfor.get(0).get("email"), loginInfor.get(0).get("password"));


//        for(Map<String, String> login : loginInfor){
//
//        }

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
        System.out.println("Tets Context example " + testContext.scenarioContext.getContext(Context.LOGIN_URL));
        Assert.assertTrue(landingPage.isLoggined());

    }

    @After
    public void closeBrowser(){
//        log.info("OS name = " + driver);
        System.out.println("OS name = Login " + driver);
        if (driver != null){
            driver.quit();
        }
    }




}
