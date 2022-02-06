package com.solodev.clickergamebackend.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("player_egg_booster")
public class PlayerEggBoosterModel extends Model {

    public Object getId() {
        return get("id");
    }

    public Long getPlayerId() {
        return getLong("player_id");
    }

    public Long getEggBoosterId() {
        return getLong("egg_booster_id");
    }

}
