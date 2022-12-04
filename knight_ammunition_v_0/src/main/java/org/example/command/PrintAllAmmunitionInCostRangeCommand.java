package org.example.command;

import org.example.controller.AmmunitionController;

import java.sql.SQLException;

public class PrintAllAmmunitionInCostRangeCommand extends AbstractCommand {

    public PrintAllAmmunitionInCostRangeCommand(AmmunitionController ammunitionController) {
        super(ammunitionController);
    }

    @Override
    public void execute() throws SQLException, ClassNotFoundException {
        super.execute();
        System.out.println("Enter inclusive start and end boundaries for ammunition cost to be printed: ");
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        ammunitionController.getAmmunitionListInCostRange(start, end);
    }
}
