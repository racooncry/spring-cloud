package com.shenfeng.yxw.order.dao;


import com.shenfeng.yxw.order.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author yangxw
 * @Date 16/6/2020 上午8:38
 * @Description
 * @Version 1.0
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findOneByUsername(String username);
}
