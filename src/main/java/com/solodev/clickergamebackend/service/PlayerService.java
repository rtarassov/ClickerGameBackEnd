package com.solodev.clickergamebackend.service;

import com.solodev.clickergamebackend.model.PlayerModel;
import com.solodev.clickergamebackend.model.Token;
import com.solodev.clickergamebackend.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PlayerService {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Autowired
    PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Token generateRandomToken() {
        Token randomToken = new Token(UUID.randomUUID().toString());
        return randomToken;
    }

    public PlayerModel findPlayerByToken(String tokenValue) {
        return playerRepository.findPlayerByToken(tokenValue);
    }
}
