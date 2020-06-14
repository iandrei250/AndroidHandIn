package com.example.handinapp.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.handinapp.Model.Adapter;
import com.example.handinapp.Model.Food;
import com.example.handinapp.R;
import com.example.handinapp.ViewModel.ViewModelFood;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class NetworkingFragment extends Fragment {

    private ArrayList<Food> exampleList;
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ViewModelFood viewModel;
    private TextInputLayout input;
    private Button button;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.networking_fragment, container, false);


        viewModel = ViewModelProviders.of(this).get(ViewModelFood.class);
        button = rootView.findViewById(R.id.button);
        input = rootView.findViewById(R.id.input_v);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFoods();
            }
        });

        return rootView;
    }

    public void getFoods()
    {
        String data = input.getEditText().getText().toString().trim();

        viewModel.init(data);
        viewModel.getFoodRepo().observe(this, new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foodList) {
                mAdapter.setFoodList(foodList);
            }
        });

        mAdapter = new Adapter( exampleList);
        mRecyclerView.setAdapter(mAdapter);
    }


}
