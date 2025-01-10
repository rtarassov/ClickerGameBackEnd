package com.solodev.clickergamebackend.service;

import com.solodev.clickergamebackend.dto.PlayerDTO;
import com.solodev.clickergamebackend.mapper.PlayerMapper;
import com.solodev.clickergamebackend.model.Token;
import com.solodev.clickergamebackend.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public Token generateRandomToken() {
        return new Token(UUID.randomUUID().toString());
    }

    public PlayerDTO findPlayerByToken(String tokenValue) {
        return playerMapper.modelToDTO(playerRepository.findByPlayerToken(tokenValue));
    }

    public void deliverEggsToStorage(Long eggsAmount, String playerToken) {
        var player = findPlayerByToken(playerToken);
        player.setEggsInStorage(eggsAmount + player.getEggsInStorage());

        playerRepository.save(playerMapper.dtoToModel(player));
    }
}
