package com.solodev.clickergamebackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "egg_booster")
public class EggBoosterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "boostMultiplier")
    private Double boostMultiplier;

    @Column(name = "cost")
    private Long costToBuild;
}
