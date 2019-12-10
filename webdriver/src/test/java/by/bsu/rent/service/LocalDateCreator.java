package by.bsu.rent.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateCreator {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String data = "testdata.date";
    public static LocalDate withInfoFromProperty() {
        String date = TestDataReader.getTestData(data);
        String date_dd_MM_yyyy[] = (date.split(" ")[0]).split("/");
        return LocalDate.of(Integer.decode(date_dd_MM_yyyy[2]),
                Integer.decode(date_dd_MM_yyyy[1]),
                Integer.decode(date_dd_MM_yyyy[0]));

    }
}
