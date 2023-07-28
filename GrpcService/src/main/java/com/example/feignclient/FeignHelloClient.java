package com.example.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "feignHelloClient", url = "http://localhost:8080") // Feign Client'ın tanıtılması ve hedef URL'nin belirtilmesi
public interface FeignHelloClient {
    @GetMapping("/hello")
    String sayHello(@RequestParam String name);
}
