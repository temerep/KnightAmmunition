package org.example.entity;

import java.sql.SQLException;

public class Helmet extends Ammunition {
    private final VisionLevel visionLevel;

    public Helmet(String name, double cost, double weight, double durability, VisionLevel visionLevel) throws SQLException, ClassNotFoundException {
        super(name, cost, weight, durability);
        this.visionLevel = visionLevel;
    }

    public VisionLevel getVisionLevel() {
        return visionLevel;
    }

//    @Override
//    public String toString() {
//        return super.toString() + "vision level " + visionLevel + "]";
//    }
    @Override
    public String toString() {
        return super.toString() + "VISION_LVL:\t" + visionLevel;
    }
}
