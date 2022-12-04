package org.example.command;

import org.example.controller.AmmunitionController;

import java.sql.SQLException;

public class DeleteAmmunitionCommandById extends AbstractCommand {

    public DeleteAmmunitionCommandById(AmmunitionController ammunitionController) {
        super(ammunitionController);
    }

    @Override
    public void execute() throws SQLException, ClassNotFoundException {
        super.execute();
        System.out.println("Enter ammunition ID to be deleted: ");
        int nextInt = scanner.nextInt();
        ammunitionController.delete(nextInt);
    }
}
