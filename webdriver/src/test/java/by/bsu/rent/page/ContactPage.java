package by.bsu.rent.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final String CONTACTPAGE_URL =
            "https://www.economycarrentals.com/en-us/information/contact";
    private final WebDriverWait wait;

    public ContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    public ContactPage openPage() {
        driver.navigate().to(CONTACTPAGE_URL);
        LOGGER.info("Contact page opened");
        return this;
    }

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/section[1]/div[2]/div[1]/button")
    private WebElement notYetRented;
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/section[1]/div[2]/div[2]/button")
    private WebElement futureRented;
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/section[1]/div[2]/div[3]/button")
    private WebElement runningRented;
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/section[1]/div[2]/div[4]/button")
    private WebElement endedRented;

    public boolean isNotYetRentedVisible() {
        return notYetRented.isDisplayed();
    }

    public boolean isFutureRentedVisible() {
        return futureRented.isDisplayed();
    }

    public boolean isRunningRentedVisible() {
        return runningRented.isDisplayed();
    }

    public boolean isEndedRentedVisible() {
        return endedRented.isDisplayed();
    }
}
