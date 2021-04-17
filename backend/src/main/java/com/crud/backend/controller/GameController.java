package com.crud.backend.controller;
import com.crud.backend.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.backend.model.GameModel;
import java.util.List;



@RestController
public class GameController {
    
    @Autowired
    private GameService gameService; 

    @GetMapping("/getGames")
    @CrossOrigin
    public List<GameModel> getGames() {
       
        return (List<GameModel>) gameService.listGames();

    }

    
}
