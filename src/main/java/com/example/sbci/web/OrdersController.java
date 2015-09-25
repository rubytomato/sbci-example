package com.example.sbci.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.sbci.repository.Orders;
import com.example.sbci.service.OrdersService;

@Controller
@RequestMapping(value = "/orders")
public class OrdersController {
  final static Logger logger = LoggerFactory.getLogger(OrdersController.class);

  @Autowired
  OrdersService ordersService;

  @RequestMapping(method = RequestMethod.GET)
  public String _index(Model model) {
    return index(model);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {
    logger.debug("OrdersController:[index] Passing through...");
    Iterable<Orders> result = ordersService.findAll(1, 10, "id");
    model.addAttribute("result", result);
    return "Orders/index";
  }

  @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
  public String detail(@PathVariable("id") Long id, Model model) {
    logger.debug("OrdersController:[detail] Passing through...");
    Orders order = ordersService.findById(id);
    model.addAttribute("order", order);
    return "Orders/detail";
  }

}
