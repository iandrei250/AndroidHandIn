package com.example.handinapp.Model;

import java.util.List;

public class FoodList {

    private List<Food> results;

    public FoodList(List<Food> results) {
        this.results = results;
    }

    public List<Food> getResults() {
        return results;
    }
}
