package com.shenfeng.yxw.user.dao;



import com.shenfeng.yxw.user.domain.Customer;
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
