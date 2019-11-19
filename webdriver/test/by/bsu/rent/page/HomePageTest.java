package by.bsu.rent.page;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest {
    private WebDriver driver;
    private HomePage page;

    @BeforeEach
    public void setUpMozillaDriver() {
        System.setProperty("webdriver.gecko.driver", "D:\\testing\\automation-training\\webdriver\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        page = new HomePage(driver);
        driver.manage().window().maximize();
    }
    @AfterEach
    public void tearDownMozillaDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    @Test
    public void invalidAgeTest() throws InterruptedException {
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
        page.search();
        String expectedError = "Пожалуйста, выберите место доставки.";
        assertTrue(page.checkCountryErrorMessage(expectedError));
    }
}