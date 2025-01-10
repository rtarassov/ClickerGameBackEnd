package com.solodev.clickergamebackend;

import com.solodev.clickergamebackend.model.Token;
import com.solodev.clickergamebackend.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ClickerGameBackEndApplicationTests {

    @InjectMocks
    private PlayerService playerService;


    @Test
    void testGenerateRandomToken() {
        Token token = playerService.generateRandomToken();
        assertNotNull(token);
        assertTrue(token.value().length() > 0, "Token value should not be empty");
    }
}
