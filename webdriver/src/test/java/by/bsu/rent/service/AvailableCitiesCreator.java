package by.bsu.rent.service;

import java.util.Arrays;
import java.util.List;

public class AvailableCitiesCreator {
    private static final String CITIES ="testdata.cities";
    public static List<String> withInfoFromProperty() {
        String cities = TestDataReader.getTestData(CITIES);
        String[] citiesArr = cities.split(",");
        return Arrays.asList(citiesArr);
    }
}
