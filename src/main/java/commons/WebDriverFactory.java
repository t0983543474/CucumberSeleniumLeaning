package commons;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static synchronized void setDriver(String browser) {

        switch (browser) {
            case "chrome":
                driver = ThreadLocal.withInitial(() -> {

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
