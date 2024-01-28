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

}
