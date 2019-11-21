package by.bsu.rent.page;

import by.bsu.rent.deprecated.LoginPage;
import by.bsu.rent.model.Language;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageGerman extends AbstractPage {
    private static final Logger LOGGER =
            LogManager.getRootLogger();
    private static final String LOGINPAGE_URL =
            "https://www.economycarrentals.com/de-de";
    private final WebDriverWait wait;

    public HomePageGerman(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }
    public HomePageGerman openPage() {
        driver.navigate().to(LOGINPAGE_URL);
        LOGGER.info("German home page opened");
        return this;
    }
    @FindBy(xpath = "//*[@id=\"language\"]")
    private WebElement languageSelector;

    public String checkCurrentLanguage() {
        Select dropdown = new Select(languageSelector);
        WebElement option = dropdown.getFirstSelectedOption();
        String text = option.getText();
        return text;
    }
}
