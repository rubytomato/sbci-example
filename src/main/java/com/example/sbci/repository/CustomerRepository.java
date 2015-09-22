package com.example.sbci.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

  List<Customer> findByCustomerNameLike(String customerName, Sort sort);

  List<Customer> findByCustomerNameLike(String customerName);

  List<Customer> findByCustomerName(String customerName);

}
