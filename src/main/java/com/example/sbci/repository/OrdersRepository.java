package com.example.sbci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

  @Query(value = "select * from orders where order_number = :orderNumber limit 1", nativeQuery = true)
  Orders findByPk(@Param("orderNumber") Long orderNumber);

}
