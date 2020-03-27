package com.example.apigetter.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonHelper {

    public static String convertDateToString(String format, Date date) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static Date convertStringToDate(String format, String date) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String convertStringToString(String formatInput, String formatOutout, String date) {
        try {
            Date tmp = new SimpleDateFormat(formatInput).parse(date);
            ;
            DateFormat df = new SimpleDateFormat(formatOutout);
            return df.format(tmp);
        } catch (ParseException e) {
            return null;
        }
    }
}
