package by.bsu.rent.test;


import by.bsu.rent.driver.DriverSingleton;
import by.bsu.rent.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    private static final String RESOURCES_PATH = "src\\test\\resources\\";

    @AfterMethod (alwaysRun = true)
    public void tearDownDriver() {
        DriverSingleton.closeDriver();
    }

}
