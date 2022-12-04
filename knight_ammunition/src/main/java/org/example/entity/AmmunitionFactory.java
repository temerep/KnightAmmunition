package org.example.entity;

import java.sql.SQLException;

public interface AmmunitionFactory {
    Shield createShield() throws SQLException, ClassNotFoundException;

    Sword createSword() throws SQLException, ClassNotFoundException;

    ChestPlate createChestPlate() throws SQLException, ClassNotFoundException;

    Helmet createHelmet() throws SQLException, ClassNotFoundException;

    Ammunition createRandomAmmunition() throws SQLException, ClassNotFoundException;
}
