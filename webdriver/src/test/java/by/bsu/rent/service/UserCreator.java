package by.bsu.rent.service;

import by.bsu.rent.model.User;

public class UserCreator {
    public static final String EMAIL = "testdata.email";
    public static final String PASSWORD= "testdata.password";

    public static User withInfoFromProperty() {
        return new User(TestDataReader.getTestData(EMAIL),
                TestDataReader.getTestData(PASSWORD));
    }
}
