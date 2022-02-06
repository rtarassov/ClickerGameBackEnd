package com.solodev.clickergamebackend.service;

import com.solodev.clickergamebackend.dto.PlayerDTO;
import com.solodev.clickergamebackend.model.Token;
import com.solodev.clickergamebackend.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Token generateRandomToken() {
        Token randomToken = new Token(UUID.randomUUID().toString());
        return randomToken;
    }

    public PlayerDTO findPlayerByToken(String tokenValue) {
        return playerRepository.findPlayerByToken(tokenValue);
    }

    public void deliverEggsToStorage(Long eggsAmount, String playerToken) {
        var player = findPlayerByToken(playerToken);
        player.setEggsInStorage(eggsAmount + player.getEggsInStorage());

        playerRepository.updatePlayerEggsInStorage(player);
    }
}
