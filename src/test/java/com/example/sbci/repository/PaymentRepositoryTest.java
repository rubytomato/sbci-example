package com.example.sbci.repository;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
    System.out.println(payment.toString());
  }

  @Test
  public void executeQueryFindAll() {
    List<Payment> list = paymentRepository.findAll();
    assertThat(list, notNullValue());
    assertThat(list.size(), is(273));
  }

  @Test
  @Transactional
  public void executeUpdateAmount() {
    Long customerNumber = 455L;
    String  checkNumber = "IR662429";

    BigDecimal a1 = new BigDecimal("32239.47");

    Integer u1 = paymentRepository.updateAmount(customerNumber, checkNumber, a1);
    assertThat(u1, is(1));

    Payment p1 = paymentRepository.findByPk(customerNumber, checkNumber);
    assertThat(p1, notNullValue());
    assertThat(p1.getAmount(), is(a1));
    System.out.println(p1.toString());


    BigDecimal a2 = new BigDecimal("77777.77");

    Integer u2 = paymentRepository.updateAmount(customerNumber, checkNumber, a2);
    assertThat(u2, is(1));

    Payment p2 = paymentRepository.findByPk(customerNumber, checkNumber);
    assertThat(p2, notNullValue());
    assertThat(p2.getAmount(), is(a2));
    System.out.println(p2.toString());

  }

}
