package com.crud.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @CrossOrigin
    @GetMapping("/")
    public String sayHi() {
        return "Hey There";
    }

}
