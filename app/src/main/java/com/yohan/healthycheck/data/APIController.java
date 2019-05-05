package com.yohan.healthycheck.data;

import android.widget.Toast;
import com.yohan.healthycheck.model.APIResponse;

import com.yohan.healthycheck.view.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIController implements Callback<APIResponse> {

    private MainActivity view;
    private OpenFoodFactsAPI openFoodFactsAPI;

    public APIController(MainActivity view, OpenFoodFactsAPI openFoodFactsAPI) {
        this.view = view;
        this.openFoodFactsAPI = openFoodFactsAPI;
    }

    public void start(String idProduct) {
        Call<APIResponse> call = openFoodFactsAPI.loadAPIResponse(idProduct);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
        if(response.isSuccessful()) {
            APIResponse apiResponse = response.body();
            if (apiResponse.getProduct().getProduct_name() != null && apiResponse.getStatus() != 0) {
                view.refreshList(apiResponse.getProduct());
                System.out.println("API Call Successful");
            } else {
                Toast.makeText(view, "Sorry, Product not found...", Toast.LENGTH_LONG).show();
            }
        }else {
            System.out.println("API Call Unsuccessful");
        }
    }

    @Override
    public void onFailure(Call<APIResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
