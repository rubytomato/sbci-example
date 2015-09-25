package com.example.sbci.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.sbci.App;
import com.example.sbci.DateHelper;
import com.example.sbci.repository.Orders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class OrdersServiceTest {

  @Autowired
  OrdersService ordersService;

  Orders order1;
  Orders order2;
  Orders order3;

  @Before
  public void setup() {
    order1 = new Orders();
    //order1.setId(999991L);
    order1.setOrderNumber(555L);
    order1.setOrderDate(DateHelper.parse("2015-09-23"));
    order1.setRequiredDate(DateHelper.parse("2015-09-27"));
    order1.setShippedDate(DateHelper.parse("2015-09-30"));
    order1.setStatus("Shipped");
    order1.setComments(null);
    order1.setCustomerNumber(1111L);

    order2 = new Orders();
    //order2.setOrderNumber(555L);
    order2.setOrderDate(DateHelper.parse("2015-09-23"));
    order2.setRequiredDate(DateHelper.parse("2015-09-27"));
    order2.setShippedDate(DateHelper.parse("2015-09-30"));
    order2.setStatus("Shipped");
    order2.setComments(null);
    order2.setCustomerNumber(1111L);

    order3 = new Orders();
    //order3.setOrderNumber(555L);
    order3.setOrderDate(DateHelper.parse("2015-09-23"));
    order3.setRequiredDate(DateHelper.parse("2015-09-27"));
    order3.setShippedDate(DateHelper.parse("2015-09-30"));
    order3.setStatus("Shipped");
    order3.setComments(null);
    order3.setCustomerNumber(1111L);

    clear();
  }

  @After
  public void tearDown() {
    clear();
  }

  private void clear() {
    //ordersService.removeAll(Arrays.asList(order1, order2, order3));
    ordersService.removeAll(Arrays.asList(order1));
  }

  @Test
  public void save_ok() {
    Orders result = ordersService.save(order1);
    System.out.println(result.getId());

    Orders actual = ordersService.findById(result.getId());
    System.out.println(actual.getId());

    order1.setId(actual.getId());

    assertThat(actual, is(result));
  }

  public void saveAll_ok() {
    Iterable<Orders> orders = ordersService.saveAll(Arrays.asList(order2, order3));
    assertThat(orders, notNullValue());
  }

  public void remove_ok() {
    ordersService.remove(order1);
    Orders order = ordersService.findById(order1.getId());
    assertThat(order, nullValue());
  }

}
