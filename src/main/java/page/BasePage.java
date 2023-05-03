package page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected static WebDriver driver;
    public static final int WAIT_TIMEOUT_SECONDS = 10;

    protected abstract BasePage openPage();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
