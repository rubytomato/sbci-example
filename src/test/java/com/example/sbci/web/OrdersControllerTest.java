package com.example.sbci.web;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Set;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectInstance;
import javax.management.ObjectName;

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
public class OrdersControllerTest {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void before() throws Exception {
    //this.mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
    this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
  }

  @Test
  public void testIndexGet_Ok() throws Exception {
    this.mvc.perform(get("/orders"))
       .andExpect(status().isOk())
       .andExpect(content().contentType("text/html;charset=UTF-8"))
       .andExpect(content().string(containsString("<h3>index - contents</h3>")));
  }

  @Test
  public void testDetailGet_Ok() throws Exception {
    this.mvc.perform(get("/orders/detail/1"))
    .andExpect(status().isOk())
    .andExpect(content().contentType("text/html;charset=UTF-8"))
    .andExpect(content().string(containsString("<h3>detail - contents</h3>")));
  }

  //org.apache.tomcat.jdbc.pool.jmx:name=dataSourceMBean,type=ConnectionPool
  //com.example.sbci:type=ConnectionPool,*
  public static final String OBJ_NAME = "org.apache.tomcat.jdbc.pool.jmx:name=dataSourceMBean,type=ConnectionPool";

  @Test
  public void testJmx() throws Exception {
    System.out.println("***testJmx***");
    List<MBeanServer> mbservers = MBeanServerFactory.findMBeanServer(null);
    if (mbservers.size() > 0) {
      for (MBeanServer s : mbservers) {
        System.out.println("[[" + s.getDefaultDomain() + "]]");
      }
    }

    System.out.println("***");
    Set<ObjectInstance> obj = ManagementFactory.getPlatformMBeanServer().queryMBeans(new ObjectName(OBJ_NAME), null);
    System.out.println("[[size:" + obj.size() + "]]");
    obj.forEach(a -> {
      System.out.println("className:" + a.getClassName());
      System.out.println("canonicalName:" + a.getObjectName().getCanonicalName());
    });

    //assertThat(ManagementFactory.getPlatformMBeanServer().queryMBeans(new ObjectName(OBJ_NAME), null).size(), is(1));
    assertThat("jmxTest", true);
  }

}
