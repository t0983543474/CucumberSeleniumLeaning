package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.LandingPageUI;

public class LandingPageObject extends BasePage {

    WebDriver driver;

    public LandingPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickIconToLoginPage(){
        waitForElementInvisible(driver, LandingPageUI.OVERLAY);
        waitForElementClickAble(driver, LandingPageUI.LOGIN_ICON);
        clickToElement(driver, LandingPageUI.LOGIN_ICON);
    }

    public boolean isLoggined(){
        waitForElementVisible(driver, LandingPageUI.LOGINED_ICON);
        return isElementDisplay(driver,  LandingPageUI.LOGINED_ICON);
    }

    public boolean isLandingPage(){
        waitForElementVisible(driver, LandingPageUI.OURMODEL_TXT);
        return isElementDisplay(driver,  LandingPageUI.OURMODEL_TXT);
    }

    public void clickLogout(){
        waitForElementVisible(driver, LandingPageUI.LOGINED_ICON);
        clickToElement(driver, LandingPageUI.LOGINED_ICON);
        waitForElementVisible(driver, LandingPageUI.LOGOUT_BTN);
        clickToElement(driver, LandingPageUI.LOGOUT_BTN);
    }

    public void clickToOpenTrackYourInquiryPopup(){
        waitForElementInvisible(driver, LandingPageUI.OVERLAY);
        waitForElementVisible(driver, LandingPageUI.TRACKYOURINQUIRY_BTN);
        clickToElement(driver, LandingPageUI.TRACKYOURINQUIRY_BTN);
    }

    public void inputTrackingPopup(String email){
        waitForElementVisible(driver, LandingPageUI.EMAIL_INPUT);


    }

}
