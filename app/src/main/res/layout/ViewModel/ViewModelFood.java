package com.example.handin.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.handin.Model.Food;
import com.example.handin.Model.Repository;

import java.util.List;

public class ViewModelFood extends ViewModel {

    private Repository repository;
    private MutableLiveData<List<Food>> mutableLiveData;


    public void init(String query)
    {
        if (mutableLiveData!=null)
        {
            return;
        }
        repository = Repository.getInstance();
        mutableLiveData=repository.getFoods(query, 30, "a22c46711bd3444a95c312fd98f3debf");
    }

    public LiveData<List<Food>> getFoodRepo()
    {
        return mutableLiveData;
    }



}
