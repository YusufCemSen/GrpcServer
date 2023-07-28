package com.example.grpcclient;

import com.example.feignclient.FeignHelloClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final GreeterClient greeterClient;
    private final FeignHelloClient feignHelloClient;

    public HelloController(GreeterClient greeterClient, FeignHelloClient feignHelloClient) {
        this.greeterClient = greeterClient;
        this.feignHelloClient = feignHelloClient;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam String name) {
        // gRPC istemci kullanarak gRPC servisine çağrı yapma
        String grpcGreeting = greeterClient.sayHello(name);

        // Feign Client kullanarak HTTP çağrısı yapma
        String feignGreeting = feignHelloClient.sayHello(name);

        return "gRPC Greeting: " + grpcGreeting + ", Feign Greeting: " + feignGreeting;
    }
}
