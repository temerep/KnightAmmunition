package org.example.command;

import org.example.controller.AmmunitionController;

import java.sql.SQLException;

public class PrintAllAmmunitionSortedByWeightCommand extends AbstractCommand {

    public PrintAllAmmunitionSortedByWeightCommand(AmmunitionController ammunitionController) {
        super(ammunitionController);
    }

    @Override
    public void execute() throws SQLException, ClassNotFoundException {
        super.execute();
        ammunitionController.getAmmunitionListSortedByWeight();
    }
}
