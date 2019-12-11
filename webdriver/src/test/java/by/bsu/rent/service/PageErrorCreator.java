package by.bsu.rent.service;

import by.bsu.rent.model.PageError;

public class PageErrorCreator {
    private static final String EMPTY_FIELDS_ERROR =
            "testdata.empty.fields.error";
    private static final String AGE_ERROR =
            "testdata.age.error";
    private static final String CAPTCHA_ERROR =
            "testdata.captcha.error";
    private static final String EMAIL_ERROR =
            "testdata.email.error";

    public static PageError ageErrorWithInfoFromProperty() {
        return new PageError(TestDataReader.getTestData(AGE_ERROR));
    }

    public static PageError emptyErrorWithInfoFromPropety() {
        return new PageError(TestDataReader.getTestData(EMPTY_FIELDS_ERROR));
    }

    public static PageError captchaError() {
        return new PageError(TestDataReader.getTestData(CAPTCHA_ERROR));
    }

    public static PageError emailError() {
        return new PageError(TestDataReader.getTestData(EMAIL_ERROR));
    }
}
