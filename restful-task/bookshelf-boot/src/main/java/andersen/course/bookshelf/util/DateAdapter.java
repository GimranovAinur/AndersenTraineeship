package andersen.course.bookshelf.util;

import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class DateAdapter {

    private final String DATE_PATTERN = "dd-MM-yyyy";

    private final SimpleDateFormat FORMATTER = new SimpleDateFormat(DATE_PATTERN);

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
