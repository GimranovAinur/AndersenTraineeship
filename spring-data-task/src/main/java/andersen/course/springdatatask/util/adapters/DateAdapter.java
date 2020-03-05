package andersen.course.springdatatask.util.adapters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateAdapter {

    private static final String DATE_PATTERN = "dd-MM-yyyy";

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(DATE_PATTERN);

    private DateAdapter() {
        // Класс-утилита
    }

    public static Date getFormattedDate(String aDateString) {
        try {
            return FORMATTER.parse(aDateString);
        } catch (ParseException e) {
            System.err.println("Ошибка парсинга даты");
            return new Date();
        }
    }

    public static String getDateString(Date aDate) {
        return FORMATTER.format(aDate);
    }
}
