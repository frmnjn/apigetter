package com.example.apigetter.common;

import oracle.sql.DATE;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonHelper {

    private static String OS = System.getProperty("os.name").toLowerCase();

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

    public static String usedOS() {
        return System.getProperty("os.name").toLowerCase();
    }

    public static boolean isWindowsOs() {

        return (OS.contains("win"));
    }

    public static boolean isLinuxsOs() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }

    public static boolean isMacOs() {
        return (OS.contains("mac"));
    }

    public static Object convertTimestamp(Object result) throws SQLException {
        if (result instanceof TIMESTAMP) {
            return new Date(((TIMESTAMP) result).dateValue().getTime());
        } else if (result instanceof DATE) {
            return new Date(((DATE) result).dateValue().getTime());
        } else if (result instanceof TIMESTAMPLTZ) {
            return new Date(((TIMESTAMPLTZ) result).dateValue().getTime());
        } else if (result instanceof TIMESTAMPTZ) {
            return new Date(((TIMESTAMPTZ) result).dateValue().getTime());
        } else {
            return result;
        }
    }
}