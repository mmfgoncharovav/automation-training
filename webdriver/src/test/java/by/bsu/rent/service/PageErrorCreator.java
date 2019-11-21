package by.bsu.rent.service;

import by.bsu.rent.model.PageError;

public class PageErrorCreator {
    private static final String EMPTY_FIELDS_ERROR =
            "testdata.empty.fields.error";
    private static final String AGE_ERROR =
            "testdata.age.error";

    public static PageError AgeErrorWithInfoFromProperty() {
        return new PageError(TestDataReader.getTestData(AGE_ERROR));
    }

    public static PageError EmptyErrorWithInfoFromPropety() {
        return new PageError(TestDataReader.getTestData(EMPTY_FIELDS_ERROR));
    }
}
