package com.yohan.healthycheck.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String generic_name;
    private String product_name;
    private String ingredients_text_fr;
    private String nutrition_grade_fr;
    private String image_url;
    //private List<Nutriment> nutriments // If got time...

    public String getImage_url() {
        return image_url;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getGeneric_name() {
        return generic_name;
    }

    public String getIngredients_text_fr() {
        return ingredients_text_fr;
    }

    public String getNutrition_grade_fr() {
        return nutrition_grade_fr;
    }
}
