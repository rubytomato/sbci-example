package com.example.sbci.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.sbci.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CustomerControllerTest {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void before() throws Exception {
    this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
  }

  @Test
  public void testIndexGet_Ok() throws Exception {
    this.mvc.perform(get("/customer"))
       .andExpect(status().isOk())
       .andExpect(content().contentType("text/html;charset=UTF-8"))
       .andExpect(content().string(containsString("<title>sbci-example - customer</title>")));
  }

  @Test
  public void testDetailGet_Ok() throws Exception {
    this.mvc.perform(get("/customer/detail/100"))
    .andExpect(status().isOk())
    .andExpect(content().contentType("text/html;charset=UTF-8"))
    .andExpect(content().string(containsString("<h3>detail - contents</h3>")));
  }

  @Test
  public void testDetailGet_NotFound() throws Exception {
    this.mvc.perform(get("/customer/notfound"))
    .andExpect(status().is4xxClientError());
  }

}
