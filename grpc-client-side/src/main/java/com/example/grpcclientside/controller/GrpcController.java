package com.example.grpcclientside.controller;


import com.example.grpcclientside.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/test")
    public String test(String name) {
        return clientService.sendMsg(name);
    }
}
