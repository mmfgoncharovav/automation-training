package by.bsu.rent.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle("dev");

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}