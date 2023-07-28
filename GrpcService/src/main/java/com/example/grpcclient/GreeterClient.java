package com.example.grpcclient;

import com.example.grpc.GreeterServiceGrpc;
import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class GreeterClient {
    private final GreeterServiceGrpc.GreeterServiceBlockingStub blockingStub;

    public GreeterClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        this.blockingStub = GreeterServiceGrpc.newBlockingStub(channel);
    }

    public String sayHello(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloResponse response = blockingStub.sayHello(request);
        return response.getGreeting();
    }
}
