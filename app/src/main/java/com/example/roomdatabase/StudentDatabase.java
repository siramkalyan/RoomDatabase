package com.example.roomdatabase;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = StudentEntity.class,version = 1,exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();
    public static StudentDatabase database;
    public static synchronized StudentDatabase getDatabase(Context ctx){
        if (database==null){
            database= Room.databaseBuilder(ctx,StudentDatabase.class,"name")
                    .allowMainThreadQueries().build();
        }
        return database;
    }
}

