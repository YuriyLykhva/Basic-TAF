import util.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.SignInPage;
import util.UserFactory;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithUserViaModel() {
        User testUser = UserFactory.createUser();
        String loggedInUserName = new SignInPage(driver)
                .openPage()
                .loginViaModel(testUser)
                .getLoggedInUserName();

                Assert.assertEquals(loggedInUserName, testUser.getUserName());
    }

    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new String[][]{
                {"tqwretqwe@email.com", "4Zmw!MjXZrFWPN3", "Tr Hy"},
                {"tqwretqwe@email.com", "4Zmw!MjXZrFWPN3", "Welcome, Tr Hy!"},
        };
    }

    @Test(dataProvider = "credentials")
    public void loginWithUserFromDataProvider(String email, String password, String userName) {
        String loggedInUserName =
                new SignInPage(driver)
                        .openPage()
                        .loginViaCredentials(email, password)
                        .getLoggedInUserName();

        Assert.assertEquals(loggedInUserName, userName);
    }
}