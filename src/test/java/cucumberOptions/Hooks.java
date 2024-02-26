package cucumberOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import commons.GlobalConstants;


public class Hooks {
    // Run for many thread
    private  WebDriver driver;
    private static final Logger log = Logger.getLogger(Hooks.class.getName());

//    @Before // synchronized = handle đồng bộ
    public  WebDriver openAndQuitBrowser() {
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
//            finally {
//                System.out.println("finally " );
//                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
//            }

            driver.get(GlobalConstants.TEST_ENV);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            log.info("------------- Started the browser -------------");
        }
//        Hooks.driver = driver;
        return driver;
    }



//    @After
    public void close() {
//        try {
//            log.info("-Close -" + driver );
//            if (driver != null) {
//
//                driver.quit();
//                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
//                log.info("------------- Closed the browser -------------");
//                log.info("-Close affter close -" + driver );
//            }
//        } catch (UnreachableBrowserException e) {
//            System.out.println("Can not close the browser");
//        }
        String cmd = "";
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            if (driverInstanceName.contains("chrome")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                } else {
                    cmd = "pkill chromedriver";
                }
            } else if (driverInstanceName.contains("internetexplorer")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driverInstanceName.contains("firefox")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                } else {
                    cmd = "pkill geckodriver";
                }
            } else if (driverInstanceName.contains("edge")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                } else {
                    cmd = "pkill msedgedriver";
                }
            } else if (driverInstanceName.contains("opera")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
                } else {
                    cmd = "pkill operadriver";
                }
            } else if (driverInstanceName.contains("safari")) {
                if (osName.contains("mac")) {
                    cmd = "pkill safaridriver";
                }
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    private  class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }

}