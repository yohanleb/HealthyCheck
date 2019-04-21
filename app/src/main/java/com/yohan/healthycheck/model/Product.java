package com.yohan.healthycheck.model;

public class Product {
    private String generic_name;
    private String product_name;
    private String ingredients_text_fr;
    private String nutrition_grade_fr;
    private String image_url;
    //private List<Nutriment> nutriments // If got time...

    public String getProduct_name() {
        return product_name;
    }

    public String getGeneric_name() {
        return generic_name;
    }

    public String getIngredients_text_fr() {
        return ingredients_text_fr;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setIngredients_text_fr(String ingredients_text_fr) {
        this.ingredients_text_fr = ingredients_text_fr;
    }
}
