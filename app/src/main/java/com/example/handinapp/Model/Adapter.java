package com.example.handinapp.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.handinapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Food> foodList = new ArrayList<>();

    public Adapter( List<Food> foodList)
    {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Food currentItem = foodList.get(position);
        Random rand = new Random();
        int n = rand.nextInt(50);

        holder.mTextView1.setText("Name : " + currentItem.getTitle());
        holder.mTextView2.setText("Price : " + String.valueOf(n += 1) + " kr");
    }

    @Override
    public int getItemCount() {
        if(foodList!=null)
            return foodList.size();
        return 0;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            mTextView1 = itemView.findViewById(R.id.textview1);
            mTextView2 = itemView.findViewById(R.id.textview2);
        }
    }
}
