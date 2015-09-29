package com.example.sbci.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sbci.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

  @Query(value = "select * from payment where customer_number = :customerNumber and check_number = :checkNumber limit 1", nativeQuery = true)
  Payment findByPk(@Param("customerNumber") Long customerNumber, @Param("checkNumber") String checkNumber);

  @Modifying(clearAutomatically = true)
  @Query(value = "update Payment p set p.amount = :amount where p.customerNumber = :customerNumber and checkNumber = :checkNumber")
  Integer updateAmount(@Param("customerNumber") Long customerNumber, @Param("checkNumber") String checkNumber, @Param("amount") BigDecimal amount);

}
