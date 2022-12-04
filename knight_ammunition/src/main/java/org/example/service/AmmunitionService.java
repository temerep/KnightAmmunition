package org.example.service;

import org.example.dao.DBManager;
import org.example.dao.IDao;
import org.example.entity.Ammunition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AmmunitionService {
    DBManager dbManager = DBManager.getInstance();


    public List<Ammunition> findAll() throws Exception {
        return dbManager.findAll();
    }

    public Ammunition findEntityById(int id) throws Exception {
        return dbManager.findEntityById(id);
    }

    public boolean delete(Ammunition ammunition) throws Exception {
        return dbManager.delete(ammunition);
    }

    public boolean delete(int id) throws Exception {
        return dbManager.delete(id);
    }

    public boolean create(Ammunition ammunition) throws Exception {
        return dbManager.create(ammunition);
    }

    public double computeTotalEquippedAmmunitionCost() throws Exception {
        List<Ammunition> all = dbManager.findAll();
        return all.stream()
                .map(Ammunition::getCost)
                .reduce(0d, Double::sum);
    }

    public List<Ammunition> getAmmunitionListSortedByWeight() throws Exception {
        List<Ammunition> all = dbManager.findAll();
        all.sort(Comparator.comparingDouble(Ammunition::getWeight));
        return all;
    }

    public List<Ammunition> getAmmunitionListInCostRange(long inclusiveStart, long inclusiveEnd) throws Exception {
        List<Ammunition> all = dbManager.findAll();
        Predicate<Ammunition> isInCostRange = x -> x.getCost() >= inclusiveStart
                                                && x.getCost() <= inclusiveEnd;
        return all.stream()
                .filter(isInCostRange)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
