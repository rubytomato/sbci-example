package com.example.sbci.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sbci.domain.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

  @Query(value = "select * from orders where order_number = :orderNumber limit 1", nativeQuery = true)
  //@Query(value = "select o from Orders o where o.orderNumber = :orderNumber")
  Orders findByPk(@Param("orderNumber") Long orderNumber);

  @Query(value = "select customerNumber from Orders where id = :id")
  Long getCustomerNumber(@Param("id") Long id);

  @Query(name = "Orders.findByOrderDateRange")
  List<Orders> findByOrderDateRange(@Param("from") Date from, @Param("to") Date to);

}
