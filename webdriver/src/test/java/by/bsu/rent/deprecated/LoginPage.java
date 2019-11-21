package by.bsu.rent.deprecated;

import by.bsu.rent.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends AbstractPage {
    private static final Logger LOGGER =
            LogManager.getRootLogger();
    private static final String LOGINPAGE_URL =
            "https://www.economycarrentals.com/en-us/customer/member";
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }
    public LoginPage openPage() {
        driver.navigate().to(LOGINPAGE_URL);
        LOGGER.info("Login page opened");
        return this;
    }


    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div[1]/div[2]/form/div[1]/input")
    private WebElement emailInput;
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div[1]/div[2]/form/div[2]/input")
    private WebElement passwordInput;



}
