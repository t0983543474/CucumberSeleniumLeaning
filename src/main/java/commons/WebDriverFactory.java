package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static synchronized void setDriver(String browser) {

        switch (browser) {
            case "chrome":
                driver = ThreadLocal.withInitial(() -> {
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                });
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
    }

    public static synchronized WebDriver getDriver(){
        return driver.get();
    }

    public static void closeDriver(){

        System.out.println("closeDriver: "+driver );

        driver.get().quit();
        driver.remove();
    }
}
