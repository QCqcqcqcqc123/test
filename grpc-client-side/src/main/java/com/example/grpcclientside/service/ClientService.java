package com.example.grpcclientside.service;

import com.demo.grpc.lib.HelloReply;
import com.demo.grpc.lib.HelloRequest;
import com.demo.grpc.lib.SimpleGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @GrpcClient("cloud-server-side")
    private SimpleGrpc.SimpleBlockingStub blockingStub;

    public String sendMsg(String name) {
        HelloReply helloReply = blockingStub.sayHello(HelloRequest.newBuilder().setName(name).build());

        return helloReply.getMessage();
    }
}
