package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static String getCurrentDateTime() {

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(
                "dd-MM-yyyy HH:mm:ss"
            );

        return now.format(formatter);
    }

    public static String getCurrentDate() {

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return now.format(formatter);
    }
}