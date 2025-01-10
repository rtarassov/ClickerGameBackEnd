package com.solodev.clickergamebackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "player_egg_booster")
public class PlayerEggBoosterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "egg_booster_id")
    private Long eggBoosterId;
}
