package org.example.entity;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AmmunitionFactoryImplTest {
    AmmunitionFactory ammunitionFactory = new AmmunitionFactoryImpl();
    @Test
    void createShield() throws SQLException, ClassNotFoundException {
        assertEquals("Shield",ammunitionFactory.createShield().getClass().getSimpleName());
    }

    @Test
    void createSword() throws SQLException, ClassNotFoundException {
        assertEquals("Sword",ammunitionFactory.createSword().getClass().getSimpleName());
    }

    @Test
    void createChestPlate() throws SQLException, ClassNotFoundException {
        assertEquals("ChestPlate",ammunitionFactory.createChestPlate().getClass().getSimpleName());
    }

    @Test
    void createHelmet() throws SQLException, ClassNotFoundException {
        assertEquals("Helmet",ammunitionFactory.createHelmet().getClass().getSimpleName());
    }

    @Test
    void createRandomAmmunition() throws SQLException, ClassNotFoundException {
        assertTrue(ammunitionFactory.createHelmet() instanceof Ammunition);
    }
}