package StrringOps;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class dateOps {

    public static void main(String[] args) throws ParseException
    {
        newDate dx = new newDate();
        dx.initDates();

    }
}

class newDate
{
    public void initDates() throws ParseException {
        DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss zzz");
        Date dt1 = new Date();
        String s1 = sdf.format(dt1);
        System.out.println("Old Style--"+s1);
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String s2 = dtf1.format(localDate);
        System.out.println("new Style--"+s2);
        // convert LocalDate to String
        String localDateAsDefaultString = localDate.toString();
        System.out.println("LocalDate: " + localDateAsDefaultString + "( year: " + localDate.getYear()
                + ", month: " + localDate.getMonthValue() + ", day: " + localDate.getDayOfMonth() + " )");

    }

}