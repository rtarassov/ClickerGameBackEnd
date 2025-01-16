package com.solodev.clickergamebackend.repository;

import com.solodev.clickergamebackend.model.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {

    PlayerModel findByPlayerToken(String playerToken);


}
