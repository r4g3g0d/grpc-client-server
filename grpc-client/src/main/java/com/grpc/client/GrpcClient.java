package com.grpc.client;

import com.grpc.HelloResponse;
import com.grpc.HelloRequest;
import com.grpc.HelloServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {


    public static void main(String[] args) throws InterruptedException {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub 
          = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
            .setFirstName("John")
            .setLastName("Smith")
            .build());

        System.out.println("[client] Response received from Server:\n" + helloResponse);

        channel.shutdown();
    }
}
