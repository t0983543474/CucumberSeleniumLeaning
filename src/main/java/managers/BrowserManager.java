package managers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserManager {
    public static WebDriver doBrowserSetup(String browserName) {

        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("chrome")) {
            //steup chrome browser


            //initialize driver for chrome
            driver = new ChromeDriver();

            //maximize window
            driver.manage().window().maximize();

            //add implicit timeout
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }
        return driver;
    }

}