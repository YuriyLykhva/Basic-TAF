import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

//    @AfterMethod
//    public void clearCookie() {
//        driver.manage().deleteAllCookies();
//    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }
}
