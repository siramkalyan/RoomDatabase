package com.example.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import org.w3c.dom.Entity;

import java.util.List;

public class StudentRepo {
    StudentDatabase studentdb;
    LiveData<List<StudentEntity>> listLiveData;
    public StudentRepo(Application app)
    {
        studentdb = StudentDatabase.getDatabase(
                app
        );
        listLiveData=studentdb.studentDao()
                .retrive();
    }
    public class MyAsyncTaskForInsert extends AsyncTask<StudentEntity,Void,Void>{

        @Override
        protected Void doInBackground(StudentEntity... studentEntities) {
            studentdb.studentDao().insert(studentEntities[0]);
            return null;
        }
    }
    public class MyAsyncTaskForupdate extends AsyncTask<StudentEntity,Void,Void>{

        @Override
        protected Void doInBackground(StudentEntity... studentEntities) {
            studentdb.studentDao().update(studentEntities[0]);
            return null;
        }
    }
    public class MyAsyncTaskForDelete extends AsyncTask<StudentEntity,Void,Void>{

        @Override
        protected Void doInBackground(StudentEntity... studentEntities) {
            studentdb.studentDao().delete(studentEntities[0]);
            return null;
        }
    }
    public void insert(StudentEntity entity)
    {
        new MyAsyncTaskForInsert().execute(entity);
    }
    public void update(StudentEntity entity)
    {
        new MyAsyncTaskForupdate().execute(entity);
    }
    public void delete(StudentEntity entity)
    {
        new MyAsyncTaskForDelete().execute(entity);
    }
    public LiveData<List<StudentEntity>> liveData(){
        return listLiveData;
    }
}
