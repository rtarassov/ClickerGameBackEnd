package com.solodev.clickergamebackend.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "player")
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "eggsClicked")
    private Long eggsClicked;

    @Column(name = "totalEggsProduced")
    private Long totalEggsProduced;

    @Column(name = "eggsInStorage")
    private Long eggsInStorage;

    @Column(name = "player_token")
    private String playerToken;
}
