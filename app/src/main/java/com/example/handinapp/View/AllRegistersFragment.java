package com.example.handinapp.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.handinapp.Model.Register;
import com.example.handinapp.Model.RegisterAdapter;
import com.example.handinapp.R;
import com.example.handinapp.ViewModel.RegisterViewModel;

import java.util.ArrayList;
import java.util.List;

public class AllRegistersFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RegisterViewModel viewModel;
    private RegisterAdapter adapter;
    private ArrayList<Register> exampleList;
    private RecyclerView.LayoutManager mLayoutManager;

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.allregistration_fragment, container, false);

        viewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.allrecycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);


        viewModel.getAllRegisters().observe(this, new Observer<List<Register>>() {
            @Override
            public void onChanged(List<Register> registers) {

                adapter.setRegisters(registers);
            }
        });

        adapter = new RegisterAdapter(exampleList);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }
}
