package com.solodev.clickergamebackend.dto;

import lombok.Data;

@Data
public class EggBoosterDTO {

    private Object id;
    private String name;
    private Double boostMultiplier;
    private Long costToBuild;
}
