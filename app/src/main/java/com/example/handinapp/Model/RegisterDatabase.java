package com.example.handinapp.Model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Register.class, version = 2)
public abstract class RegisterDatabase extends RoomDatabase {

    private static RegisterDatabase instance;

    public abstract RegisterDao registerDao();

    public static synchronized RegisterDatabase getInstance(Context context)
    {
        if(instance==null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    RegisterDatabase.class, "register_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();

        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);
        new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private RegisterDao regDao;

        private PopulateDbAsyncTask(RegisterDatabase db)
        {
            regDao = db.registerDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            regDao.insert(new Register("Andrei", "andrei@andrei.com", "1234", "27-11-2020"));
            regDao.insert(new Register("Andrei1", "andrei@andrei.com", "12345", "27-11-2020"));
            regDao.insert(new Register("Andrei12", "andrei@andrei.com", "12346", "27-11-2020"));


            return null;
        }
    }

}
