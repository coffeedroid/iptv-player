package mdc.libgeneral;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static String parseTime(String str) {
        String str2;
        if (str == null) {
            return "Unknown";
        }
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            Date time = Calendar.getInstance().getTime();
            int year = time.getYear() - parse.getYear();
            if (year > 0) {
                str2 = year + " years ago";
            } else if (year != 0) {
                return "Unknown";
            } else {
                int month = time.getMonth() - parse.getMonth();
                if (month > 0) {
                    str2 = month + " months ago";
                } else if (month != 0) {
                    return "Unknown";
                } else {
                    int date = time.getDate() - parse.getDate();
                    if (date > 0) {
                        str2 = date + " days ago";
                    } else if (date != 0) {
                        return "Unknown";
                    } else {
                        str2 = "Today";
                    }
                }
            }
            return str2;
        } catch (ParseException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }
}
