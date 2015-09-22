package com.example.sbci;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

  public static String format(final Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.JAPANESE);
    return sdf.format(date);
  }

  public static Date parse(final String str) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.JAPANESE);
    try {
      return sdf.parse(str);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }

}
