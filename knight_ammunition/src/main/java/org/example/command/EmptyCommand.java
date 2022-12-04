package org.example.command;

import org.example.controller.AmmunitionController;

import java.sql.SQLException;

public class EmptyCommand extends AbstractCommand {

    public EmptyCommand(AmmunitionController ammunitionController) {
        super(ammunitionController);
    }

    @Override
    public void execute() throws SQLException, ClassNotFoundException {
        super.execute();
        System.out.println("Command by this ID does not exist...");
    }
}
