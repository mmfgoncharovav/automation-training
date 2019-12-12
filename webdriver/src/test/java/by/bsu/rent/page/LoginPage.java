package by.bsu.rent.page;

import by.bsu.rent.model.PageError;
import by.bsu.rent.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String LOGINPAGE_URL =
            "https://www.economycarrentals.com/en-us/customer/member";
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        LOGGER.info("Created LoginPage entity");
    }

    public LoginPage openPage() {
        driver.navigate().to(LOGINPAGE_URL);
        LOGGER.info("Login page opened");
        return this;
    }

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div[1]/div[2]/form/div[1]/input")
    WebElement emailInput;
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div[1]/div[2]/form/div[2]/input")
    WebElement passwordInput;
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div[1]/div[2]/form/div[4]/button")
    WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"recoveryMessage\"]")
    WebElement errorMessage;
    @FindBy(xpath = "//*[@id=\"recoveryEmail\"]")
    WebElement recoveryEmailInput;
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div[1]/div[2]/form/a")
    WebElement recoveryLink;
    @FindBy(xpath = "//*[@id=\"recoverySend\"]")
    WebElement recoverySendButton;

    public void login(User user) {
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
        LOGGER.info("User tried to log in");
    }

    public void recoverPassword(User user) {

        recoveryLink.click();
        wait.until(ExpectedConditions.elementToBeClickable(recoveryEmailInput));
        recoveryEmailInput.sendKeys(user.getEmail());
        recoverySendButton.click();
        LOGGER.info("User tried to recover password");
    }

    public boolean checkErrorMessage(PageError error) {
        if(errorMessage.isDisplayed()) {
            LOGGER.debug("error message element is displayed");
            return true;
        }
        return false;
    }
}
