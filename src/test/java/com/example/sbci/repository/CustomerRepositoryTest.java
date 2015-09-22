package com.example.sbci.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.sbci.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class CustomerRepositoryTest {

  @Autowired
  CustomerRepository customerRepository;

  @Test
  public void executeQueryCount() {
    Long count = customerRepository.count();
    assertThat(count, is(122L));
  }

  @Test
  public void executeQueryFindOne() {
    Long id = 122L;
    Customer customer = customerRepository.findOne(id);
    assertThat(customer, notNullValue());
    assertThat(customer.getId(), is(id));
  }

  @Test
  public void executeQueryFindByPk() {
    Long customerNumber = 496L;
    Customer customer = customerRepository.findByPk(customerNumber);
    assertThat(customer, notNullValue());
    assertThat(customer.getCustomerNumber(), is(customerNumber));
  }

  @Test
  public void executeQueryFindByNameLike() {
    Sort sort = new Sort("customerName");
    String customerName = "%Classic%";
    List<Customer> list = customerRepository.findByCustomerNameLike(customerName, sort);
    assertThat(list, notNullValue());

    Customer customer = list.get(0);
    assertThat(customer.getCustomerName(), is("Auto-Moto Classics Inc."));
  }

}
