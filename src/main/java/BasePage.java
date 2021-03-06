import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static setup.DriverSetup.getDriver;

public abstract class BasePage {
    protected WebDriver driver;
    public static final String BASE_URL="https://picsart.com";

    public BasePage() {
        this.driver = getDriver();
    }

    public abstract String getUrl();

    public void open(String url) {
        System.out.println("Opening url -> " + url);
        driver.get(url);
    }

    public WebElement find(By location) {
        System.out.println("Finding element -> " + location.toString());
        return driver.findElement(location);
    }

    public void type(By location, String text) {
        type(find(location), text);
    }

    public void type(WebElement element, String text) {
        System.out.println("Typing " + text +" to field  -> " + element.toString());
        element.sendKeys(text);
    }

    public void click(By location) {
        System.out.println("Clicking on element -> " + location.toString());
        click(find(location));
    }

    public void click(WebElement element) {
        element.click();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void clickAndOpenNewTab(By location) {
        clickActions(find((location)));
        System.out.println("Clicking on element -> " + location.toString());
        List<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowHandles.get(windowHandles.size() - 1));
    }

    protected void clickActions(WebElement element) {
        new WebDriverWait(getDriver(), 2).until(ExpectedConditions.visibilityOf(element));
        new WebDriverWait(getDriver(), 2).until(ExpectedConditions.elementToBeClickable(element));
        new Actions(getDriver()).moveToElement(element).click().build().perform();
    }
}
