package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyAdapter adapter;
    StudentDatabase database;
    StudentEntity entity;
    List<StudentEntity> entityList ;
    RecyclerView recyler;
    EditText username,rollnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.edittext_username);
        rollnum=findViewById(R.id.edittext_rollno);
        recyler=findViewById(R.id.recycler_view);
        database= Room.databaseBuilder(this,StudentDatabase.class,"name")
                .allowMainThreadQueries().build();


    }

    public void saveData(View view) {
        String uname=username.getText().toString();
        String uroll=rollnum.getText().toString();
        entity=new StudentEntity();
        entity.setName(uname);
        entity.setRollnum(uroll);
        database.studentDao().insert(entity);
        Toast.makeText(this,"insert succes "+ uname,Toast.LENGTH_SHORT).show();


    }

    public void retriveData(View view) {
        entityList=database.studentDao().retrive();
        adapter=new MyAdapter(this,entityList);
        recyler.setLayoutManager(new LinearLayoutManager(this));
        recyler.setAdapter(adapter);
    }
}