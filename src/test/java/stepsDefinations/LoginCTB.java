package stepsDefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginCTB {

    WebDriver driver;

    @Given("I am on landing page")
    public void i_am_on_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get("https://ctb-test2-hmid.hyundaisvc.com/id/en/landing");

    }
    @When("I go to login page")
    public void i_go_to_login_page() {

        driver.findElement(By.cssSelector("span.mypage img")).click();

    }
    @When("I enter my email and then click next page")
    public void i_enter_my_email_and_then_click_next_page() {
        driver.findElement(By.cssSelector("span.form-input input")).sendKeys("trang@gmail.com");
        driver.findElement(By.xpath("//button//span[text()='Next']")).click();

    }
    @When("I choose No i dont")
    public void i_choose_no_i_dont() {
        driver.findElement(By.cssSelector(".btn-negative-wrap a.btn-create-acc span")).click();

    }
    @When("I enter email and password")
    public void i_enter_email_and_password() {
        driver.findElement(By.cssSelector("ctb-input[formcontrolname='email'] input")).clear();
        driver.findElement(By.cssSelector("ctb-input[formcontrolname='email'] input")).sendKeys("trang113@yopmail.com");

        driver.findElement(By.cssSelector("ctb-input[formcontrolname='password'] input")).sendKeys("1234qwer");


    }
    @When("I sign on")
    public void i_sign_on() {
        driver.findElement(By.xpath("//button[@type='submit']//span[text()= 'Sign In']")).click();
    }
    @Then("Go to landing page")
    public void go_to_landing_page() {
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Our Models']")).isDisplayed());
    }
    @Then("Display My Gabage")
    public void display_my_gabage() {
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='mypage']//img[contains(@src,'ico-login-dark')]")).isDisplayed());
        driver.quit();
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
