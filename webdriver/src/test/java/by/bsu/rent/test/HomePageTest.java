package by.bsu.rent.test;



import by.bsu.rent.model.Age;
import by.bsu.rent.model.PageError;
import by.bsu.rent.model.Place;
import by.bsu.rent.page.*;
import by.bsu.rent.service.AgeCreator;
import by.bsu.rent.service.LanguageCreator;
import by.bsu.rent.service.PageErrorCreator;
import by.bsu.rent.service.PlaceCreator;
import org.testng.Assert;
import org.testng.annotations.Test;


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
    @Test
    public void changingLanguageToGermanTest() {
        HomePage page = new HomePage(driver).openPage();
        HomePageGerman pageGerman = page.changeLanguage(LanguageCreator.withInfoFromProperty());
        Assert.assertEquals(pageGerman.checkCurrentLanguage(),LanguageCreator.withInfoFromProperty().getLanguage());


    }
}