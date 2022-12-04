package org.example.view;

import org.example.command.ICommand;
import org.example.constants.Constants;
import org.example.controller.AmmunitionController;
import org.example.entity.Ammunition;

import org.example.gui.SwingView;
import org.example.service.AmmunitionService;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class AmmunitionView {
    AmmunitionController ammunitionController;
    AmmunitionService ammunitionService;
    JFrame jFrame;
//    {
//        jFrame = new JFrame();
//        jFrame.add(new SwingView(ammunitionController));
//        jFrame.setVisible(true);
//        swingView = ;
//        swingView.setVisible(true);
//    }

    public AmmunitionView(AmmunitionController ammunitionController, AmmunitionService ammunitionService) {
        this.ammunitionController = ammunitionController;
        this.ammunitionService = ammunitionService;
        jFrame = new JFrame("Knight Ammunition");
        jFrame.setMinimumSize(new Dimension(425, 500));
        jFrame.setSize(820, 600);
        jFrame.add(new SwingView(ammunitionController));
        //jFrame.setAlwaysOnTop(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }

    public void initView() {
        System.out.println("<<< Knight Equipment Management System >>>");
        updateView();
    }

    public void tableTitle() {
        System.out.println("ID\tTYPE\tNAME\tCOST\tWEIGTH\tDURABILITY\tPROPERTY\n");
    }
    public void updateView() {
        System.out.println("-".repeat(100));
//        StringBuilder stringBuilder = new StringBuilder()
//                .append("1 -> Print all ammunition\n")
//                .append("2 -> Delete ammunition by ID\n")
//                .append("3 -> Print ammunition by ID\n")
//                .append("4 -> Craft ammunition\n")
//                .append("5 -> Print total ammunition cost\n")
//                .append("6 -> Print all ammunition sorted by weight\n")
//                .append("7 -> Print all ammunition in cost range\n")
//                .append("0 -> Exit program\n");
//        System.out.println(stringBuilder);
    }

    public void printAmmunition(List<Ammunition> ammunitionList) {
        System.out.println("All equipped ammunition: \n");
        tableTitle();
        ammunitionList.forEach(System.out::println);
    }

    public void printDeleted(Ammunition ammunition) {
        System.out.println("Ammunition is deleted!\n");
        tableTitle();
        System.out.println(ammunition);
    }

    public void printAmmunitionById(int id, Ammunition ammunitionById) {
        System.out.println("Found ammunition by id=" + id + "\n");
        tableTitle();
        System.out.println(ammunitionById);
    }

    public void printCreated(Ammunition ammunition) {
        System.out.println("Crafting ammunition...\n");
        tableTitle();
        System.out.println(ammunition);
    }

    public void printTotalEquippedAmmunitionCost(double cost) {
        System.out.println("Total equipped ammunition cost = " + cost);
    }

    public void printAmmunitionSortedByWeight(List<Ammunition> ammunitionListSortedByWeight) {
        System.out.println("All ammunition sorted by weight: \n");
        tableTitle();
        ammunitionListSortedByWeight.forEach(System.out::println);
    }

    public void printAmmunitionInCostRange(List<Ammunition> ammunitionListInCostRange, long inclusiveStart, long inclusiveEnd) {
        String stringBuilder = "All ammunition in range [" +
                inclusiveStart +
                ":" +
                inclusiveEnd +
                "] by cost value:\n";
        System.out.println(stringBuilder);
        tableTitle();
        ammunitionListInCostRange.forEach(System.out::println);
    }
}
