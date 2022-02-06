package com.solodev.clickergamebackend.mapper;

import com.solodev.clickergamebackend.dto.EggBoosterDTO;
import com.solodev.clickergamebackend.model.EggBoosterModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EggBoosterMapper {
    EggBoosterMapper INSTANCE = Mappers.getMapper(EggBoosterMapper.class);

    EggBoosterDTO modelToDTO(EggBoosterModel eggBoosterModel);
}
