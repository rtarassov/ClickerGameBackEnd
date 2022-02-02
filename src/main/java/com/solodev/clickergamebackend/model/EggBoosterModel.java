package com.solodev.clickergamebackend.model;


public record EggBoosterModel(Integer id,
                              String name,
                              Double boostMultiplier,
                              Double costToBuild) {
}
