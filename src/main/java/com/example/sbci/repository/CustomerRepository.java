package com.example.sbci.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

  @Query(value = "select * from customer where customer_number = :customerNumber limit 1", nativeQuery = true)
  Customer findByPk(@Param("customerNumber") Long customerNumber);

  List<Customer> findByCustomerNameLike(String customerName, Sort sort);

  List<Customer> findByCustomerNameLike(String customerName);

  List<Customer> findByCustomerName(String customerName);

}
