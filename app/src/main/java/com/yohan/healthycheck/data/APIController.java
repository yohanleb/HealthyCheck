package com.yohan.healthycheck.data;

import android.text.TextUtils;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yohan.healthycheck.model.APIResponse;
import android.content.SharedPreferences;
import com.yohan.healthycheck.model.Product;
import com.yohan.healthycheck.view.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class APIController implements Callback<APIResponse> {

    private MainActivity view;
    private OpenFoodFactsAPI openFoodFactsAPI;
    private SharedPreferences sharedPreferences;
    private List<Product> products;

    public APIController(MainActivity view, OpenFoodFactsAPI openFoodFactsAPI, SharedPreferences sharedPreferences) {
        this.view = view;
        this.openFoodFactsAPI = openFoodFactsAPI;
        this.sharedPreferences = sharedPreferences;
        this.products = getDataFromCache();
    }

    public void start(String idProduct) {
        Call<APIResponse> call = openFoodFactsAPI.loadAPIResponse(idProduct);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
        if(response.isSuccessful()) {
            APIResponse apiResponse = response.body();
            if (apiResponse.getProduct().getProductName() != null && apiResponse.getStatus() != 0) {
                products.add(apiResponse.getProduct());
                storeData(products);
                view.refreshList(products, true);
            } else {
                Toast.makeText(view, "Sorry, Product not found...", Toast.LENGTH_LONG).show();
            }
        } else {
            System.out.println("API Call Unsuccessful");
            List<Product> products = getDataFromCache();
            view.refreshList(products, false);
        }
    }

    @Override
    public void onFailure(Call<APIResponse> call, Throwable t) {
        t.printStackTrace();
    }

    private void storeData(List<Product> products) {
        Gson gson = new Gson();
        String listProductString = gson.toJson(products);
        sharedPreferences
                .edit()
                .putString("products_list", listProductString)
                .apply();
    }

    public ArrayList<Product> getDataFromCache() {
        String listProductString = sharedPreferences.getString("products_list", "");
        if(!TextUtils.isEmpty(listProductString)){
            Type listType = new TypeToken<List<Product>>(){}.getType();
            return new Gson().fromJson(listProductString, listType);
        }
        return new ArrayList<>();
    }
}
