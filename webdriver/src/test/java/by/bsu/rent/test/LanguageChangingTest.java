package by.bsu.rent.test;

import by.bsu.rent.page.HomePage;
import by.bsu.rent.service.LanguageCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageChangingTest extends  CommonConditions {
    @Test(description = "Test for changing language of the page")
    public void changingLanguageToGermanTest() {
        HomePage page = new HomePage(driver).openPage();
        HomePage pageDifferentLanguage= page.changeLanguage(LanguageCreator.
                withInfoFromProperty());
        Assert.assertEquals(pageDifferentLanguage.checkCurrentLanguage(),
                LanguageCreator.withInfoFromProperty().getLanguage());


    }
}
