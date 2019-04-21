package com.yohan.healthycheck.data;

import com.yohan.healthycheck.model.APIResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yohan.healthycheck.view.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIController implements Callback<APIResponse> {

    private static final String BASE_URL = "https://fr.openfoodfacts.org/api/v0/";

    public void start(String idProduct) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        OpenFoodFactsAPI openFoodFactsAPI = retrofit.create(OpenFoodFactsAPI.class);

        Call<APIResponse> call = openFoodFactsAPI.loadAPIResponse(idProduct);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
        if(response.isSuccessful()) {
            APIResponse apiResponse = response.body();
            MainActivity.updateUi(apiResponse.getProduct().getGeneric_name() + " : " + apiResponse.getProduct().getProduct_name());

            // System.out.println(apiResponse.getProduct().getGeneric_name() + " : " + apiResponse.getProduct().getProduct_name());
            System.out.println("API Call Successful");
        }else {
            System.out.println("API Call Unsuccessful");
        }
    }

    @Override
    public void onFailure(Call<APIResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
