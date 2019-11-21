package by.bsu.rent.page;

import by.bsu.rent.model.Age;
import by.bsu.rent.model.Language;
import by.bsu.rent.model.PageError;
import by.bsu.rent.model.Place;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final String HOMEPAGE_URL =
            "https://www.economycarrentals.com/en-us";
    private final WebDriverWait wait;

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

    @FindBy(xpath = "//*[@id=\"language\"]")
    private WebElement languageSelector;
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

    public void selectPlaceInCity(String place) {
        Select dropdown = new Select(placeSelect);
        dropdown.selectByVisibleText(place);
    }

    public void selectCompletePlace(Place place){
            wait.until(ExpectedConditions.elementToBeClickable(countrySelect));
            selectCountry(place.getCountry());
            wait.until(ExpectedConditions.elementToBeClickable(citySelect));
            selectCity(place.getCity());
            wait.until(ExpectedConditions.elementToBeClickable(placeSelect));
            selectPlaceInCity(place.getPlaceInCity());
    }

    public void setAge(Age age) {
        ageValue.click();
        ageValue.clear();
        String ageString = String.valueOf(age.getAge());
        ageValue.sendKeys(ageString);

    }

    public boolean checkAgeErrorMessage(PageError error) {
        return ageError.isDisplayed()
                && ageError.getText().
                        contains(error.getErrorDescription());
    }

    public boolean checkPlaceErrorMessage(PageError error) {
        return countryError.isDisplayed()
                && countryError.getText().
                contains(error.getErrorDescription());
    }

    public HomePageGerman changeLanguage(Language language) {
        Select dropdown = new Select(languageSelector);
        dropdown.selectByVisibleText(language.getLanguage());
        LOGGER.info("Language changed to " + language.getLanguage());
        return new HomePageGerman(driver);

    }
}
