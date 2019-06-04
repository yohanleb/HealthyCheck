package com.yohan.healthycheck.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Nutriments implements Serializable {
    private Float salt_100g;
    private Float proteins_100g;
    private Float sugars_100g;
    @SerializedName("saturated-fat_100g")
    private Float saturated_fat_100g;

    public Float getSalt_100g() {
        return salt_100g;
    }

    public Float getProteins_100g() {
        return proteins_100g;
    }

    public Float getSugars_100g() {
        return sugars_100g;
    }

    public Float getSaturatedFat_100g() {
        return saturated_fat_100g;
    }
}
