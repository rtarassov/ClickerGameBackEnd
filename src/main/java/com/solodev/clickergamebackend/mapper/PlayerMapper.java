package com.solodev.clickergamebackend.mapper;

import com.solodev.clickergamebackend.dto.PlayerDTO;
import com.solodev.clickergamebackend.model.PlayerModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerMapper {
    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    PlayerDTO modelToDTO(PlayerModel playerModel);

}
