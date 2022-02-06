package com.solodev.clickergamebackend.repository;

import com.solodev.clickergamebackend.dto.EggBoosterDTO;
import com.solodev.clickergamebackend.dto.PlayerDTO;
import com.solodev.clickergamebackend.mapper.EggBoosterMapper;
import com.solodev.clickergamebackend.mapper.PlayerMapper;
import com.solodev.clickergamebackend.model.EggBoosterModel;
import com.solodev.clickergamebackend.model.PlayerModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepository {

    public PlayerDTO findPlayerByToken(String tokenValue) {
        List<PlayerModel> p = PlayerModel.findBySQL("SELECT * FROM player " +
                "WHERE player_token = ?", tokenValue);

        var player = PlayerMapper.INSTANCE.modelToDTO(p.get(0));

        List<EggBoosterDTO> boosters = EggBoosterModel
                .findBySQL("SELECT eb.* FROM player_egg_booster peb " +
                        "LEFT JOIN egg_booster eb ON peb.egg_booster_id = eb.id " +
                        "WHERE peb.player_id = ? ", player.getId())
                .stream()
                .map(model -> EggBoosterMapper.INSTANCE.modelToDTO((EggBoosterModel) model))
                .toList();

        player.setEggBoosters(boosters);

        return player;
    }

    public void updatePlayerEggsInStorage(PlayerDTO playerDTO) {

        var newTotal = playerDTO.getEggsInStorage() + playerDTO.getTotalEggsProduced();

        PlayerModel.update("eggsInStorage = ?, totalEggsProduced = ?", "player_token = ?"
                , playerDTO.getEggsInStorage(), newTotal, playerDTO.getPlayerToken() );
    }

}
