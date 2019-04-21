package com.yohan.healthycheck.data;

import com.yohan.healthycheck.model.APIResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OpenFoodFactsAPI {
    @GET("produit/{idProduct}.json")
    Call<APIResponse> loadAPIResponse(@Path("idProduct") String idProduct);
}
