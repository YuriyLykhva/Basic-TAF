package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public static final String HOMEPAGE_URL = "https://magento.softwaretestingboard.com/";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }
}