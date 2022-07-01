package com.example.clientside;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoryApi {
    @GET("categories")
    Call<List<Category>> listCategories();

    @GET("categories/{id}")
    Call <Category> singleCategory(@Path("id") Long id);
}
