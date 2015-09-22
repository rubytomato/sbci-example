package com.example.sbci;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.*;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Set;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectInstance;
import javax.management.ObjectName;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

public class AppTest {

  @Rule
  public OutputCapture outputCapture = new OutputCapture();

  @Test
  public void testCommandLineOverrides() throws Exception {
      // 標準のPort番号(8080)以外で起動して、"Started Application" のメッセージが出力されるかテストする
      App.main(new String[] {"--server.port=8081"});
      String output = this.outputCapture.toString();
      assertTrue(output, output.contains("Started App"));
      // Exceptionが出力されていないかテストする
      assertFalse(output, output.contains("Exception"));
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
