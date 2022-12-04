package org.example.command;

import org.example.controller.AmmunitionController;

import java.sql.SQLException;

public class PrintAmmunitionByIdCommand extends AbstractCommand {

    public PrintAmmunitionByIdCommand(AmmunitionController ammunitionController) {
        super(ammunitionController);
    }

    @Override
    public void execute() throws SQLException, ClassNotFoundException {
        super.execute();
        System.out.println("Enter ammunition ID to be printed: ");
        int nextInt = scanner.nextInt();
        ammunitionController.findEntityById(nextInt);
    }
}
