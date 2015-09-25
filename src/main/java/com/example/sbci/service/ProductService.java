package com.example.sbci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbci.domain.Product;
import com.example.sbci.repository.ProductRepository;

@Service
public class ProductService implements Pagination {

  @Autowired
  ProductRepository productRepository;

  @Transactional(readOnly = true, timeout = 3)
  public Product findById(final Long id) {
    return productRepository.findOne(id);
  }

  @Transactional(readOnly = true, timeout = 3)
  public Product findByPk(final String productCode) {
    return productRepository.findByPk(productCode);
  }

  @Transactional(readOnly = true, timeout = 10)
  public Iterable<Product> findAll(int page, int size, String sort) {
    Pageable pager = new PageRequest(currentPage(page), size, Direction.ASC, sort);
    return productRepository.findAll(pager);
  }

  @Modifying
  @Transactional(rollbackFor = Exception.class, timeout = 3)
  public Product save(final Product product) {
    return productRepository.save(product);
  }

  @Modifying
  @Transactional(rollbackFor = Exception.class, timeout = 10)
  public List<Product> saveAll(final Iterable<Product> products) {
    return productRepository.save(products);
  }

  @Modifying
  @Transactional(rollbackFor = Exception.class, timeout = 3)
  public void remove(final Product product) {
    productRepository.delete(product);
  }

  @Modifying
  @Transactional(rollbackFor = Exception.class, timeout = 10)
  public void removeAll(final Iterable<Product> products) {
    productRepository.delete(products);
  }

}
