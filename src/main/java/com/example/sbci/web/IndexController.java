package com.example.sbci.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.sbci.DateHelper;
import com.example.sbci.domain.Order;

@Controller
@RequestMapping(value = "/")
public class IndexController {
  final static Logger logger = LoggerFactory.getLogger(IndexController.class);

  @RequestMapping(method = RequestMethod.GET)
  public String index(Model model) {
    logger.debug("IndexController:[index] Passing through...");

    List<Order> list = new ArrayList<>();

    Order order1 = new Order();
    order1.setId("1");
    order1.setOrderNumber(10100L);
    order1.setOrderDate(DateHelper.parse("2011-01-06"));
    order1.setRequiredDate(DateHelper.parse("2011-01-13"));
    order1.setShippedDate(DateHelper.parse("2011-01-10"));
    order1.setStatus("Shipped");
    order1.setComments(null);
    order1.setCustomerNumber(363L);
    list.add(order1);

    Order order2 = new Order();
    order2.setId("2");
    order2.setOrderNumber(10101L);
    order2.setOrderDate(DateHelper.parse("2011-01-09"));
    order2.setRequiredDate(DateHelper.parse("2011-01-18"));
    order2.setShippedDate(DateHelper.parse("2011-01-11"));
    order2.setStatus("Shipped");
    order2.setComments("Check on availability.");
    order2.setCustomerNumber(128L);
    list.add(order2);

    model.addAttribute("list", list);

    return "Index/index";
  }

}
