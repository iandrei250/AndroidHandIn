package com.example.handinapp;

import androidx.lifecycle.LiveData;

import com.example.handinapp.Model.Food;
import com.example.handinapp.Model.Repository;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private Repository repo;


    @Before
    public void setup()
    {
        repo = Repository.getInstance();
    }
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testApi()
    {
        Food food = new Food("sdafjh",17);
        LiveData<List<Food>> foods = repo.getFoods("pork",30, "a22c46711bd3444a95c312fd98f3debf");
        assertEquals(food.getClass(),foods.getValue().get(0));
    }
}