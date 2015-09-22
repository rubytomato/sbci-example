package com.example.sbci;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Date;

import org.junit.Test;

public class DateHelperTest {

  @Test
  public void test() {
    String dateStr = "2015-09-22";
    Date date = DateHelper.parse(dateStr);
    String actual = DateHelper.format(date);
    assertThat(actual, is(dateStr));
  }

}
