package io.javabrains.jwt.controller;

import io.javabrains.jwt.repo.DemonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @Autowired
    private DemonRepo repo;

    @GetMapping("/hello")
    public String hello()
    {
        System.out.println(repo.count());
        return "Hello";
    }
}
