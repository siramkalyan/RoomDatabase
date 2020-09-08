package com.example.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userdetails")
public class StudentEntity {
    @ColumnInfo(name = "name")
    String name;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "rollnum")
    String rollnum;

    public String getName() {
        return name;
    }
/*Database Acess Object*/
    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getRollnum() {
        return rollnum;
    }

    public void setRollnum(@NonNull String rollnum) {
        this.rollnum = rollnum;
    }
}
