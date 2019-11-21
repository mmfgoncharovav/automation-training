package by.bsu.rent.service;

import by.bsu.rent.model.Age;

public class AgeCreator {
    private static final String AGE = "testdata.age";

    public static Age withInfoFromProperty() {
        return new Age(Integer.decode(TestDataReader.getTestData(AGE)));
    }
}
