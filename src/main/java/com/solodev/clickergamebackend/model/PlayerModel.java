package com.solodev.clickergamebackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerModel {
    private Long id;
    private String name;
    private Long eggsClicked;
    private Long totalEggsProduced;
    private Long eggsInStorage;
    private List<EggBoosterModel> eggBoostersObtained;
    private String playerToken;
}
