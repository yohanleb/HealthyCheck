package com.yohan.healthycheck.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.yohan.healthycheck.R;
import com.yohan.healthycheck.model.Product;

import java.util.List;

public class ProductsAdapter extends
        RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<Product> productsList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        private ImageView productImageView;
        private TextView productNameTextView;
        private TextView nutritionScoreTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            itemView.setOnClickListener(v -> v.getContext().startActivity(new Intent(v.getContext(), ProductDetailActivity.class)));

            productImageView = itemView.findViewById(R.id.product_image);
            productNameTextView = itemView.findViewById(R.id.product_name);
            nutritionScoreTextView = itemView.findViewById(R.id.nutrition_score);
        }
    }

    public ProductsAdapter(List<Product> contacts) {
        productsList = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View productView = inflater.inflate(R.layout.item_product, parent, false);

        return new ViewHolder(productView);
    }

    @Override
    public void onBindViewHolder(ProductsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Product product = productsList.get(position);

        // Set item views based on your views and data model
        ImageView imageView = viewHolder.productImageView;
        Picasso.get().load(product.getImage_url()).into(imageView);

        TextView textView = viewHolder.productNameTextView;
        textView.setText(product.getProduct_name());
        TextView textView2 = viewHolder.nutritionScoreTextView;
        textView2.setText(product.getNutrition_grade_fr().toUpperCase());
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }
}
