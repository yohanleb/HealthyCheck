package com.yohan.healthycheck.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.yohan.healthycheck.Injection;
import com.yohan.healthycheck.R;
import com.yohan.healthycheck.data.APIController;
import com.yohan.healthycheck.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private APIController apiController;
    private RecyclerView rvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton cameraButton = findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(v -> {
            IntentIntegrator intentIntegrator = new IntentIntegrator(this);
            intentIntegrator.setBeepEnabled(false);
            intentIntegrator.initiateScan(IntentIntegrator.ALL_CODE_TYPES);
        });

        rvProducts = findViewById(R.id.recycler_view);
        TextView emptyListText = findViewById(R.id.empty_list_title);

        apiController = new APIController(this, Injection.getRestApiInstance(), this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE));

        ArrayList<Product> products = apiController.getDataFromCache();

        if (products.isEmpty()) {
            rvProducts.setVisibility(View.INVISIBLE);
        } else {
            emptyListText.setVisibility(View.INVISIBLE);
            this.refreshList(products, false);
        }
    }

    public void refreshList (List<Product> products, Boolean printSnackBar) {
        ProductsAdapter adapter = new ProductsAdapter(products);
        rvProducts.setAdapter(adapter);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        if (printSnackBar) {
            Snackbar.make(findViewById(android.R.id.content), R.string.product_added, Snackbar.LENGTH_SHORT)
                    .show();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        apiController.start(scanningResult.getContents());
    }
}
