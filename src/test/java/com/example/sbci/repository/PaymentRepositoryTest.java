package com.example.sbci.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.sbci.App;
import com.example.sbci.domain.Payment;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class PaymentRepositoryTest {

  @Autowired
  PaymentRepository paymentRepository;

  @Test
  public void executeQueryCount() {
    Long count = paymentRepository.count();
    assertThat(count, is(273L));
  }

  @Test
  public void executeQueryFindOne() {
    Long id = 273L;
    Payment payment = paymentRepository.findOne(id);
    assertThat(payment, notNullValue());
    assertThat(payment.getId(), is(id));
  }

  @Test
  public void executeQueryFindByPk() {
    Long customerNumber = 475L;
    String  checkNumber = "JP113227";
    Payment payment = paymentRepository.findByPk(customerNumber, checkNumber);
    assertThat(payment, notNullValue());
    assertThat(payment.getCustomerNumber(), is(customerNumber));
    assertThat(payment.getCheckNumber(), is(checkNumber));
  }

  @Test
  public void executeQueryFindAll() {
    List<Payment> list = paymentRepository.findAll();
    assertThat(list, notNullValue());
    assertThat(list.size(), is(273));
  }

}
