package page;

import util.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaiterWrapperClass;

import static page.HomePage.HOMEPAGE_URL;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//div[@class='panel header']//a[contains(.,'Sign')]")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@name='login[username]']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@name='login[password]']")
    private WebElement userPasswordField;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SignInPage openPage() {
        driver.get(HOMEPAGE_URL);
        WaiterWrapperClass.waitForElement(driver, signInButton);
        signInButton.click();
        return this;
    }

    public MainPage loginViaModel(User user) {
        WaiterWrapperClass.waitForElement(driver, userEmailField);
        userEmailField.sendKeys(user.getUserEmail());
        userPasswordField.sendKeys(user.getPassword());
        userPasswordField.sendKeys(Keys.ENTER);
        return new MainPage(driver);
    }

    public MainPage loginViaCredentials(String email, String password) {
        WaiterWrapperClass.waitForElement(driver, userEmailField);
        userEmailField.sendKeys(email);
        userPasswordField.sendKeys(password);
        userPasswordField.sendKeys(Keys.ENTER);
        return new MainPage(driver);
    }
}
