import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditorPage extends BasePage {

    private String url = "/create/editor";
    private String queryUrl;
    private final By fitButton = By.cssSelector("[id = 'background-category']");

    public EditorPage() {
        open(getUrl());
    }

    public EditorPage(String url) {
        this.queryUrl = url;
        open(getUrl());
    }
    public EditorPage clickOnFitTab() {
        click(fitButton);
       // new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("id = 'background-category'")));
        return this;
    }

    @Override
    public String getUrl() {
        String query = queryUrl == null ? url : url + "?" + queryUrl;
        return BASE_URL.concat(query);
    }
}
