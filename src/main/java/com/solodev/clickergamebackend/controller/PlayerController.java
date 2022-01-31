package com.solodev.clickergamebackend.controller;

import com.solodev.clickergamebackend.model.PlayerModel;
import com.solodev.clickergamebackend.model.Token;
import com.solodev.clickergamebackend.service.PlayerService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/token")
    public Token generateToken() {
        return playerService.generateRandomToken();
    }

    @GetMapping
    public PlayerModel findPlayerByToken(@RequestHeader(value = "Token") String tokenValue) {
        return playerService.findPlayerByToken(tokenValue);
    }
}