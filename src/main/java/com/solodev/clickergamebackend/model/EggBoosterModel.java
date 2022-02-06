package com.solodev.clickergamebackend.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("egg_booster")
public class EggBoosterModel extends Model {

    public Object getId() {
        return get("id");
    }

    public String getName() {
        return getString("name");
    }

    public Double getBoostMultiplier() {
        return getDouble("boostMultiplier");
    }

    public Long getCostToBuild() {
        return getLong("cost");
    }

}
