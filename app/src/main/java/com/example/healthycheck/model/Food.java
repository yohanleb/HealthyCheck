package com.example.healthycheck.model;

import android.graphics.drawable.Drawable;

public class Food {
    private String name;
    private Drawable image;
    private String ingredients;
    private String ingredientsWithAllergens;
    private String nutritionGrade; // nutrition_grade_fr (A to E)

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setIngredientsWithAllergens(String ingredientsWithAllergens) {
        this.ingredientsWithAllergens = ingredientsWithAllergens;
    }

    public void setNutritionGrade(String nutritionGrade) {
        this.nutritionGrade = nutritionGrade;
    }

    public String getName() {
        return name;
    }

    public Drawable getImage() {
        return image;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getIngredientsWithAllergens() {
        return ingredientsWithAllergens;
    }

    public String getNutritionGrade() {
        return nutritionGrade;
    }
}
