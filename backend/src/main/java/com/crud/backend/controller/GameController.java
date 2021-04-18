package com.crud.backend.controller;
import com.crud.backend.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public GameModel createGame(@RequestBody GameModel game) {        
        return gameService.save(game);
    }

    @PutMapping(
        value = "/updateGame",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @CrossOrigin
    public GameModel updateGame(@RequestBody GameModel game) {
        return gameService.save(game);
    }

    @DeleteMapping("/deleteGame/{id}")
    @CrossOrigin
    public void deleteGame(@PathVariable("id") int id) {
        gameService.delete(id);
    }


    
}
