package com.yohan.healthycheck.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.yohan.healthycheck.Injection;
import com.yohan.healthycheck.R;
import com.yohan.healthycheck.data.APIController;
import com.yohan.healthycheck.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private APIController apiController;
    private static ArrayList<Product> products = new ArrayList<>();
    private RecyclerView rvProducts;

    private FloatingActionButton cameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraButton = findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(v -> {
            IntentIntegrator intentIntegrator = new IntentIntegrator(this);
            intentIntegrator.setBeepEnabled(false);
            intentIntegrator.initiateScan(IntentIntegrator.ALL_CODE_TYPES);
        });

        rvProducts = findViewById(R.id.recycler_view);

        apiController = new APIController(this, Injection.getRestApiInstance());
        apiController.start("3029330003533");
    }

    public void refreshList (Product product) {
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);

        ProductsAdapter adapter = new ProductsAdapter(products);

        rvProducts.setAdapter(adapter);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        apiController.start(scanningResult.getContents());
    }
}
