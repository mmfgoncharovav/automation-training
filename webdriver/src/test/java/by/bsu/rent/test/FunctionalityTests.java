package by.bsu.rent.test;

import by.bsu.rent.page.ContactPage;
import by.bsu.rent.page.HomePage;
import by.bsu.rent.service.ContactPageChecker;
import by.bsu.rent.service.LanguageCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FunctionalityTests extends  CommonConditions {
    @Test(description = "Test for changing language of the page")
    public void changingLanguageToGermanTest() {
        HomePage page = new HomePage().openPage();
        HomePage pageDifferentLanguage= page.changeLanguage(LanguageCreator.
                withInfoFromProperty());
        Assert.assertEquals(pageDifferentLanguage.getCurrentLanguage(),
                LanguageCreator.withInfoFromProperty().getLanguage());


    }
    @Test(description = "Test to check if info is shown on page")
    public void isInfoDisplayedOnContactPage() {
        ContactPage page = new ContactPage().openPage();
        Assert.assertTrue(ContactPageChecker.isAllRentingInfoAvailable(page));
    }
}
