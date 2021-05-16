import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getDriver;

public class TheFirstTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "/Users/nubar/Downloads/chromedriver");
//        driver = new ChromeDriver();
    }

//    @AfterMethod
//    public void tearDown() {
//        getDriver().quit();
//    }
    public void test2(){}
    @Test
    public void fistTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginButton();
        loginPage.typeUsername("nubarnalbandian");
        loginPage.typePassword("nubar123");
        loginPage.clickSignInButton();

        assertTrue(loginPage.isUserLoggedIn(), "User eas not logged in!");
    }

    @Test
    public void loginWithKey() {
        LoginPage loginPage = new LoginPage();

        Cookie cookie = new Cookie("user_key", "d02e1fab-8630-4f25-a106-9969ab867447");
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();

        assertTrue(loginPage.isUserLoggedIn(), "User eas not logged in!");
    }
}
