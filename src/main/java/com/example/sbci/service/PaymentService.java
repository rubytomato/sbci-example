package com.example.sbci.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbci.domain.Payment;
import com.example.sbci.repository.PaymentRepository;

@Service
public class PaymentService implements Pagination {

  @Autowired
  PaymentRepository paymentRepository;

  @Transactional(readOnly = true, timeout = 3)
  public Payment findById(final Long id) {
    return paymentRepository.findOne(id);
  }

  @Transactional(readOnly = true, timeout = 3)
  public Payment findByPk(final Long customerNumber, final String checkNumber) {
    return paymentRepository.findByPk(customerNumber, checkNumber);
  }

  @Transactional(readOnly = true, timeout = 10)
  public Iterable<Payment> findAll(int page, int size, String sort) {
    Pageable pager = new PageRequest(currentPage(page), size, Direction.ASC, sort);
    return paymentRepository.findAll(pager);
  }

  @Transactional(rollbackFor = Exception.class, timeout = 3)
  public Payment save(Payment payment) {
    return paymentRepository.save(payment);
  }

  @Transactional(rollbackFor = Exception.class, timeout = 10)
  public List<Payment> saveAll(final Iterable<Payment> payments) {
    return paymentRepository.save(payments);
  }

  @Transactional(rollbackFor = Exception.class, timeout = 3)
  public void remove(final Payment payment) {
    paymentRepository.delete(payment);
  }

  @Transactional(rollbackFor = Exception.class, timeout = 10)
  public void removeAll(final Iterable<Payment> payments) {
    paymentRepository.delete(payments);
  }

  @Transactional(rollbackFor = Exception.class, timeout = 3)
  public Integer updateAmount(final Long customerNumber, final String checkNumber, final BigDecimal amount) {
    return paymentRepository.updateAmount(customerNumber, checkNumber, amount);
  }

}
