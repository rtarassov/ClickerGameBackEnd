package com.solodev.clickergamebackend.controller;

import com.solodev.clickergamebackend.model.PlayerModel;
import com.solodev.clickergamebackend.model.Token;
import com.solodev.clickergamebackend.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200/") //TODO: Remove this line when I don't host on my own computer anymore.
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/token")
    public Token generateToken() {
        return playerService.generateRandomToken();
    }

    @GetMapping("/findplayerbytoken")
    public PlayerModel findPlayerByToken(@RequestHeader(value = "token") String tokenValue) {
        return playerService.findPlayerByToken(tokenValue);
    }
}