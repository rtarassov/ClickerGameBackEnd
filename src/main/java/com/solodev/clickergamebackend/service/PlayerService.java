package com.solodev.clickergamebackend.service;

import com.solodev.clickergamebackend.model.PlayerModel;
import com.solodev.clickergamebackend.model.Token;
import com.solodev.clickergamebackend.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerService {

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
