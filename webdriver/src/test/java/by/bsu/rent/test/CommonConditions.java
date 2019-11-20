package by.bsu.rent.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {
    protected WebDriver driver;
    private static final String RESOURCES_PATH = "src\\test\\resources\\";

    @BeforeMethod
    public void setUpMozillaDriver() {
        System.setProperty("webdriver.gecko.driver", RESOURCES_PATH + "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDownMozillaDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
