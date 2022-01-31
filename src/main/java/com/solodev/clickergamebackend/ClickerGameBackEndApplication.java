package com.solodev.clickergamebackend;

import com.solodev.clickergamebackend.model.EggBoosterModel;
import com.solodev.clickergamebackend.model.PlayerModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class ClickerGameBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClickerGameBackEndApplication.class, args);
    }
}
