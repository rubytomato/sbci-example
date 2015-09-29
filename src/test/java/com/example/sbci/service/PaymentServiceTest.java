package com.example.sbci.service;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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
import com.example.sbci.DateHelper;
import com.example.sbci.domain.Payment;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class PaymentServiceTest {

  @Autowired
  PaymentService paymentService;

  Payment payment1;
  Payment payment2;
  Payment payment3;

  @Before
  public void setup() {
    payment1 = new Payment();
    payment1.setCustomerNumber(496L);
    payment1.setCheckNumber("EU531600");
    payment1.setPaymentDate(DateHelper.parse("2013-05-25"));
    payment1.setAmount(new BigDecimal("30253.75"));

    payment2 = new Payment();
    payment2.setCustomerNumber(496L);
    payment2.setCheckNumber("MB342426");
    payment2.setPaymentDate(DateHelper.parse("2011-07-16"));
    payment2.setAmount(new BigDecimal("32077.44"));

    payment3 = new Payment();
    payment3.setCustomerNumber(496L);
    payment3.setCheckNumber("MN89921");
    payment3.setPaymentDate(DateHelper.parse("2012-12-31"));
    payment3.setAmount(new BigDecimal("52166.00"));

  }

  @After
  public void tearDown() {
    clear();
  }

  private void clear() {
    paymentService.removeAll(Arrays.asList(payment1, payment2, payment3));
  }

  @Test
  public void save_ok() {
    Payment result = paymentService.save(payment1);
    assertThat(result, notNullValue());
    Payment actual = paymentService.findById(result.getId());
    assertThat(actual, is(result));

    payment1.setId(actual.getId());
  }

  @Test
  public void saveAll_ok() {
    List<Payment> payments = paymentService.saveAll(Arrays.asList(payment2, payment3));
    assertThat(payments, notNullValue());

    Payment actual2 = paymentService.findById(payments.get(0).getId());
    Payment actual3 = paymentService.findById(payments.get(1).getId());
    assertThat(actual2, is(payments.get(0)));
    assertThat(actual3, is(payments.get(1)));

    payment2.setId(actual2.getId());
    payment3.setId(actual3.getId());
  }

  @Test
  public void updateAmount_ok() {
    Long customerNumber = 455L;
    String  checkNumber = "IR662429";

    BigDecimal a1 = new BigDecimal("32239.47");

    Integer u1 = paymentService.updateAmount(customerNumber, checkNumber, a1);
    assertThat(u1, is(1));

    Payment p1 = paymentService.findByPk(customerNumber, checkNumber);
    assertThat(p1, notNullValue());
    assertThat(p1.getAmount(), is(a1));
    System.out.println(p1.toString());

    BigDecimal a2 = new BigDecimal("77777.88");

    Integer u2 = paymentService.updateAmount(customerNumber, checkNumber, a2);
    assertThat(u2, is(1));

    Payment p2 = paymentService.findByPk(customerNumber, checkNumber);
    assertThat(p2, notNullValue());
    assertThat(p2.getAmount(), is(a2));
    System.out.println(p2.toString());
  }

}
