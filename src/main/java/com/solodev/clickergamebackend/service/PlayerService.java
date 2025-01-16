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
        Token token = new Token(UUID.randomUUID().toString());
        createNewPlayer(token.value());
        return new Token(UUID.randomUUID().toString());
    }

    private void createNewPlayer(String tokenValue) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setEggsClicked(0L);
        playerDTO.setEggsInStorage(0L);
        playerDTO.setTotalEggsProduced(0L);
        playerDTO.setPlayerToken(tokenValue);
        if (findPlayerByToken(tokenValue) == null) {
            playerRepository.save(playerMapper.dtoToModel(playerDTO));
        }
    }

    public PlayerDTO findPlayerByToken(String tokenValue) {
        return playerMapper.modelToDTO(playerRepository.findByPlayerToken(tokenValue));
    }

    public PlayerDTO deliverEggsToStorage(Long eggsAmount, String tokenValue) {
        var playerDTO = findPlayerByToken(tokenValue);
        playerDTO.setEggsInStorage(eggsAmount + playerDTO.getEggsInStorage());
        playerDTO.setTotalEggsProduced(playerDTO.getTotalEggsProduced() + eggsAmount);

        playerRepository.save(playerMapper.dtoToModel(playerDTO));
        return findPlayerByToken(tokenValue);
    }
}
