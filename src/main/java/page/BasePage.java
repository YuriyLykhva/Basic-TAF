package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected WebDriver driver;
    public static final int WAIT_TIMEOUT_SECONDS = 10;

    protected abstract BasePage openPage();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }
}
