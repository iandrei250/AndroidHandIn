package com.example.handinapp.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.handinapp.Model.Register;
import com.example.handinapp.R;
import com.example.handinapp.ViewModel.RegisterViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrationFragment extends Fragment {

    private TextInputLayout name;
    private TextInputLayout email;
    private TextInputLayout phonenumber;
    private TextInputLayout date;
    private Button button;

    private RegisterViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.registration, container, false);

        viewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);


        name = rootView.findViewById(R.id.input_v);
        email = rootView.findViewById(R.id.input_v1);
        phonenumber = rootView.findViewById(R.id.input_v2);
        date = rootView.findViewById(R.id.input_v3);
        button = rootView.findViewById(R.id.register);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext().getApplicationContext(),"Reservation registered", Toast.LENGTH_LONG).show();
                makeReservation();

            }
        });

        return rootView;

    }

    public void makeReservation()
    {
        String inputName = name.getEditText().getText().toString();
        String inputEmail = email.getEditText().getText().toString();
        String inputPhoneNumber = phonenumber.getEditText().getText().toString();
        String inputDate = date.getEditText().getText().toString();

        Register registration = new Register(inputName,inputEmail,inputPhoneNumber, inputDate);

        viewModel.insert(registration);

    }
}
