package com.solodev.clickergamebackend.service;

import com.solodev.clickergamebackend.model.EggBoosterModel;
import com.solodev.clickergamebackend.model.PlayerModel;
import com.solodev.clickergamebackend.model.Token;
import com.solodev.clickergamebackend.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {

    PlayerRepository playerRepository;
    List<EggBoosterModel> eggBoosters = new ArrayList<>();


    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
        EggBoosterModel eggBoosterModel = new EggBoosterModel("ChickenFactory", 2d, 50d);
        eggBoosters.add(eggBoosterModel);
    }
    public void saveEmployeeToDatabase(PlayerModel player) {
        PlayerModel player2 = new PlayerModel("Richard", 1285, 5251d,
                25125d, eggBoosters, "9e320abe-1d6f-4be9-9bef-b3dc58f19362");
        playerRepository.savePlayerToDatabase(player2);
    }

    public Token generateRandomToken() {
        Token randomToken = new Token(UUID.randomUUID().toString());
        return randomToken;
    }

    public PlayerModel findPlayerByToken(String tokenValue) {
        return playerRepository.findPlayerByToken(tokenValue);
    }


}
