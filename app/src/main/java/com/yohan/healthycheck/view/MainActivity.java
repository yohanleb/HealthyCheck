package com.yohan.healthycheck.view;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.yohan.healthycheck.Injection;
import com.yohan.healthycheck.R;
import com.yohan.healthycheck.data.APIController;
import com.yohan.healthycheck.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Product> products;
    private RecyclerView rvProducts;

    private FloatingActionButton cameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraButton = findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(v -> {

        });

        rvProducts = findViewById(R.id.recycler_view);

        APIController apiController = new APIController(this, Injection.getRestApiInstance());
        apiController.start("3029330003533");
    }

    public void refreshList (Product product) {
        products = new ArrayList<>();
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
}
