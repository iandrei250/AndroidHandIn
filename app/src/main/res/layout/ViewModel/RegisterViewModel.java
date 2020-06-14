package com.example.handin.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.handin.Model.Register;
import com.example.handin.Model.RegisterRepository;

import java.util.List;

public class RegisterViewModel extends AndroidViewModel {

    private RegisterRepository repository;
    private LiveData<List<Register>> allRegisters;


    public RegisterViewModel(@NonNull Application application) {
        super(application);
        repository = new RegisterRepository(application);
        allRegisters = repository.getAllRegisters();
    }


    public void insert(Register register)
    {
        repository.insert(register);
    }

    public LiveData<List<Register>> getAllRegisters()
    {
        return  allRegisters;
    }

}
