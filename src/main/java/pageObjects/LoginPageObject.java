package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void inputEmailPhake(WebDriver driver, String email){
        waitForElementVisible(driver, LoginPageUI.FIND_EMAIL_INPUT1);
        sendKeyToElement(driver, LoginPageUI.FIND_EMAIL_INPUT1, email);
    }

    public void clickNexttoPage(WebDriver driver){
        waitForElementClickAble(driver,LoginPageUI.NEXT_BTN);
        clickToElement(driver, LoginPageUI.NEXT_BTN);
    }

    public void clickNoIDontWant(WebDriver driver){
        waitForElementClickAble(driver, LoginPageUI.NO_I_DONT_BTN);
        clickToElement(driver, LoginPageUI.NO_I_DONT_BTN);
    }

    public void inputEmailAndPassword(WebDriver driver, String email, String pass){
        waitForElementVisible(driver, LoginPageUI.EMAIL_INPUT);

        sendKeyToElement(driver, LoginPageUI.EMAIL_INPUT, email);

        waitForElementVisible(driver, LoginPageUI.PASSWORD_INPUT);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_INPUT, pass);
    }

    public void clickSignIn(WebDriver driver){
        waitForElementClickAble(driver, LoginPageUI.SIGN_IN_BTN);
        clickToElement(driver, LoginPageUI.SIGN_IN_BTN);
    }

}
