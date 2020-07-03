package com.shenfeng.yxw.order.web;



import com.shenfeng.yxw.order.dao.CustomerRepository;
import com.shenfeng.yxw.order.domain.Customer;
import com.shenfeng.yxw.order.service.CustomerServiceAnnotation;
import com.shenfeng.yxw.order.service.CustomerServiceTxInCode;
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



    @GetMapping("/789")
    public String asdas456() {

        return "789";
    }

    public String hystrixList() {
        return "123";
    }
}
