package com.crud.backend.controller;

import com.crud.backend.services.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    
    @Autowired
    private GameService gameService; 

    
}
