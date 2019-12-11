package by.bsu.rent.test;



import by.bsu.rent.model.Age;
import by.bsu.rent.model.Currency;
import by.bsu.rent.model.PageError;
import by.bsu.rent.model.Place;
import by.bsu.rent.page.*;
import by.bsu.rent.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class HomePageTest extends CommonConditions {

    @Test(description = "Test for checking working age restrictions")
    public void invalidAgeTest() {
        HomePage page = new HomePage(driver).openPage();
        Place place = PlaceCreator.withInfoFromProperty();
        page.selectCompletePlace(place);
        page.setAgeCheckButton();
        Age age = AgeCreator.withInfoFromProperty();
        page.setAge(age);
        page.search();
        PageError expectedError = PageErrorCreator.AgeErrorWithInfoFromProperty();
        Assert.assertTrue(page.checkAgeErrorMessage(expectedError));
    }
    @Test(description = "Test for checking being able to search for cars without specifying any info")
    public void emptyInputTest() {
        HomePage page = new HomePage(driver).openPage();
        page.search();
        PageError expectedError = PageErrorCreator.EmptyErrorWithInfoFromPropety();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
     }

    @Test(description = "date test")
    public void dateTest() {
        HomePage page = new HomePage(driver).openPage();
        page.openEndTimeCalendar();
        LocalDate date = LocalDateCreator.withInfoFromProperty();
        Assert.assertFalse(page.isDateAvailable(date));

    }
    @Test
    public void changingCurrencyTest() {
        HomePage page = new HomePage(driver).openPage();
        Currency currency = CurrencyCreator.withInfoFromProperty();
        page = page.changeCurrency(currency);
        Assert.assertEquals(page.checkCurrentCurrency(),currency.getCurrency());

    }
}
