package org.example.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.example.entity.Ammunition;
import org.example.service.AmmunitionService;
import org.example.utils.ReflectionUtils;
import org.example.view.AmmunitionView;

import java.util.Arrays;
import java.util.List;

public class AmmunitionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AmmunitionService.class.getName());
    AmmunitionService ammunitionService;
    AmmunitionView ammunitionView;


    public AmmunitionController(AmmunitionService ammunitionService) {
        this.ammunitionService = ammunitionService;
        ammunitionView = new AmmunitionView(this, ammunitionService);
    }

    public void initView() {
        LOGGER.info("App is started");
        ammunitionView.initView();
    }

    public void updateView() {
        ammunitionView.updateView();
    }


    public void findAll() {
        try {
            ammunitionView.printAmmunition(ammunitionService.findAll());
        } catch (Exception e) {

            LOGGER.warn("Input data for " + ReflectionUtils.getCurrentExecutingMethod() + " was incorrect");
            e.printStackTrace();
            // throw new RuntimeException(e);
        }
    }

    public void findEntityById(int id) {
        try {
            Ammunition ammunitionById = ammunitionService.findEntityById(id);
            ammunitionView.printAmmunitionById(id, ammunitionById);
        } catch (Exception e) {
            LOGGER.warn("Input data for " + ReflectionUtils.getCurrentExecutingMethod() + " was incorrect");
            // throw new RuntimeException(e);
            e.printStackTrace();
        }
    }

    public void delete(Ammunition ammunition) {
        try {
            ammunitionService.delete(ammunition);
            ammunitionView.printDeleted(ammunition);
        } catch (Exception e) {
            LOGGER.warn("Input data for " + ReflectionUtils.getCurrentExecutingMethod() + " was incorrect");
            e.printStackTrace();
            // throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try {
            Ammunition entityById = ammunitionService.findEntityById(id);
            ammunitionService.delete(id);
            ammunitionView.printDeleted(entityById);
        } catch (Exception e) {
            LOGGER.warn("Input data for " + ReflectionUtils.getCurrentExecutingMethod() + " was incorrect");
            e.printStackTrace();
            // throw new RuntimeException(e);
        }
    }

    public void create(Ammunition ammunition) {
        try {
//            DBHandler dbHandler = new DBHandler();
            ammunitionService.create(ammunition);
//            dbHandler.addAmmunition(ammunition.getId(), ammunition.getName(), ammunition.getClass().getSimpleName(), ammunition.getCost(), ammunition.getWeight(), 0, "null", 0);
            ammunitionView.printCreated(ammunition);
        } catch (Exception e) {
            LOGGER.warn("Input data for " + ReflectionUtils.getCurrentExecutingMethod() + " was incorrect");
            e.printStackTrace();
            // throw new RuntimeException(e);
        }
    }


    public double computeTotalEquippedAmmunitionCost() {
        double l = -1;
        try {
            l = ammunitionService.computeTotalEquippedAmmunitionCost();
            ammunitionView.printTotalEquippedAmmunitionCost(Math.floor(l * 100)/100);
        } catch (Exception e) {
            LOGGER.warn("Input data for " + ReflectionUtils.getCurrentExecutingMethod() + " was incorrect");
            // throw new RuntimeException(e);
        }
        return l;
    }

    public List<Ammunition> getAmmunitionListSortedByWeight() {
        List<Ammunition> ammunitionListSortedByWeight = null;
        try {

            ammunitionListSortedByWeight = ammunitionService.getAmmunitionListSortedByWeight();
            ammunitionView.printAmmunitionSortedByWeight(ammunitionListSortedByWeight);
        } catch (Exception e) {
            LOGGER.warn("Input data for " + ReflectionUtils.getCurrentExecutingMethod() + " was incorrect");
            // throw new RuntimeException(e);
        }
        return ammunitionListSortedByWeight;
    }

    public List<Ammunition> getAmmunitionListInCostRange(long inclusiveStart, long inclusiveEnd) {
        List<Ammunition> ammunitionListInCostRange = null;
        try {
            ammunitionListInCostRange = ammunitionService.getAmmunitionListInCostRange(inclusiveStart, inclusiveEnd);
            ammunitionView.printAmmunitionInCostRange(ammunitionListInCostRange, inclusiveStart, inclusiveEnd);
        } catch (Exception e) {
            LOGGER.warn("Input data for " + ReflectionUtils.getCurrentExecutingMethod() + " was incorrect");
            // throw new RuntimeException(e);
        }
        return ammunitionListInCostRange;
    }
}
