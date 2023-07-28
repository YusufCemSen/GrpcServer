package com.example.grpcserver;

import com.example.grpc.GreeterServiceGrpc;
import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService // gRPC servisini Spring Boot uygulamasına tanıtma
public class GreeterServiceImpl extends GreeterServiceGrpc.GreeterServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = "Hello, " + request.getName() + "!";
        HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
