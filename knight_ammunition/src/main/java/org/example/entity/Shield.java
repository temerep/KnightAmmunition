package org.example.entity;

import java.sql.SQLException;

public class Shield extends Ammunition implements Protectable{
    private final double protection;

    public Shield(String name, double cost, double weight, double durability, double protection) throws SQLException, ClassNotFoundException {
        super(name, cost, weight, durability);
        this.protection = protection;
    }

    @Override
    public double getProtection() {
        return protection;
    }

//    @Override
//    public String toString() {
//        return super.toString() +
//                "protection=" + String.format("%.2f",protection) +
//                ']';
//    }
    @Override
    public String toString() {
        return super.toString() + "PROTECTION:\t" + String.format("%.2f",protection);
    }

}
