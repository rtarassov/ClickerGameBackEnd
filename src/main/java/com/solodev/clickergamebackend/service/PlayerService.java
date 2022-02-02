package com.solodev.clickergamebackend.service;

import com.solodev.clickergamebackend.model.PlayerModel;
import com.solodev.clickergamebackend.model.Token;
import com.solodev.clickergamebackend.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class PlayerService {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Token generateRandomToken() {
        Token randomToken = new Token(UUID.randomUUID().toString());
        return randomToken;
    }

    public PlayerModel findPlayerByToken(String tokenValue) {
        String sql = "SELECT * from playerModel WHERE token = ?";
        PlayerModel playerModel = new PlayerModel();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tokenValue);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.OK);
                log.info("Found a player successfully.");
                log.info(responseEntity.toString());
                return playerModel;
            } else {
                ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                log.info("Didn't find a player with token: [" + tokenValue + "], returning an empty player.");
                log.info(responseEntity.toString());
                return playerModel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerModel;
    }
}
