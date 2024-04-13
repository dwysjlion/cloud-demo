package com.dwysj.feign.cilents;


import com.dwysj.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("userserver")
@RequestMapping("/user")
public interface UserClient {

    @GetMapping("/{id}")
    User queryById(@PathVariable("id") Long id);
}
