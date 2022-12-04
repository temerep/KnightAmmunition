package org.example.entity;

import java.sql.SQLException;

public class Sword extends Ammunition implements Damageable{
    private final double damage;

    public Sword(String name, double cost, double weight, double durability, double damage) throws SQLException, ClassNotFoundException {
        super(name, cost, weight, durability);
        this.damage = damage;
    }

    @Override
    public double getDamage() {
        return damage;
    }

//    @Override
//    public String toString() {
//        return super.toString()+ "damage=" + damage + ']';
//    }
    @Override
    public String toString() {
        return super.toString()+ "DAMAGE:\t" + damage;
    }
}
