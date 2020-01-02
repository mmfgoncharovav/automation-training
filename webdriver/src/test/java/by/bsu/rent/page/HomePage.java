package by.bsu.rent.page;

import by.bsu.rent.driver.DriverSingleton;
import by.bsu.rent.model.*;
import by.bsu.rent.util.LinksByLanguage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final String HOMEPAGE_URL =
            "https://www.economycarrentals.com/en-us";
    private final WebDriverWait wait;

    public HomePage() {
        super(DriverSingleton.getDriver());
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        LOGGER.info("Created HomePage entity");
    }

    public HomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        LOGGER.info("Home page opened");
        return this;
    }

    public HomePage openPageDifferentLanguage(Language language) {
        String link = LinksByLanguage.init().getLinkByLanguage(language);
        driver.navigate().to(link);
        return this;
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/button")
    private WebElement cookieButton;
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
    @FindBy(xpath = "//*[@id=\"search-rental-end-date\"]")
    private WebElement endDateSelect;
    @FindBy(xpath = "//*[@id=\"search-rental-end-time\"]")
    private WebElement endTimeSelect;
    @FindBy(xpath = "/html/body/div[4]/div/div[1]/table/tbody/tr[4]/td[not(contains(@class,'day-disabled'))]")
    private List<WebElement> availableDates;
    @FindBy(xpath = "//*[@id=\"currency\"]")
    private WebElement currencySelect;
    @FindBy(xpath = "//*[@id=\"search-rental-start-time\"]")
    private WebElement startTime;
    @FindBy(xpath = "//*[@id=\"search-rental-end-time\"]")
    private WebElement endTime;

    public void search() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void setAgeCheckButton() {
        cookieButton.click();
        wait.until(ExpectedConditions.visibilityOf(ageCheckButton));
        wait.until(ExpectedConditions.elementToBeClickable(ageCheckButton));
        ageCheckButton.click();
    }

    public void selectCountry(String country) {
        wait.until(ExpectedConditions.elementToBeClickable(countrySelect));
        Select dropdown = new Select(countrySelect);
        dropdown.selectByVisibleText(country);
        LOGGER.info(country+ " selected");
    }

    public void selectCity(String city) {
        wait.until(ExpectedConditions.elementToBeClickable(citySelect));
        Select dropdown = new Select(citySelect);
        dropdown.selectByVisibleText(city);
        LOGGER.info(city+ " selected");
    }

    public void selectPlaceInCity(String place) {
        wait.until(ExpectedConditions.elementToBeClickable(placeSelect));
        Select dropdown = new Select(placeSelect);
        dropdown.selectByVisibleText(place);
        LOGGER.info(place+ " selected");
    }

    public void selectCompletePlace(Place place) {
        selectCountry(place.getCountry());
        selectCity(place.getCity());
        selectPlaceInCity(place.getPlaceInCity());
        LOGGER.info("Complete place selected");
    }

    public void setAge(Age age) {
        ageValue.click();
        ageValue.clear();
        String ageString = String.valueOf(age.getAge());
        ageValue.sendKeys(ageString);
        LOGGER.info("age set to " + age.getAge());

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

    public HomePage changeLanguage(Language language) {
        Select dropdown = new Select(languageSelector);
        dropdown.selectByVisibleText(language.getLanguage());
        LOGGER.info("Language changed to " + language.getLanguage());
        return this;

    }

    public HomePage changeCurrency(Currency currency) {
        Select dropdown = new Select(currencySelect);
        dropdown.selectByVisibleText(currency.getCurrency());
        LOGGER.info("Currency changed to " +currency.getCurrency());
        return this;

    }

    public String checkCurrentCurrency() {
        WebElement option = new Select(currencySelect).getFirstSelectedOption();
        String text = option.getText();
        LOGGER.info("Current currency is " + text);
        return text;

    }
    public String getCurrentLanguage() {
        Select dropdown = new Select(languageSelector);
        WebElement option = dropdown.getFirstSelectedOption();
        String text = option.getText();
        LOGGER.info("Current language of the page is " + text);
        return text;
    }

    public void openEndTimeCalendar() {
        wait.until(ExpectedConditions.visibilityOf(endDateSelect));
        wait.until(ExpectedConditions.elementToBeClickable(endDateSelect));
        endDateSelect.click();
        LOGGER.info("End time calendar opened");
    }

    public boolean isDateAvailable(LocalDate dateTime) {
        int dayOfMonth = dateTime.getDayOfMonth();
        LOGGER.debug("Input day for availability testing: " + dayOfMonth);
        for(int i = 0; i<availableDates.size();i++) {
            if(String.valueOf(dayOfMonth).equals(availableDates.get(i).getText())) {
                return true;
            }
        }
        return false;

    }

    public  List<String> getAllCitiesOptions() {
        wait.until(ExpectedConditions.elementToBeClickable(citySelect));
        List<WebElement> cities = new Select(citySelect).getOptions();
        cities.remove(0);
        List<String> dropdown = new ArrayList<>();
        Iterator<WebElement> itr = cities.iterator();
        while (itr.hasNext()) {
            String st = itr.next().getText();
            LOGGER.debug("City: " + st);
            dropdown.add(st);
        }
        return dropdown;
    }

    public List<String> getAllPlacesOptions() {
        wait.until(ExpectedConditions.elementToBeClickable(placeSelect));
        List<WebElement> places = new Select(placeSelect).getOptions();
        places.remove(0);
        List<String> dropdown = new ArrayList<>();
        Iterator<WebElement> itr = places.iterator();
        while (itr.hasNext()) {
            String st = itr.next().getText();
            LOGGER.debug("Place: " + st);
            dropdown.add(st);
        }
        return dropdown;

    }
}
