package com.example.handinapp.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Repo {

    @GET("menuItems/suggest")
    Call<FoodList> getCo2(@Query("query") String query,
                          @Query("number") int number,
                          @Query("apiKey") String key);

    @GET("menuItems/suggest?query=pork&number=15&apiKey=a22c46711bd3444a95c312fd98f3debf ")
    Call<FoodList> getFoods();
}
