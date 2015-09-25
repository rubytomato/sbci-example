package com.example.sbci.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query(name = "Product.findByDescriptionOrderByProductName")
  //@Query(value = "select * from product where product_description like :desc order by product_name asc", nativeQuery = true)
  public List<Product> findByDescOrderByProductName(@Param("desc") String desc);

}
