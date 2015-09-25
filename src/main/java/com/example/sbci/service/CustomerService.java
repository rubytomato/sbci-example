package com.example.sbci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.sbci.repository.Customer;
import com.example.sbci.repository.CustomerRepository;

@Service
public class CustomerService implements Pagination {

  @Autowired
  CustomerRepository customerRepository;

  public Customer findById(final Long id) {
    return customerRepository.findOne(id);
  }

  public Customer findByPk(final Long id) {
    return customerRepository.findByPk(id);
  }

  public Iterable<Customer> findAll(int page, int size, String sort) {
    Pageable pager = new PageRequest(currentPage(page), size, Direction.ASC, sort);
    return customerRepository.findAll(pager);
  }

  public Iterable<Customer> findByCustomerName(final String customerName, final String sort) {
    Sort s = new Sort(sort);
    String name = "%" + customerName + "%";
    return customerRepository.findByCustomerNameLike(name, s);
  }

  //@Transactional(rollbackFor = Exception.class)
  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }

  //@Transactional(rollbackFor = Exception.class)
  public Iterable<Customer> saveAll(Iterable<Customer> customers) {
    return customerRepository.save(customers);
  }

  //@Transactional(rollbackFor = Exception.class)
  public void remove(Customer customer) {
    customerRepository.delete(customer);
  }

  //@Transactional(rollbackFor = Exception.class)
  public void removeAll(Iterable<Customer> customers) {
    customerRepository.delete(customers);
  }

}
