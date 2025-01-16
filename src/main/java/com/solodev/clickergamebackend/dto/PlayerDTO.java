package com.solodev.clickergamebackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@RequiredArgsConstructor
public class PlayerDTO {

    private Long id;
    private String name;
    private Long eggsClicked;
    private Long totalEggsProduced;
    private Long eggsInStorage;
    private String playerToken;

    private List<EggBoosterDTO> eggBoosters;
}
