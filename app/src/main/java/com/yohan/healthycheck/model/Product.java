package com.yohan.healthycheck.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String generic_name;
    private String product_name;
    private String ingredients_text_with_allergens;
    private String nutrition_grade_fr;
    private String image_url;
    private NutrientLevels nutrient_levels;
    private Nutriments nutriments;

    public String getImageUrl() {
        return image_url;
    }

    public String getGenericName() {
        return generic_name;
    }

    public String getProductName() {
        return product_name;
    }

    public String getIngredientsTextFR() {
        return ingredients_text_with_allergens;
    }

    public NutrientLevels getNutrientLevels() {
        return nutrient_levels;
    }

    public Nutriments getNutriments() {
        return nutriments;
    }

    public String getNutritionGradeText() {
        if (nutrition_grade_fr == null) return "Unknown";
        switch (nutrition_grade_fr) {
            case "a":
                return "Excellent";
            case "b":
                return "Good";
            case "c":
                return "Mediocre";
            case "d":
            case "e":
                return "Poor";
            default:
                return "Unknown";
        }
    }

    public String getNutritionGradeColor() {
        if (nutrition_grade_fr == null) return "#bdc3c7";
        switch (nutrition_grade_fr) {
            case "a":
                return "#27ae60";
            case "b":
                return "#2ecc71";
            case "c":
                return "#e67e22";
            case "d":
            case "e":
                return "#e74c3c";
            default:
                return "#bdc3c7";
        }
    }
}
