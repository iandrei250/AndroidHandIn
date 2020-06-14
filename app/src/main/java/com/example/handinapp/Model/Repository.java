package com.example.handinapp.Model;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private Repo repo;
    private static Repository instance;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public Repository()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spoonacular.com/food/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        repo = retrofit.create(Repo.class);

    }

    public MutableLiveData<List<Food>> getFoods(String query, int number, String key)
    {
        final MutableLiveData<List<Food>> foodData= new MutableLiveData<>();
        repo.getCo2(query,number,key).enqueue(new Callback<FoodList>() {
            @Override
            public void onResponse(Call<FoodList> call, Response<FoodList> response) {

                if (response.isSuccessful()) {

                    FoodList results = response.body();
                    List<Food> results2 = results.getResults();

                    foodData.setValue(results2);
                }
            }

            @Override
            public void onFailure(Call<FoodList> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

        return foodData;

    }


}
