package com.solodev.clickergamebackend.model;


public record EggBoosterModel(Long id,
                              String name,
                              Double boostMultiplier,
                              Long costToBuild,
                              Long count) {
}
