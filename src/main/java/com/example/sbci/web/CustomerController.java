package com.example.sbci.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.sbci.domain.Customer;
import com.example.sbci.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
  final static Logger logger = LoggerFactory.getLogger(CustomerController.class);

  @Autowired
  CustomerService customerService;

  @RequestMapping(method = RequestMethod.GET)
  public String _index(Model model) {
    return index(model);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {
    logger.debug("CustomerController:[index] Passing through...");
    Iterable<Customer> result = customerService.findAll(1, 10, "id");
    model.addAttribute("result", result);
    return "Customer/index";
  }

  @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
  public String detail(@PathVariable("id") Long id, Model model) {
    logger.debug("CustomerController:[detail] Passing through...");
    Customer customer = customerService.findById(id);
    model.addAttribute("customer", customer);
    return "Customer/detail";
  }

  public void search() {
    Iterable<Customer> list = customerService.findByCustomerName("Classic", "customerName");
    if (list != null) {
      list.forEach(a -> {
        logger.debug("id:{} no:{} name:{}", a.getId(), a.getCustomerNumber(), a.getCustomerName());
      });
    } else {
      logger.debug("list is null");
    }
  }

}
