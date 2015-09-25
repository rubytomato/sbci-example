package com.example.sbci.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.sbci.domain.Payment;
import com.example.sbci.service.PaymentService;

@Controller
@RequestMapping(value = "/payment")
public class PaymentController {
  final static Logger logger = LoggerFactory.getLogger(PaymentController.class);

  @Autowired
  PaymentService paymentService;

  @RequestMapping(method = RequestMethod.GET)
  public String _index(Model model) {
    return index(model);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {
    logger.debug("PaymentController:[index] Passing through...");
    Iterable<Payment> result = paymentService.findAll(1, 10, "id");
    model.addAttribute("result", result);
    return "Payment/index";
  }

  @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
  public String detail(@PathVariable("id") Long id, Model model) {
    logger.debug("PaymentController:[detail] Passing through...");
    Payment payment = paymentService.findById(id);
    model.addAttribute("payment", payment);
    return "Payment/detail";
  }

}
