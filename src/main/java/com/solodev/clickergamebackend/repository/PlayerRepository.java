package com.solodev.clickergamebackend.repository;

import com.solodev.clickergamebackend.model.PlayerModel;
import com.solodev.clickergamebackend.service.PlayerService;
import org.springframework.stereotype.Repository;


@Repository
public class PlayerRepository {
//    PlayerService playerService = new PlayerService();
    public PlayerRepository() {
    }

//    public PlayerModel findPlayerByToken(String tokenValue) {
//        return playerService.findPlayerByToken(tokenValue);
//    }
    // Do i need it? Its used in PlayerController from PlayerService
    // What is this repository for then?
}
