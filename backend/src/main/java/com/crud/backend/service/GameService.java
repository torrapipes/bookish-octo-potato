package com.crud.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.crud.backend.model.GameModel;
import com.crud.backend.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameModel> listGames() {
        return (List<GameModel>) gameRepository.findAll();
    }

    public GameModel save(GameModel game) {
        gameRepository.save(game);
        return game;
    }


}