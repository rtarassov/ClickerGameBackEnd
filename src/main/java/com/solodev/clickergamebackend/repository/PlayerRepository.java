package com.solodev.clickergamebackend.repository;

import com.solodev.clickergamebackend.dbConnection.DBUtil;
import com.solodev.clickergamebackend.model.EggBoosterModel;
import com.solodev.clickergamebackend.model.PlayerModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Slf4j
@Repository
public class PlayerRepository {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public PlayerRepository() { this.connection = DBUtil.getDBConnection();}

    public PlayerModel findPlayerByToken(String tokenValue) {
        this.connection = DBUtil.getDBConnection();

        String sql = "SELECT * FROM player_egg_booster peb\n" +
                "    LEFT JOIN player p ON peb.player_id = p.id\n" +
                "    LEFT JOIN egg_booster eb on peb.egg_booster_id = eb.id\n" +
                "    WHERE player_token = ?";
        PlayerModel playerModel = new PlayerModel();
        playerModel.setEggBoostersObtained(new ArrayList<>());
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tokenValue);
            resultSet = preparedStatement.executeQuery();

            var result = resultSet.next();

            if (result) {
                playerModel.setName(resultSet.getString("p.name"));
                playerModel.setEggsClicked(resultSet.getLong("eggsClicked"));
                playerModel.setTotalEggsProduced(resultSet.getLong("totalEggsProduced"));
                playerModel.setEggsInStorage(resultSet.getLong("eggsInStorage"));
                playerModel.setPlayerToken(resultSet.getString("player_token"));
                playerModel.setId(resultSet.getLong("p.id"));
            } else {
                log.info("Didn't find a player with token: [" + tokenValue + "], returning an empty player.");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            while(result) {
                log.info("Found a player successfully.");
                var id = resultSet.getLong("eb.id");
                var booster = playerModel.getEggBoostersObtained()
                        .stream()
                        .filter(k -> k.id().equals(id))
                        .findFirst()
                        .orElse(null);

                var eggBooster = new EggBoosterModel(resultSet.getLong("eb.id"),
                        resultSet.getString("eb.name"),
                        resultSet.getDouble("boostMultiplier"),
                        resultSet.getLong("cost"),
                        booster != null ? booster.count()+1 : 1);

                if (booster != null) {
                    playerModel.getEggBoostersObtained().remove(booster);
                }
                playerModel.getEggBoostersObtained().add(eggBooster);
                result = resultSet.next();
            }
            connection.close();
            return playerModel;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerModel;
    }
}
