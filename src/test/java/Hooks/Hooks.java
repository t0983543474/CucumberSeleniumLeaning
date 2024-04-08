package Hooks;

import java.util.concurrent.TimeUnit;

import commons.WebDriverFactory;


import commons.GlobalConstants;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
    // Run for many thread
//    private static WebDriver driver;
//    private static final Logger log = Logger.getLogger(Hooks.class.getName());
//    protected static
//    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    @Before
    public void Setup(){
        WebDriverFactory.setDriver("chrome");
        WebDriverFactory.getDriver().get(GlobalConstants.TEST_ENV);
        //set driver
//        threadLocalDriver.set(driver);

        System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());
        System.out.println("Before Test Thread Name: "+Thread.currentThread().getName());

        //get URL
//        driver.get(GlobalConstants.TEST_ENV);
//        getDriver().get(GlobalConstants.TEST_ENV);
    }

    @After
    public void after(){
        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
        WebDriverFactory.closeDriver();
    }

    //get thread-safe driver
//    public static WebDriver getDriver(){
////        return threadLocalDriver.get();
//    }
//    @After
    public void tearDown(){
//        getDriver().quit();

        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());

//        threadLocalDriver.remove();
    }
   // @Before // synchronized = handle đồng bộ
//    public synchronized static WebDriver openAndQuitBrowser() {
//        // Run by Maven command line
//        String browser = System.getProperty("BROWSER");
//        System.out.println("Browser name run by command line = " + browser);
//
//        // Check driver đã được khởi tạo hay chưa?
//        if (driver == null) {
//
//            // Happy path case
//            try {
//                // Kiem tra BROWSER = null -> gan = chrome/ firefox (browser default for project)
//                if (browser == null) {
//                    // Get browser name from Environment Variable in OS
//                    browser = System.getenv("BROWSER");
//                    if (browser == null) {
//                        // Set default browser
//                        browser = "chrome";
//                    }
//                }
//
//                switch (browser) {
//                    case "chrome":
//                        WebDriverManager.chromedriver().setup();
//                        driver = new ChromeDriver();
//                        break;
//
//                    case "firefox":
//                        WebDriverManager.firefoxdriver().setup();
////                        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
////                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
//                        driver = new FirefoxDriver();
//                        break;
//
//                    default:
//                        WebDriverManager.chromedriver().setup();
//                        driver = new ChromeDriver();
//                        break;
//                }
//                // Browser crash/ stop
//            } catch (UnreachableBrowserException e) {
//                driver = new ChromeDriver();
//                // Driver crash
//            } catch (WebDriverException e) {
//                driver = new ChromeDriver();
//            }
//            // Code này luôn luôn được chạy dù pass hay fail
//            finally {
//                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
//            }
//
//            driver.get(GlobalConstants.TEST_ENV);
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            log.info("------------- Started the browser -------------");
//        }
//        return driver;
//    }
//
//    public static void close() {
//        try {
//            if (driver != null) {
//                openAndQuitBrowser().quit();
//                log.info("------------- Closed the browser -------------");
//            }
//        } catch (UnreachableBrowserException e) {
//            System.out.println("Can not close the browser");
//        }
//    }

//    private static class BrowserCleanup implements Runnable {
//        @Override
//        public void run() {
//            close();
//        }
//    }
}