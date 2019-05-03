package com.yohan.healthycheck.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.yohan.healthycheck.R;
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
        Picasso.get().load(product.getImage_url()).into(productImageView);

        TextView productName = findViewById(R.id.product_name);
        productName.setText(product.getProduct_name());

        TextView ingredients = findViewById(R.id.ingredients);
        ingredients.setText(product.getIngredients_text_fr());
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
