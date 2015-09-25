package com.example.sbci.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

  @Query(value = "select * from customer where customer_number = :customerNumber limit 1", nativeQuery = true)
  Customer findByPk(@Param("customerNumber") Long customerNumber);

  Iterable<Customer> findByCustomerNameLike(String customerName, Sort sort);

  Iterable<Customer> findByCustomerNameLike(String customerName);

  Iterable<Customer> findByCustomerName(String customerName);

}
