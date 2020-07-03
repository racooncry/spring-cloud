package com.shenfeng.yxw.order.service;



import com.shenfeng.yxw.order.dao.CustomerRepository;
import com.shenfeng.yxw.order.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Author yangxw
 * @Date 16/6/2020 上午8:39
 * @Description
 * @Version 1.0
 */
@Service
@Slf4j
public class CustomerServiceAnnotation {

    @Autowired
    private CustomerRepository customerRepository;

//    @Autowired
//    private JmsTemplate jmsTemplate;

    @Transactional
    public Customer create(Customer customer) {
        log.info("CustomerService In Annotation create customer:{}", customer.getUsername());
        if (customer.getId() != null) {
            throw new RuntimeException("用户已经存在");
        }
        customer.setUsername("Annotation:" + customer.getUsername());
//        jmsTemplate.convertAndSend("customer:msg:reply", customer.getUsername());

        return customerRepository.save(customer);
    }

    public List<Customer> get() {

        return customerRepository.findAll();
    }
//    @JmsListener(destination = "customer:msg1:new")
//    public void create(String name) {
//        log.info("CustomerService   In Annotation by listener create customer:{}", name);
//        Customer customer = new Customer();
//        customer.setUsername("Annotation:" + name);
//        customer.setPassword("111111");
//        customer.setRole("User");
//
//        customerRepository.save(customer);
//
//        jmsTemplate.convertAndSend("customer:msg:reply", customer.getUsername());
//
//    }
}
