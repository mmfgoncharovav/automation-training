package by.bsu.rent.test;

import by.bsu.rent.model.PageError;
import by.bsu.rent.model.User;
import by.bsu.rent.page.LoginPage;
import by.bsu.rent.service.PageErrorCreator;
import by.bsu.rent.service.UserCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends CommonConditions {
    private static final Logger LOGGER = LogManager.getRootLogger();
    @Test(description = "Test to check if captcha is working on login page")
    public void captchaWorkingTest() {
        LoginPage page = new LoginPage().openPage();
        User user = UserCreator.withInfoFromProperty();
        page.login(user);
        PageError expectedError = PageErrorCreator.captchaError();
        Assert.assertTrue(page.checkErrorMessage(expectedError));
    }
    @Test(description = "Test to check if email verification is working (email must exist in database")
    public void  recoveryEmailVerificationTest() throws Exception {
        LoginPage page = new LoginPage().openPage();
        User user = UserCreator.withInfoFromProperty();
        page.recoverPassword(user);
        PageError expectedError = PageErrorCreator.emailError();
        Assert.assertTrue(page.checkErrorMessage(expectedError));
    }
}
