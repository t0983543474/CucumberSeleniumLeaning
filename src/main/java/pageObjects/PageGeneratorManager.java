package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPageObject;

public class PageGeneratorManager {
    public static LoginPageObject loginPageObject(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static LandingPageObject landingPageObject(WebDriver driver){
        return new LandingPageObject(driver);
    }
}
