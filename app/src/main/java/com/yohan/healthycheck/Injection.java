package com.yohan.healthycheck;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yohan.healthycheck.data.OpenFoodFactsAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {

    private static final String BASE_URL = "https://fr.openfoodfacts.org/api/v0/";

    // TODO Faire un singleton.
    public static OpenFoodFactsAPI getRestApiInstance() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(OpenFoodFactsAPI.class);
    }
}
