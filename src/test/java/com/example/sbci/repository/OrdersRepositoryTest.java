package com.example.sbci.repository;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbci.App;
import com.example.sbci.DateHelper;
import com.example.sbci.domain.Orders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class OrdersRepositoryTest {

  @Autowired
  OrdersRepository orderRepository;

  @Test
  public void executeQueryCount() {
    Long count = orderRepository.count();
    assertThat(count, is(326L));
  }

  @Test
  public void executeQueryFindOne() {
    Long id = 326L;
    Orders order = orderRepository.findOne(id);
    assertThat(order, notNullValue());
    assertThat(order.getId(), is(id));
  }

  @Test
  public void executeQueryFindByPk() {
    Long orderNumber = 10425L;
    Orders order = orderRepository.findByPk(orderNumber);
    assertThat(order, notNullValue());
    assertThat(order.getOrderNumber(), is(orderNumber));
  }

  @Test
  public void executeQueryFindAll() {
    List<Orders> list = orderRepository.findAll();
    assertThat(list, notNullValue());
    assertThat(list.size(), is(326));
  }

  @Test
  public void executeQueryFindByOrderDateRange() {
    Date from = DateHelper.parse("2013-05-01");
    Date to = DateHelper.parse("2013-05-31");
    List<Orders> list = orderRepository.findByOrderDateRange(from, to);
    assertThat(list, notNullValue());
    assertThat(list.size(), is(15));
  }

  @Test
  @Transactional
  public void executeUpdateComments() {
    Long orderNumber = 10245L;

    String c1 = "test update comment du3hB8ajwO";

    Integer u1 = orderRepository.updateComments(orderNumber, c1);
    assertThat(u1, is(1));

    Orders o1 = orderRepository.findByPk(orderNumber);
    assertThat(o1, notNullValue());
    assertThat(o1.getComments(), is(c1));


    String c2 = "test update comment vP49ayRjfy";

    Integer u2 = orderRepository.updateComments(orderNumber, c2);
    assertThat(u2, is(1));

    Orders o2 = orderRepository.findByPk(orderNumber);
    assertThat(o2, notNullValue());
    assertThat(o2.getComments(), is(c2));
  }

}
