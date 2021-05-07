import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    public static ChromeDriver chromeDriver = null;

    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","/Users/nubar/Downloads/chromedriver");
        chromeDriver = new ChromeDriver();
        //chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get("http://picsartstage2.com/");
        WebElement loginBut =  chromeDriver.findElement(By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']"));
        loginBut.click();
        new WebDriverWait(chromeDriver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        login("Nubar", "nubar123");

    }

    public static void login(String name, String password){
        chromeDriver.findElement(By.name("username")).sendKeys(name);
        chromeDriver.findElement(By.name("password")).sendKeys(password);
    }
}
