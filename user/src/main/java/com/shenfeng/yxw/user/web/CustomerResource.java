package com.shenfeng.yxw.user.web;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shenfeng.yxw.user.dao.CustomerRepository;
import com.shenfeng.yxw.user.domain.Customer;
import com.shenfeng.yxw.user.service.CustomerServiceAnnotation;
import com.shenfeng.yxw.user.service.CustomerServiceTxInCode;
import com.shenfeng.yxw.user.service.FeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mavlarn on 2018/1/20.
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerResource {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerResource.class);

    @Autowired
    private CustomerServiceAnnotation customerService;
    @Autowired
    private CustomerServiceTxInCode customerServiceInCode;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FeignService feignService;
//    @Autowired
//    private JmsTemplate jmsTemplate;
//

    @PostMapping("/annotation")
    public Customer createInAnnotation(@RequestBody Customer customer) {
        LOG.info("CustomerResource create in annotation create customer:{}", customer.getUsername());
        return customerService.create(customer);
    }

    @GetMapping("/annotation")
    public List<Customer> List() {

        return customerService.get();
    }

    @GetMapping("/asdas456")
    @HystrixCommand(fallbackMethod = "hystrixList")
    public String asdas456() {

        return "456";
    }
    @GetMapping("/feign")

    public String feign() {
        return feignService.get789();

    }

    public String hystrixList() {
        return "123";
    }
//    @PostMapping("/code")
//    public Customer createInCode(@RequestBody Customer customer) {
//        LOG.info("CustomerResource create in code create customer:{}", customer.getUsername());
//        return customerServiceInCode.create(customer);
//    }

//    @Transactional
//    @PostMapping("/message/annotation")
//    public void messageListener(@RequestParam String name) {
//        LOG.info("CustomerResource create in annotation create customer:{}", name);
//        jmsTemplate.convertAndSend("customer:msg1:new", name);
//    }
//
//    @Transactional
//    @PostMapping("/message/code")
//    public void messageCodeListener(@RequestParam String name) {
//        LOG.info("CustomerResource create in code create customer:{}", name);
//        jmsTemplate.convertAndSend("customer:msg2:new", name);
//    }


    @GetMapping("")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

}
