package com.example.handinapp.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.handinapp.R;

import java.util.ArrayList;
import java.util.List;

public class RegisterAdapter extends RecyclerView.Adapter<RegisterAdapter.RegisterHolder> {

    private List<Register> registers = new ArrayList<>();

    public RegisterAdapter( List<Register> registers)
    {
        registers = this.registers;
    }

    @NonNull
    @Override
    public RegisterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.register_recycle_item, parent, false);
        return new RegisterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RegisterHolder holder, int position) {

        Register register =registers.get(position);

        holder.name.setText(register.getName());
        holder.email.setText(register.getEmail());
        holder.phone.setText(register.getPhonenumber());
        holder.date.setText(register.getDate());

    }

    @Override
    public int getItemCount() {
        return registers.size();
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
        notifyDataSetChanged();
    }

    class RegisterHolder extends RecyclerView.ViewHolder
    {

        private TextView name;
        private TextView email;
        private TextView phone;
        private TextView date;


        public RegisterHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_view_name);
            email = itemView.findViewById(R.id.text_view_email);
            phone = itemView.findViewById(R.id.text_view_phonenumber);
            date = itemView.findViewById(R.id.text_view_date);

        }
    }
}
