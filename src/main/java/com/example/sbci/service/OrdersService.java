package com.example.sbci.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbci.domain.Orders;
import com.example.sbci.repository.OrdersRepository;

@Service
public class OrdersService implements Pagination {

  @Autowired
  OrdersRepository ordersRepository;

  @Transactional(readOnly = true, timeout = 3)
  public Orders findById(final Long id) {
    return ordersRepository.findOne(id);
  }

  @Transactional(readOnly = true, timeout = 3)
  public Orders findByPk(final Long orderNumber) {
    return ordersRepository.findByPk(orderNumber);
  }

  @Transactional(readOnly = true, timeout = 10)
  public Iterable<Orders> findAll(int page, int size, String sort) {
    Pageable pager = new PageRequest(currentPage(page), size, Direction.ASC, sort);
    return ordersRepository.findAll(pager);
  }

  @Transactional(readOnly = true, timeout = 10)
  public List<Orders> findByOrderDateRange(Date from, Date to) {
    return ordersRepository.findByOrderDateRange(from, to);
  }

  @Modifying
  @Transactional(rollbackFor = {Exception.class}, timeout = 3)
  public Orders save(final Orders order) {
    return ordersRepository.save(order);
  }

  @Modifying
  @Transactional(rollbackFor = {Exception.class}, timeout = 10)
  public List<Orders> saveAll(final Iterable<Orders> orders) {
    return ordersRepository.save(orders);
  }

  @Modifying(clearAutomatically = true)
  @Transactional(rollbackFor = {Exception.class}, timeout = 3)
  public void remove(final Orders order) {
    ordersRepository.delete(order);
  }

  @Modifying(clearAutomatically = true)
  @Transactional(rollbackFor = {Exception.class}, timeout = 10)
  public void removeAll(final Iterable<Orders> orders) {
    ordersRepository.delete(orders);
  }

}
