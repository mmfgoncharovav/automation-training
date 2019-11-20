package by.bsu.rent.test;



import by.bsu.rent.page.HomePage;
import org.testng.annotations.Test;


import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest extends CommonConditions {
    @Test
    public void invalidAgeTest() throws InterruptedException {
        HomePage page = new HomePage(driver).openPage();
        String country = "Белоруссия";
        String city = "Минск";
        String place = "Минск Международный Aэропорт (MSQ)";
        page.selectCountry(country);
        Thread.sleep(5000);
        page.selectCity(city);
        Thread.sleep(5000);
        page.selectPlace(place);
        page.setAgeCheckButton();
        String age = "14";
        page.setAge(age);
        page.search();
        String expectedError = "Age Error";
        assertTrue(page.checkAgeErrorMessage(expectedError));
    }
    @Test
    public void emptyInputTest() {
        HomePage page = new HomePage(driver).openPage();
        page.search();
        String expectedError = "Пожалуйста, выберите место доставки.";
        assertTrue(page.checkCountryErrorMessage(expectedError));
    }
}