package com.solodev.clickergamebackend.model;

import lombok.Data;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("player")
public class PlayerModel extends Model {

    public Object getId() {
        return get("id");
    }

    public String getName() {
        return getString("name");
    }

    public Long getEggsClicked() {
        return getLong("eggsClicked");
    }

    public Long getTotalEggsProduced() {
        return getLong("totalEggsProduced");
    }

    public Long getEggsInStorage() {
        return getLong("eggsInStorage");
    }

    public String getPlayerToken() {
        return getString("player_token");
    }
}
