package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * Created by Piotr on 19.05.2018.
 */
public class DateUtil {

    public static String getCurrentDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh-mm-ss"));
    }

}
