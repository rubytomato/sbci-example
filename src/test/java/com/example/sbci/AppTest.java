package com.example.sbci;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

public class AppTest {

  @Rule
  public OutputCapture outputCapture = new OutputCapture();

  @Test
  public void testCommandLineOverrides() throws Exception {
    App.main(new String[]{});
    String output = this.outputCapture.toString();
    assertThat(output.contains("Started App"), is(Boolean.TRUE));
    assertThat(output.contains("Exception"), is(Boolean.FALSE));
  }

}
