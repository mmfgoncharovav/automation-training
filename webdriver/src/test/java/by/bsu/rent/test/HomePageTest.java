package by.bsu.rent.test;



import by.bsu.rent.model.Age;
import by.bsu.rent.model.Currency;
import by.bsu.rent.model.PageError;
import by.bsu.rent.model.Place;
import by.bsu.rent.page.*;
import by.bsu.rent.service.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;


public class HomePageTest extends CommonConditions {

    @Test(description = "Test for checking working age restrictions")
    public void invalidAgeTest() {
        HomePage page = new HomePage().openPage();
        Place place = PlaceCreator.withInfoFromProperty();
        page.selectCompletePlace(place);
        page.setAgeCheckButton();
        Age age = AgeCreator.withInfoFromProperty();
        page.setAge(age);
        page.search();
        PageError expectedError = PageErrorCreator.ageErrorWithInfoFromProperty();
        Assert.assertTrue(page.checkAgeErrorMessage(expectedError));
    }
    @Test(description = "Test for checking being able to search for cars without specifying any info")
    public void emptyInputTest() {
        HomePage page = new HomePage().openPage();
        page.search();
        PageError expectedError = PageErrorCreator.emptyErrorWithInfoFromPropety();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
     }

    @Test(description = "Date test")
    public void dateTest() {
        HomePage page = new HomePage().openPage();
        page.openEndTimeCalendar();
        LocalDate date = LocalDateCreator.withInfoFromProperty();
        Assert.assertFalse(page.isDateAvailable(date));

    }
    @Test (description = "Test to check if changing currency function works")
    public void changingCurrencyTest() {
        HomePage page = new HomePage().openPage();
        Currency currency = CurrencyCreator.withInfoFromProperty();
        page = page.changeCurrency(currency);
        Assert.assertEquals(page.checkCurrentCurrency(),currency.getCurrency());
    }
    @Test (description = "Test to check if available cities are shown according to the country")
    public void checkAvailableCities() {
        HomePage page = new HomePage().openPage();
        Place place = PlaceCreator.withInfoFromProperty();
        page.selectCountry(place.getCountry());
        List<String> expectedCities = AvailableCitiesCreator.withInfoFromProperty();
        List<String> actualCities = page.getAllCitiesOptions();
        Assert.assertEquals(expectedCities,actualCities);
    }
    @Test (description = "Test to check if available places are shown according to the country and city")
    public void checkAvailablePlaces() {
        HomePage page = new HomePage().openPage();
        Place place = PlaceCreator.withInfoFromProperty();
        page.selectCountry(place.getCountry());
        page.selectCity(place.getCity());
        List<String> expectedPlaces = AvailablePlacesCreator.withInfoFromProperty();
        List<String> actualPlaces = page.getAllPlacesOptions();
        Assert.assertEquals(expectedPlaces, actualPlaces);
    }

}
