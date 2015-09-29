package com.example.sbci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbci.domain.Customer;
import com.example.sbci.repository.CustomerRepository;

@Service
public class CustomerService implements Pagination {

  @Autowired
  CustomerRepository customerRepository;

  @Transactional(readOnly = true, timeout = 3)
  public Customer findById(final Long id) {
    return customerRepository.findOne(id);
  }

  @Transactional(readOnly = true, timeout = 3)
  public Customer findByPk(final Long customerNumber) {
    return customerRepository.findByPk(customerNumber);
  }

  @Transactional(readOnly = true, timeout = 10)
  public Iterable<Customer> findAll(int page, int size, String sort) {
    Pageable pager = new PageRequest(currentPage(page), size, Direction.ASC, sort);
    return customerRepository.findAll(pager);
  }

  @Transactional(readOnly = true, timeout = 10)
  public Iterable<Customer> findByCustomerName(final String customerName, final String sort) {
    Sort s = new Sort(sort);
    String name = "%" + customerName + "%";
    return customerRepository.findByCustomerNameLike(name, s);
  }

  @Transactional(rollbackFor = Exception.class, timeout = 3)
  public Customer save(final Customer customer) {
    return customerRepository.save(customer);
  }

  @Transactional(rollbackFor = Exception.class, timeout = 10)
  public List<Customer> saveAll(final Iterable<Customer> customers) {
    return customerRepository.save(customers);
  }

  @Transactional(rollbackFor = Exception.class, timeout = 3)
  public void remove(final Customer customer) {
    customerRepository.delete(customer);
  }

  @Transactional(rollbackFor = Exception.class, timeout = 10)
  public void removeAll(final Iterable<Customer> customers) {
    customerRepository.delete(customers);
  }

}
