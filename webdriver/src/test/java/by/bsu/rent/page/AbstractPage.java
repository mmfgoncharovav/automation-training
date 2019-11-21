package by.bsu.rent.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected final WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 30;
    protected abstract AbstractPage openPage();
    protected AbstractPage(WebDriver driver) {
        this.driver  = driver;
    }
}
