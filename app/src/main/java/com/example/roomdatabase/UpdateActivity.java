package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
EditText name,roll;
StudentEntity entity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name=findViewById(R.id.update_username);
        roll=findViewById(R.id.update_rollno);
        Intent i=getIntent();
        String nam=i.getStringExtra("key1");
        String rol=i.getStringExtra("key2");
        name.setText(nam);
        roll.setText(rol);
        roll.setKeyListener(null);

    }

    public void updateData(View view) {
        String myName=name.getText().toString();
        String myRoll=roll.getText().toString();
        entity=new StudentEntity();
        entity.setName(myName);
        entity.setRollnum(myRoll);
        MainActivity.viewModel.update(entity);
        //MainActivity.database.studentDao().update(entity);
        Toast.makeText(this,myName+" is update",Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}