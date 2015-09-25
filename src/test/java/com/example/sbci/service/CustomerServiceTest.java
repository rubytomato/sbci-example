package com.example.sbci.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.sbci.App;
import com.example.sbci.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class CustomerServiceTest {

  @Autowired
  CustomerService customerService;

  Customer customer1;
  Customer customer2;
  Customer customer3;

  @Before
  public void setup() {
    customer1 = new Customer();
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

    customer2 = new Customer();
    customer2.setCustomerNumber(489L);
    customer2.setCustomerName("Double Decker Gift Stores, Ltd");
    customer2.setContactFirstName("Smith");
    customer2.setContactLastName("Thomas");
    customer2.setPhone("(171) 555-7555");
    customer2.setAddressLine1("120 Hanover Sq.");
    customer2.setAddressLine2(null);
    customer2.setCity("London");
    customer2.setState(null);
    customer2.setPostalCode("WA1 1DP");
    customer2.setCountry("UK");
    customer2.setSalesRepEmployeeNumber(1501L);
    customer2.setCreditLimit(new BigDecimal("43300.00"));

    customer3 = new Customer();
    customer3.setCustomerNumber(495L);
    customer3.setCustomerName("Diecast Collectables");
    customer3.setContactFirstName("Franco");
    customer3.setContactLastName("Valarie");
    customer3.setPhone("6175552555");
    customer3.setAddressLine1("6251 Ingle Ln.");
    customer3.setAddressLine2(null);
    customer3.setCity("Boston");
    customer3.setState("MA");
    customer3.setPostalCode("51003");
    customer3.setCountry("USA");
    customer3.setSalesRepEmployeeNumber(1188L);
    customer3.setCreditLimit(new BigDecimal("85100.00"));

  }

  @After
  public void tearDown() {
    clear();
  }

  private void clear() {
    customerService.removeAll(Arrays.asList(customer1, customer2, customer3));
  }

  @Test
  public void save_ok() {
    Customer result = customerService.save(customer1);
    assertThat(result, notNullValue());
    Customer actual = customerService.findById(result.getId());
    assertThat(actual, is(result));

    customer1.setId(actual.getId());
  }

  @Test
  public void saveAll_ok() {
    List<Customer> customers = customerService.saveAll(Arrays.asList(customer2, customer3));
    assertThat(customers, notNullValue());

    Customer actual2 = customerService.findById(customers.get(0).getId());
    Customer actual3 = customerService.findById(customers.get(1).getId());
    assertThat(actual2, is(customers.get(0)));
    assertThat(actual3, is(customers.get(1)));

    customer2.setId(actual2.getId());
    customer3.setId(actual3.getId());
  }


}
