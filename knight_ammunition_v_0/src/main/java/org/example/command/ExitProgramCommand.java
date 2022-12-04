package org.example.command;

import org.example.controller.AmmunitionController;

import java.sql.SQLException;

public class ExitProgramCommand extends AbstractCommand {


    public ExitProgramCommand(AmmunitionController ammunitionController) {
        super(ammunitionController);
    }

    @Override
    public void execute() throws SQLException, ClassNotFoundException {
        super.execute();
        scanner.close();
        System.exit(0);
    }
}
