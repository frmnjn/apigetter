package com.example.apigetter.common;

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


}