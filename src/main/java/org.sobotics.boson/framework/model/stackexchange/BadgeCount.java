package org.sobotics.boson.framework.model.stackexchange;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class BadgeCount {
    private int bronze;
    private int gold;
    private int silver;

    public BadgeCount(int bronze, int gold, int silver) {
        this.bronze = bronze;
        this.gold = gold;
        this.silver = silver;
    }

    public BadgeCount() {
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    @Override
    public String toString() {
        return "BadgeCount{" +
                "bronze=" + bronze +
                ", gold=" + gold +
                ", silver=" + silver +
                '}';
    }

    public BadgeCount getBadgeCountFromJson(JsonObject json) {
        return new Gson().fromJson(json, BadgeCount.class);
    }

}