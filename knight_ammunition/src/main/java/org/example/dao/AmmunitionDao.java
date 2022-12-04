package org.example.dao;

import org.example.entity.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AmmunitionDao extends AbstractDao<Ammunition> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AmmunitionDao.class);
    private static final String SELECT_ALL_FROM_AMMO = "SELECT * FROM ammo";
    private static final String SELECT_BY_ID = "SELECT * FROM ammo WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM ammo WHERE id = ?";
    private static final String INSERT_HELMET = "INSERT INTO ammo(type,name,cost,weight,durability,vision_level) VALUES(?,?,?,?,?,?)";
    private static final String INSERT_SWORD = "INSERT INTO ammo(type,name,cost,weight,durability,damage) VALUES(?,?,?,?,?,?)";
    private static final String INSERT_CHEST = "INSERT INTO ammo(type,name,cost,weight,durability,protection) VALUES(?,?,?,?,?,?)";
    private static final String INSERT_SHIELD = "INSERT INTO ammo(type,name,cost,weight,durability,protection) VALUES(?,?,?,?,?,?)";
    private static final String INSERT_RAND = "INSERT INTO ammo(type,name,cost,weight,durability) VALUES(?,?,?,?,?)";

    public AmmunitionDao() {
    }

    @NotNull
    private static Ammunition mapAmmo(ResultSet resultSet, String type) throws SQLException, ClassNotFoundException {
        Ammunition ammo;
        switch (type) {
            case "helmet":
                ammo = new Helmet(resultSet.getString("name"), resultSet.getDouble("cost"), resultSet.getDouble("weight"),
                        resultSet.getDouble("durability"), VisionLevel.valueOf(resultSet.getString("vision_level")));
                break;
            case "chestplate":
                ammo = new ChestPlate(resultSet.getString("name"), resultSet.getDouble("cost"), resultSet.getDouble("weight"),
                        resultSet.getDouble("durability"), resultSet.getDouble("protection"));
                break;
            case "shield":
                ammo = new Shield(resultSet.getString("name"), resultSet.getDouble("cost"), resultSet.getDouble("weight"),
                        resultSet.getDouble("durability"), resultSet.getDouble("protection"));
                break;
            case "sword":
                ammo = new Sword(resultSet.getString("name"), resultSet.getDouble("cost"), resultSet.getDouble("weight"),
                        resultSet.getDouble("durability"), resultSet.getDouble("damage"));
                break;
            default:
                throw new IllegalArgumentException("No such ammo type in switch");
        }
        ammo.setId(resultSet.getInt("id"));
        return ammo;
    }

    @Override
    public List<Ammunition> findAll() throws Exception {
        List<Ammunition> ammunition = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_AMMO);
            while (resultSet.next()) {
                String type = resultSet.getString("type");
                Ammunition ammo;
                try {
                    ammo = mapAmmo(resultSet, type);
                } catch (SQLException e) {
                    System.out.println("in switch!!!!");
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                ammunition.add(ammo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(statement);
        }
        return ammunition;
    }

    @Override
    public Ammunition findEntityById(int id) throws Exception {
        Ammunition ammunition = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String type = resultSet.getString("type");
                ammunition = mapAmmo(resultSet, type);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(preparedStatement);
        }
        return ammunition;
    }

    @Override
    public boolean delete(Ammunition t) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(int id) throws Exception {
        Ammunition ammunition;
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(preparedStatement);
        }
        return true;
    }

    @Override
    public boolean create(Ammunition t) throws Exception {
        String simpleName = t.getClass().getSimpleName().toLowerCase();
        PreparedStatement preparedStatement= null;

        switch (simpleName) {
            case "shield":
                preparedStatement = connection.prepareStatement(INSERT_SHIELD, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, simpleName);
                preparedStatement.setString(2, t.getName());
                preparedStatement.setDouble(3, t.getCost());
                preparedStatement.setDouble(4, t.getWeight());
                preparedStatement.setDouble(5, t.getDurability());
                preparedStatement.setDouble(6, Math.floor(new Random().nextDouble() * 256 *100) / 100);
                break;
            case "sword":
                preparedStatement = connection.prepareStatement(INSERT_SWORD, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, simpleName);
                preparedStatement.setString(2, t.getName());
                preparedStatement.setDouble(3, t.getCost());
                preparedStatement.setDouble(4, t.getWeight());
                preparedStatement.setDouble(5, t.getDurability());
                preparedStatement.setDouble(6, Math.floor(new Random().nextDouble() * 256 *100) / 100);
                break;
            case "helmet":
                preparedStatement = connection.prepareStatement(INSERT_HELMET, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, simpleName);
                preparedStatement.setString(2, t.getName());
                preparedStatement.setDouble(3, t.getCost());
                preparedStatement.setDouble(4, t.getWeight());
                preparedStatement.setDouble(5, t.getDurability());
                preparedStatement.setString(6, Math.round(Math.random()) == 1 ? "HALF_FACE" : "FULL_FACE");
                break;
            case "chestplate":
                preparedStatement = connection.prepareStatement(INSERT_CHEST, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, simpleName);
                preparedStatement.setString(2, t.getName());
                preparedStatement.setDouble(3, t.getCost());
                preparedStatement.setDouble(4, t.getWeight());
                preparedStatement.setDouble(5, t.getDurability());
                preparedStatement.setDouble(6, Math.floor(new Random().nextDouble() * 256 *100) / 100);
                break;

        }

        int i = preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            t.setId(generatedKeys.getInt(1));
        }

        return true;
    }

}
