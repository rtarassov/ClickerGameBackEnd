package com.solodev.clickergamebackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerModel {
    private String name;
    private Integer eggsClicked;
    private Double totalEggsProduced;
    private Double eggsInStorage;
    private List<EggBoosterModel> eggBoostersObtained;
    private String playerToken;
}
