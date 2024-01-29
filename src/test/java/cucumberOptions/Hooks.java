package cucumberOptions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import commons.GlobalConstants;
//import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    // Run for many thread
    private static WebDriver driver;
//    private static final Logger log = Logger.getLogger(Hooks.class.getName());

//    @Before // synchronized = handle đồng bộ
    public synchronized static WebDriver openAndQuitBrowser() {
        // Run by Maven command line
        String browser = System.getProperty("BROWSER");
        System.out.println("1- Browser name run by command line = " + driver);

        // Check driver đã được khởi tạo hay chưa?
        if (driver == null) {
            System.out.println("2- Browser name run by command line = " + driver);
            // Happy path case
            try {
                // Kiem tra BROWSER = null -> gan = chrome/ firefox (browser default for project)
                if (browser == null) {
                    // Get browser name from Environment Variable in OS
                    browser = System.getenv("BROWSER");
                    if (browser == null) {
                        // Set default browser
                        browser = "firefox";
                    }
                }

                switch (browser) {
                    case "chrome":

                        driver = new ChromeDriver();
                        break;

                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    case "ie":
                        driver = new InternetExplorerDriver();
                        break;
                    default:

                        driver = new ChromeDriver();
                        break;
                }
                // Browser crash/ stop
            } catch (UnreachableBrowserException e) {
                driver = new ChromeDriver();
                // Driver crash
            } catch (WebDriverException e) {
                driver = new ChromeDriver();
            }
            // Code này luôn luôn được chạy dù pass hay fail
            finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }

            driver.get(GlobalConstants.TEST_ENV);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            log.info("------------- Started the browser -------------");
        }
        return driver;
    }

    public static void close() {
        try {
            if (driver != null) {
                openAndQuitBrowser().quit();
//                log.info("------------- Closed the browser -------------");
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("Can not close the browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }

}