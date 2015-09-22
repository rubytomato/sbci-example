package com.example.sbci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

  //OrderDetail findByPk(Long orderNumber, String productCode);

}
