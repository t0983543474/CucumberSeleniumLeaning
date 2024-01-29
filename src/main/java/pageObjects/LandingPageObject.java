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
        waitForElementInvisible(driver, LandingPageUI.LOGINED_ICON);
        return isElementUnDisplay(driver,  LandingPageUI.LOGINED_ICON);
    }

    public boolean isLandingPage(){
        waitForElementInvisible(driver, LandingPageUI.OURMODEL_TXT);
        return isElementUnDisplay(driver,  LandingPageUI.OURMODEL_TXT);
    }

}
