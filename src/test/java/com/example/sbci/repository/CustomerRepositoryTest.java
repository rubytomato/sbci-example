package com.example.sbci.repository;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.sbci.App;
import com.example.sbci.domain.Customer;

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
  public void executeQueryFindAll() {
    List<Customer> list = customerRepository.findAll();
    assertThat(list, notNullValue());
    assertThat(list.size(), is(122));
  }

  @Test
  public void executeQueryFindByNameLike() {
    Sort sort = new Sort("customerName");
    String customerName = "%Classic%";
    List<Customer> list = customerRepository.findByCustomerNameLike(customerName, sort);
    assertThat(list, notNullValue());
    assertThat(list.size(), is(5));
  }

  @Test
  public void executeQueryFindByNameLike2() {
    String customerName = "%Classic%";
    List<Customer> list = customerRepository.findByCustomerNameLike(customerName);
    assertThat(list, notNullValue());
    assertThat(list.size(), is(5));
  }

  @Test
  public void executeQueryFindByName() {
    String customerName = "Classic Legends Inc.";
    List<Customer> list = customerRepository.findByCustomerName(customerName);
    assertThat(list, notNullValue());
    assertThat(list.size(), is(1));
  }

}
