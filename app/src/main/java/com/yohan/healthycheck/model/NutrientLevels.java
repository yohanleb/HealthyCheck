package com.yohan.healthycheck.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NutrientLevels implements Serializable {
    private String salt;
    private String fat;
    private String sugars;
    @SerializedName("saturated-fat")
    private String satured_fat;

    public String getSalt() {
        return salt;
    }

    public String getFat() {
        return fat;
    }

    public String getSugars() {
        return sugars;
    }

    public String getSaturedFat() {
        return satured_fat;
    }

    public String getNutrientLevelColor(String nutrient) {
        switch (nutrient) {
            case "high":
                return "#e74c3c";
            case "moderate":
                return "#e67e22";
            case "low":
                return "#27ae60";
            default:
                return "Unknown";
        }
    }

}
