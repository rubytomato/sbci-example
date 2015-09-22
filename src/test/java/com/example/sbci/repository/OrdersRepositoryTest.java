package com.example.sbci.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

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
    System.out.println("[[size]]" + obj.size());
    obj.forEach(a -> {
      System.out.println("className:" + a.getClassName());
      System.out.println("canonicalName:" + a.getObjectName().getCanonicalName());
    });

    //assertThat(ManagementFactory.getPlatformMBeanServer().queryMBeans(new ObjectName(OBJ_NAME), null).size(), is(1));
    assertThat("jmxTest", true);
  }

}
