package com.solodev.clickergamebackend.mapper;

import com.solodev.clickergamebackend.dto.PlayerDTO;
import com.solodev.clickergamebackend.model.PlayerModel;
import org.mapstruct.Mapper;

@Mapper
public interface PlayerMapper {
    PlayerDTO modelToDTO(PlayerModel playerModel);
    PlayerModel dtoToModel(PlayerDTO playerDTO);
}
