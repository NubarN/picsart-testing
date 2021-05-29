package user;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import pageObject.LoginPage;

import static config.DriverSetup.getDriver;
import static org.testng.Assert.assertTrue;

public class VerifiedUserTest {

    protected void login(){
        LoginPage loginPage = new LoginPage();
        Cookie cookie = new Cookie("user_key", "d02e1fab-8630-4f25-a106-9969ab867447");
        getDriver().manage().addCookie(cookie);
        getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));
        getDriver().navigate().refresh();
        assertTrue(loginPage.isUserLoggedIn(), "User is not logged in!");
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}