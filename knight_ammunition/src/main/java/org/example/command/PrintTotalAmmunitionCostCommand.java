package org.example.command;

import org.example.controller.AmmunitionController;

import java.sql.SQLException;

public class PrintTotalAmmunitionCostCommand extends AbstractCommand {

    public PrintTotalAmmunitionCostCommand(AmmunitionController ammunitionController) {
        super(ammunitionController);
    }

    @Override
    public void execute() throws SQLException, ClassNotFoundException {
        super.execute();
        ammunitionController.computeTotalEquippedAmmunitionCost();
    }
}
