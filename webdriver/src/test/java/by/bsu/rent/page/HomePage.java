package by.bsu.rent.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final String HOMEPAGE_URL = "http://www.economycarrentals.com";
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }
    public HomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        LOGGER.info("Home page opened");
        return this;
    }

    @FindBy(xpath = "//*[@id=\"search-location-pickup\"]")
    private WebElement placeSelect;
    @FindBy(xpath = "//*[@id=\"search-city\"]")
    private WebElement citySelect;
    @FindBy(xpath = "//*[@id=\"search-country\"]")
    private WebElement countrySelect;
    @FindBy(xpath = "//*[@id=\"search-age-input\"]")
    private WebElement ageValue;
    @FindBy(xpath = "//*[@id=\"search-age-checkbox\"]")
    private WebElement ageCheckButton;
    @FindBy(xpath = "//*[@id='search-button']")
    private WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"age-error\"]")
    private WebElement ageError;
    @FindBy(xpath = "//*[@id=\"country-error\"]")
    private WebElement countryError;

    public void search() {
        searchButton.click();
    }

    public void setAgeCheckButton(){
        ageCheckButton.click();
    }
    public void selectCountry(String country) {
        Select dropdown = new Select(countrySelect);
        dropdown.selectByVisibleText(country);
    }
    public void selectCity(String city) {
        Select dropdown = new Select(citySelect);
        dropdown.selectByVisibleText(city);
    }

    public void selectPlace(String place) {
        Select dropdown = new Select(placeSelect);
        dropdown.selectByVisibleText(place);
    }

    public void setAge(String age) {
        ageValue.click();
        ageValue.clear();
        ageValue.sendKeys(age);

    }

    public boolean checkAgeErrorMessage(String errorMessage) {
        return ageError.isDisplayed() && ageError.getText().contains(errorMessage);
    }

    public boolean checkCountryErrorMessage(String errorMessage) {
        return countryError.isDisplayed() && countryError.getText().contains(errorMessage);
    }
}
