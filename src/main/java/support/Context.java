package support;

import org.openqa.selenium.WebDriver;

public class Context {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static final ThreadLocal<PageSupport> webSupport = new ThreadLocal<>();

    public static void setup(){
        DriverManager.setupClass();
        DriverManager.setupDriver();
        webDriver.set(DriverManager.driver);
        webSupport.set(new PageSupport(webDriver.get()));
    }

    public static WebDriver driver(){
        return webDriver.get();
    }

    public static PageSupport webSupport(){
        return webSupport.get();
    }

    public static void closeWebDriver(){
        webDriver.get().close();
        webDriver.get().quit();
        webDriver.remove();
    }
}
