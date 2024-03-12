package com.example.localserver.service;

import com.demo.grpc.lib.HelloReply;
import com.demo.grpc.lib.HelloRequest;
import com.demo.grpc.lib.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServiceImpl extends SimpleGrpc.SimpleImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        HelloReply build = HelloReply.newBuilder().setMessage("hello," + name).build();
        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }
}
