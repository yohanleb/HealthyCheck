package com.yohan.healthycheck.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.yohan.healthycheck.R;
import com.yohan.healthycheck.model.NutrientLevels;
import com.yohan.healthycheck.model.Nutriments;
import com.yohan.healthycheck.model.Product;

public class ProductDetailActivity extends AppCompatActivity {

    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.overridePendingTransition(R.anim.slide_in_right,
                R.anim.slide_out_left);

        product = (Product) getIntent().getSerializableExtra("Product");

        ImageView productImageView = findViewById(R.id.product_image);
        Picasso.get().load(product.getImageUrl()).into(productImageView);

        TextView productName = findViewById(R.id.product_name);
        productName.setText(product.getProductName());

        ImageView nutritionGradeColor = findViewById(R.id.nutrition_grade_color);
        nutritionGradeColor.setColorFilter(Color.parseColor(product.getNutritionGradeColor()));

        TextView nutritionGradeText = findViewById(R.id.nutrition_grade);
        nutritionGradeText.setText(product.getNutritionGradeText());

        TextView ingredientsText = findViewById(R.id.ingredients);
        // TODO : Revoir le bold
        ingredientsText.setText(Html.fromHtml(product.getIngredientsTextFR().replace("</span>", "</b>").replace("<span class=\"allergen\">", "<b>")));

        NutrientLevels nutrientLevels = product.getNutrientLevels();
        Nutriments nutriments = product.getNutriments();

        ImageView saturedFatLevelColor = findViewById(R.id.satured_fat_level_color);
        saturedFatLevelColor.setColorFilter(Color.parseColor(nutrientLevels.getNutrientLevelColor(nutrientLevels.getSaturedFat())));

        TextView saturedFatLevelText = findViewById(R.id.satured_fat_level_text);
        saturedFatLevelText.setText(String.format("%sg/100g", Float.toString(nutriments.getSaturatedFat_100g())));

        ImageView saltLevelColor = findViewById(R.id.salt_level_color);
        saltLevelColor.setColorFilter(Color.parseColor(nutrientLevels.getNutrientLevelColor(nutrientLevels.getSalt())));

        TextView saltLevelText = findViewById(R.id.salt_level_text);
        saltLevelText.setText(String.format("%sg/100g", Float.toString(nutriments.getSalt_100g())));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
            this.overridePendingTransition(R.anim.slide_in_left,
                    R.anim.slide_out_right);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.overridePendingTransition(R.anim.slide_in_left,
                R.anim.slide_out_right);
    }
}
