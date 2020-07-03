package com.shenfeng.yxw.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author yangxw
 * @Date 3/7/2020 下午7:42
 * @Description
 * @Version 1.0
 */
@FeignClient(value = "order", path = "/order/api/customer")
public interface FeignService {
    @GetMapping("/789")
    String get789();

}
