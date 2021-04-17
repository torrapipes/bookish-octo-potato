package com.crud.backend.repository;

import com.crud.backend.model.GameModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GameRepository extends CrudRepository<GameModel, Integer> {
    


}
