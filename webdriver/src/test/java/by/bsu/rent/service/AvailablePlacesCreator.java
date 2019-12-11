package by.bsu.rent.service;

import java.util.Arrays;
import java.util.List;

public class AvailablePlacesCreator {
    private static final String PLACES ="testdata.places";
    public static List<String> withInfoFromProperty() {
        String cities = TestDataReader.getTestData(PLACES);
        String[] citiesArr = cities.split(",");
        return Arrays.asList(citiesArr);
    }
}
