package org.example.command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CraftAmmunitionCommandTest extends AbstractCommandTest{

    CraftAmmunitionCommandTest() throws SQLException, ClassNotFoundException {
    }

    @BeforeEach
    void setUp() {
        storage.add(helmet);
        storage.add(chestPlate);
    }

    @AfterEach
    void tearDown() {
        storage.clear();
        storage = null;
    }

    @Test
    void execute() {

    }
}