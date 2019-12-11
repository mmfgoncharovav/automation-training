package by.bsu.rent.service;

import by.bsu.rent.model.Currency;

public class CurrencyCreator {
    private static final String CURRENCY = "testdata.currency";

    public static Currency withInfoFromProperty() {
        return new Currency(TestDataReader.getTestData(CURRENCY));
    }
}
