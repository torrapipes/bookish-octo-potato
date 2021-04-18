package com.crud.backend.controller;
import com.crud.backend.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(
        value = "/createGame",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @CrossOrigin
    public String createGame(@RequestBody GameModel game) {
        gameService.save(game);
        return "hi";
    }

    
}
