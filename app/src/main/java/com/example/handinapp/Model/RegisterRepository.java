package com.example.handinapp.Model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RegisterRepository {

    private RegisterDao registerDao;
    private LiveData<List<Register>> allRegisters;

    public RegisterRepository(Application application)
    {
        RegisterDatabase database = RegisterDatabase.getInstance(application);
        registerDao = database.registerDao();
        allRegisters = registerDao.getAllRegisters();
    }

    public LiveData<List<Register>> getAllRegisters()
    {
        return allRegisters;
    }

    public void insert(Register register)
    {
        new InsertRegisterAsyncTask(registerDao).execute(register);
    }

    private static class InsertRegisterAsyncTask extends AsyncTask<Register, Void, Void>
    {
        private RegisterDao registerDao;
        private InsertRegisterAsyncTask(RegisterDao registerDao)
        {
            this.registerDao = registerDao;
        }

        @Override
        protected Void doInBackground(Register... registers) {
            registerDao.insert(registers[0]);
            return null;
        }
    }
}
