package com.solodev.clickergamebackend.config;

import com.solodev.clickergamebackend.mapper.PlayerMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public PlayerMapper playerMapper() {
        return Mappers.getMapper(PlayerMapper.class);
    }
}
