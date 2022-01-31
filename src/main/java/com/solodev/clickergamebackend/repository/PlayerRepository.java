package com.solodev.clickergamebackend.repository;

import com.solodev.clickergamebackend.model.EggBoosterModel;
import com.solodev.clickergamebackend.model.PlayerModel;
import com.solodev.clickergamebackend.model.Token;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepository {
    List<PlayerModel> players = new ArrayList<>();
    List<EggBoosterModel> eggBoosters = new ArrayList<>();
    public PlayerRepository() {

        PlayerModel player1 = new PlayerModel("Jaanus", 0, 0d, 0d, eggBoosters, "");
        PlayerModel player2 = new PlayerModel("Richard", 1285, 5251d, 25125d, eggBoosters, "9e320abe-1d6f-4be9-9bef-b3dc58f19362");

        players.add(player1);
        players.add(player2);
    }

    public PlayerModel findPlayerByToken(String tokenValue) {
        return players.stream()
                .filter(k -> k.getPlayerToken().equals(tokenValue))
                .findFirst().orElse(null);
    }
}
