package by.bsu.rent.service;

import by.bsu.rent.model.Language;

public class LanguageCreator {
    private static final String LANGUAGE = "testdata.language";

    public static Language withInfoFromProperty () {
        return new Language(TestDataReader.getTestData(LANGUAGE));
    }
}
