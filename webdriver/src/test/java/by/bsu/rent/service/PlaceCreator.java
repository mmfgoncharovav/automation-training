package by.bsu.rent.service;

import by.bsu.rent.model.Place;

public class PlaceCreator {
    public static final String COUNTRY = "testdata.country";
    public static final String CITY = "testdata.city";
    public static final String PLACE_IN_CITY = "testdata.place";

    public static Place withInfoFromProperty() {
        return new Place(TestDataReader.getTestData(COUNTRY),
                TestDataReader.getTestData(CITY),
                TestDataReader.getTestData(PLACE_IN_CITY));
    }

}
