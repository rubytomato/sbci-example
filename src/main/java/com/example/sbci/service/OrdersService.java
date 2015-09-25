package com.example.sbci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.sbci.repository.Orders;
import com.example.sbci.repository.OrdersRepository;

@Service
public class OrdersService implements Pagination {

  @Autowired
  OrdersRepository ordersRepository;

  public Orders findById(Long id) {
    return ordersRepository.findOne(id);
  }

  public Orders findByPk(Long id) {
    return ordersRepository.findByPk(id);
  }

  public Iterable<Orders> findAll(int page, int size, String sort) {
    Pageable pager = new PageRequest(currentPage(page), size, Direction.ASC, sort);
    return ordersRepository.findAll(pager);
  }

  //@Transactional(rollbackFor = Exception.class)
  public Orders save(Orders order) {
    return ordersRepository.save(order);
  }

  //@Transactional(rollbackFor = Exception.class)
  public Iterable<Orders> saveAll(Iterable<Orders> orders) {
    return ordersRepository.save(orders);
  }

  //@Transactional(rollbackFor = Exception.class)
  public void remove(Orders order) {
    ordersRepository.delete(order);
  }

  //@Transactional(rollbackFor = Exception.class)
  public void removeAll(Iterable<Orders> orders) {
    ordersRepository.delete(orders);
  }

}
