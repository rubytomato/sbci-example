package com.example.sbci.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.lang.management.ManagementFactory;

import javax.management.ObjectName;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.sbci.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
//@TestPropertySource(properties = {"spring.jmx.enabled:true","spring.datasource.jmx-enabled:true"})
//@ActiveProfiles("scratch")
public class OrdersRepositoryTest {

  protected static final String DATASET = "classpath:datasets/it-orders.xml";

  @Autowired
  OrdersRepository orderRepository;

  @Before
  public void setup() {
  }

  @Test
  public void executeQueryCount() {
    Long count = orderRepository.count();
    assertThat(count, is(326L));
  }

  @Test
  public void executesQueryMethodsCorrectly() {
    Orders order = orderRepository.findAll().get(0);
    assertThat(order, notNullValue());
  }

  @Test
  public void executeQueryFindOne() {
    Orders order = orderRepository.findOne(326L);
    assertThat(order, notNullValue());
    assertThat(order.getOrderNumber(), is(10425L));
  }

  @Test
  public void dummy() {
    assertThat("execute query", true);
  }

  //org.apache.tomcat.jdbc.pool.jmx:name=dataSourceMBean,type=ConnectionPool
  //com.example.sbci:type=ConnectionPool,*
  public static final String OBJ_NAME = "org.apache.tomcat.jdbc.pool.jmx:name=dataSourceMBean,type=ConnectionPool,*";

  @Test
  public void testJmx() throws Exception {
    assertThat(ManagementFactory.getPlatformMBeanServer().queryMBeans(new ObjectName(OBJ_NAME), null).size(), is(1));
  }

}
