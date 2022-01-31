package com.solodev.clickergamebackend.repository;

import com.solodev.clickergamebackend.dbConnection.DBUtil;
import com.solodev.clickergamebackend.model.EggBoosterModel;
import com.solodev.clickergamebackend.model.PlayerModel;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepository {
    List<PlayerModel> players = new ArrayList<>();
    List<EggBoosterModel> eggBoosters = new ArrayList<>();

    private Connection connection;
    private PreparedStatement preparedStatement;



    public PlayerRepository() {

        this.connection = DBUtil.getDBConnection();

        PlayerModel player1 = new PlayerModel("Jaanus", 0, 0d, 0d, eggBoosters, "");
        PlayerModel player2 = new PlayerModel("Richard", 1285, 5251d, 25125d, eggBoosters, "9e320abe-1d6f-4be9-9bef-b3dc58f19362");

        players.add(player1);
        players.add(player2);
    }

    public void savePlayerToDatabase(PlayerModel playerModel) {
        String sql = "INSERT INTO playerModel (name, eggsClicked, totalEggsProduced, eggsInStorage, playerToken)" +
                " VALUES (?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, playerModel.getName());
            preparedStatement.setInt(2, playerModel.getEggsClicked());
            preparedStatement.setDouble(3, playerModel.getTotalEggsProduced());
            preparedStatement.setDouble(4, playerModel.getEggsInStorage());
            preparedStatement.setString(5, playerModel.getPlayerToken());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Player saved with success.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PlayerModel findPlayerByToken(String tokenValue) {
        return players.stream()
                .filter(k -> k.getPlayerToken().equals(tokenValue))
                .findFirst().orElse(null);
    }


}
