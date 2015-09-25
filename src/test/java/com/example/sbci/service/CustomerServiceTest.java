package com.example.sbci.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.sbci.App;
import com.example.sbci.repository.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class CustomerServiceTest {

  @Autowired
  CustomerService customerService;

  Customer customer1;

  @Before
  public void setup() {
    customer1 = new Customer();
    //customer1.setId(999991L);
    customer1.setCustomerNumber(496L);
    customer1.setCustomerName("Kelly's Gift Shop");
    customer1.setContactFirstName("Snowden");
    customer1.setContactLastName("Tony");
    customer1.setPhone("+64 9 5555500");
    customer1.setAddressLine1("Arenales 1938 3'A'");
    customer1.setAddressLine2(null);
    customer1.setCity("Auckland");
    customer1.setState(null);
    customer1.setPostalCode(null);
    customer1.setCountry("New Zealand");
    customer1.setSalesRepEmployeeNumber(1612L);
    customer1.setCreditLimit(new BigDecimal("110000.00"));

    clear();
  }

  @After
  public void tearDown() {
    clear();
  }

  private void clear() {
    customerService.removeAll(Arrays.asList(customer1));
  }

  @Test
  public void save_ok() {

    Customer result = customerService.save(customer1);
    System.out.println(result.getId());

    Customer actual = customerService.findById(result.getId());
    System.out.println(actual.getId());

    customer1.setId(actual.getId());

    assertThat(actual, is(result));

  }

}
