package com.example.sbci.service;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import javax.validation.ValidationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.sbci.App;
import com.example.sbci.DateHelper;
import com.example.sbci.domain.Orders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class OrdersServiceTest {

  @Autowired
  OrdersService ordersService;

  Orders order1;
  Orders order2;
  Orders order3;
  Orders order4;
  Orders order5;

  @Before
  public void setup() {
    order1 = new Orders();
    order1.setOrderNumber(555L);
    order1.setOrderDate(DateHelper.parse("2015-09-23"));
    order1.setRequiredDate(DateHelper.parse("2015-09-27"));
    order1.setShippedDate(DateHelper.parse("2015-09-30"));
    order1.setStatus("Shipped");
    order1.setComments(null);
    order1.setCustomerNumber(1111L);

    order2 = new Orders();
    order2.setOrderNumber(555L);
    order2.setOrderDate(DateHelper.parse("2015-09-23"));
    order2.setRequiredDate(DateHelper.parse("2015-09-27"));
    order2.setShippedDate(DateHelper.parse("2015-09-30"));
    order2.setStatus("Shipped");
    order2.setComments(null);
    order2.setCustomerNumber(1111L);

    order3 = new Orders();
    order3.setOrderNumber(555L);
    order3.setOrderDate(DateHelper.parse("2015-09-23"));
    order3.setRequiredDate(DateHelper.parse("2015-09-27"));
    order3.setShippedDate(DateHelper.parse("2015-09-30"));
    order3.setStatus("Shipped");
    order3.setComments(null);
    order3.setCustomerNumber(1111L);

    order4 = new Orders();
    order4.setOrderNumber(null);

    order5 = new Orders();
    order5.setOrderNumber(555L);
    order5.setOrderDate(DateHelper.parse("2015-09-23"));
    order5.setRequiredDate(DateHelper.parse("2015-09-27"));
    order5.setShippedDate(DateHelper.parse("2015-09-30"));
    order5.setStatus("1234567890123456789012345678901234567890");
    order5.setComments(null);
    order5.setCustomerNumber(1111L);

  }

  @After
  public void tearDown() {
    clear();
  }

  private void clear() {
    ordersService.removeAll(Arrays.asList(order1, order2, order3));
  }

  @Test
  public void save_ok() {
    Orders result = ordersService.save(order1);
    assertThat(result, notNullValue());
    Orders actual = ordersService.findById(result.getId());
    assertThat(actual, is(result));

    order1.setId(actual.getId());
  }

  @Test
  public void saveAll_ok() {
    List<Orders> orders = ordersService.saveAll(Arrays.asList(order2, order3));
    assertThat(orders, notNullValue());

    Orders actual2 = ordersService.findById(orders.get(0).getId());
    Orders actual3 = ordersService.findById(orders.get(1).getId());
    assertThat(actual2, is(orders.get(0)));
    assertThat(actual3, is(orders.get(1)));

    order2.setId(actual2.getId());
    order3.setId(actual3.getId());
  }

  @Test(expected = ValidationException.class)
  public void save_null_ng() {
    try {
      ordersService.save(order4);
    } catch (ValidationException e) {
      System.out.println("DataAccessException!!");
      System.out.println("message:" + e.getMessage());
      throw e;
    }
    org.junit.Assert.fail();
  }

  @Test(expected = DataAccessException.class)
  public void save_too_long_ng() {
    try {
      ordersService.save(order5);
    } catch (DataAccessException e) {
      System.out.println("DataIntegrityViolationException!!");
      System.out.println("message:" + e.getMessage());
      throw e;
    }
    org.junit.Assert.fail();
  }

  @Test
  public void remove_ok() {
    Orders result = ordersService.save(order1);
    assertThat(result, notNullValue());

    ordersService.remove(result);

    Orders order = ordersService.findById(result.getId());
    assertThat(order, nullValue());
  }

  @Test
  public void removeAll_ok() {
    List<Orders> orders = ordersService.saveAll(Arrays.asList(order2, order3));
    assertThat(orders, notNullValue());

    ordersService.removeAll(Arrays.asList(order2, order3));

    Orders order2 = ordersService.findById(orders.get(0).getId());
    Orders order3 = ordersService.findById(orders.get(1).getId());
    assertThat(order2, nullValue());
    assertThat(order3, nullValue());
  }

  @Test
  public void updateComments_ok() {
    Long orderNumber = 10245L;

    String c1 = "test update comment du3hB8ajwO";

    Integer u1 = ordersService.updateComments(orderNumber, c1);
    assertThat(u1, is(1));

    Orders o1 = ordersService.findByPk(orderNumber);
    assertThat(o1, notNullValue());
    assertThat(o1.getComments(), is(c1));


    String c2 = "test update comment vP49ayRjfy";

    Integer u2 = ordersService.updateComments(orderNumber, c2);
    assertThat(u2, is(1));

    Orders o2 = ordersService.findByPk(orderNumber);
    assertThat(o2, notNullValue());
    assertThat(o2.getComments(), is(c2));

  }

}
