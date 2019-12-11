package by.bsu.rent.test;

import by.bsu.rent.model.PageError;
import by.bsu.rent.model.User;
import by.bsu.rent.page.LoginPage;
import by.bsu.rent.service.PageErrorCreator;
import by.bsu.rent.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends CommonConditions {
    @Test
    public void testCaptchaWorking() {
        LoginPage page = new LoginPage(driver).openPage();
        User user = UserCreator.withInfoFromProperty();
        page.login(user);
        PageError expectedError = PageErrorCreator.CaptchaError();
        Assert.assertTrue(page.checkErrorMessage(expectedError));
    }
}
