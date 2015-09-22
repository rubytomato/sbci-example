package com.example.sbci.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.sbci.repository.Customer;
import com.example.sbci.repository.CustomerRepository;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
  final static Logger logger = LoggerFactory.getLogger(CustomerController.class);

  @Autowired
  CustomerRepository customerRepository;

  @RequestMapping(method = RequestMethod.GET)
  public String _index(Model model) {
    return index(model);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {
    logger.debug("CustomerController:[index] Passing through...");

    List<Customer> result = customerRepository.findAll();

    model.addAttribute("result", result);

    return "Customer/index";
  }

  @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
  public String detail(@PathVariable("id") Long id, Model model) {
    logger.debug("CustomerController:[detail] Passing through...");

    Customer customer = customerRepository.findOne(id);

    model.addAttribute("customer", customer);

    Sort sort = new Sort("customerName");

    List<Customer> list = customerRepository.findByCustomerNameLike("%Classic%", sort);
    //List<Customer> list = customerRepository.findByCustomerName("Mini Classics");

    if (list != null) {
      logger.debug("list is not null: {}", list.size());
      list.forEach(a -> {
        logger.debug("id:{} no:{} name:{}", a.getId(), a.getCustomerNumber(), a.getCustomerName());
      });
    } else {
      logger.debug("list is null");
    }

    return "Customer/detail";
  }

}
