package com.shenfeng.yxw.user.service;



import com.shenfeng.yxw.user.dao.CustomerRepository;
import com.shenfeng.yxw.user.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


/**
 * Created by mavlarn on 2018/1/24.
 */
@Service
@Slf4j
public class CustomerServiceTxInCode {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PlatformTransactionManager transactionManager;
//    @Autowired
//    private JmsTemplate jmsTemplate;
//
//    public Customer create(Customer customer) {
//        log.info("CustomerService In Code create customer:{}", customer.getUsername());
//        if (customer.getId() != null) {
//            throw new RuntimeException("用户已经存在");
//        }
//        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        //  def.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
//        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        def.setTimeout(15);
//        TransactionStatus status = transactionManager.getTransaction(def);
//        try {
//            customer.setUsername("Code:" + customer.getUsername());
//            customerRepository.save(customer);
//            jmsTemplate.convertAndSend("customer:msg:reply", customer.getUsername());
//
//            transactionManager.commit(status);
//            return customer;
//        } catch (Exception e) {
//            transactionManager.rollback(status);
//            throw e;
//        }
//    }
//
//
//    @JmsListener(destination = "customer:msg2:new")
//    public void createByListener2(String name) {
//        log.info("CustomerService In Code create customer:{}", name);
//        Customer customer = new Customer();
//        customer.setUsername("Code:" + name);
//        customer.setPassword("111111");
//        customer.setRole("User");
//
//        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        //  def.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
//        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        def.setTimeout(15);
//        TransactionStatus status = transactionManager.getTransaction(def);
//        try {
//
//            customerRepository.save(customer);
//            jmsTemplate.convertAndSend("customer:msg:reply", customer.getUsername());
//
//            transactionManager.commit(status);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            transactionManager.rollback(status);
//            throw e;
//        }
//    }
}
