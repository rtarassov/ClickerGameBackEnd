package com.solodev.clickergamebackend.controller;

import com.solodev.clickergamebackend.dto.PlayerDTO;
import com.solodev.clickergamebackend.model.Token;
import com.solodev.clickergamebackend.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    @PostMapping("/token")
    public Token generateToken() {
        return playerService.generateRandomToken();
    }

    @GetMapping("/token")
    public PlayerDTO findPlayerByToken(@RequestHeader(value = "token") String tokenValue) {
        return playerService.findPlayerByToken(tokenValue);
    }

    @PutMapping("/deliver")
    public ResponseEntity<PlayerDTO> deliverEggsToStorage(@RequestHeader(value = "token") String tokenValue,
                                                     @RequestParam Long amount) {
        PlayerDTO playerDTO = playerService.deliverEggsToStorage(amount, tokenValue);

        return ResponseEntity.ok().body(playerDTO);
    }
}