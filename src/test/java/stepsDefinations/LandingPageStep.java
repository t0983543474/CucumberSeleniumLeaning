package stepsDefinations;

import cucumberOptions.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.LandingPageObject;
import pageObjects.PageGeneratorManager;

public class LandingPageStep {
    WebDriver driver;
    LandingPageObject landingPage ;

    public LandingPageStep(){
        driver = new Hooks().openAndQuitBrowser();
        landingPage = PageGeneratorManager.landingPageObject(driver);
    }

    @Given("Open Request TestDrive popup")
    public void open_request_test_drive_popup() {

    }

    @When("Select a model")
    public void select_a_model() {

    }

    @When("Select Dealer and Consultant")
    public void select_dealer_and_consultant() {

    }

    @When("Select Preffered DateTime")
    public void select_preffered_date_time() {

    }

    @When("Select Customer Information")
    public void select_customer_information() {

    }

    @When("Check Privacy and Confirm")
    public void check_privacy_and_confirm() {

    }

    @Then("Display Request a Test Drive Completed popup and then close")
    public void display_request_a_test_drive_completed_popup_and_then_close() {

    }

    @Then("Open Track your Inquiry Booking button with trang.le@inventis.vn to verify")
    public void open_track_your_inquiry_booking_button_with_trang_le_inventis_vn_to_verify() {

    }

    @Then("Verify just new item")
    public void verify_just_new_item() {

    }

//
//    @Given("Click Track your Inquiry Booking button")
//    public void click_track_your_inquiry_booking_button() {
//        landingPage.clickToOpenTrackYourInquiryPopup();
//
//    }
//    @Given("Input email {string} and sent it")
//    public void input_email_and_sent_it(String email) {
////        Assert.assertTrue();
//        landingPage.inputTrackingPopup(email);
//        Assert.assertTrue(false);
//    }
//    @Given("Input OTP")
//    public void input_otp() {
////        driver.quit();
//        // Write code here that turns the phrase above into concrete actions
////        throw new io.cucumber.java.PendingException();
//    }
//
//    @After
//    public void closeBrowser(){
////        log.info("OS name = " + driver);
//        System.out.println("OS name Landing page = " + driver);
//        if (driver != null){
//            driver.quit();
//        }
//    }


}
