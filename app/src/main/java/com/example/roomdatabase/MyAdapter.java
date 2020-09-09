package com.example.roomdatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.StudentViewHolder> {
    Context studentctx;
    List<StudentEntity>list;

    public MyAdapter(Context studentctx, List<StudentEntity> list) {
        this.studentctx = studentctx;
        this.list = list;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new StudentViewHolder(LayoutInflater.from(studentctx)
        .inflate(R.layout.every_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.roll.setText(list.get(position).getRollnum());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MainActivity.database.studentDao().delete(list.get(position));
                MainActivity.viewModel.delete(list.get(position));
                Toast.makeText(studentctx,holder.name.getText(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView edit,name,roll,delete;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            edit=itemView.findViewById(R.id.text_edit);
            name=itemView.findViewById(R.id.text_username);
            roll=itemView.findViewById(R.id.text_rollnum);
            delete=itemView.findViewById(R.id.text_delete);
            /* fragments with live data */
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String nn=name.getText().toString();
                    String rr=roll.getText().toString();
                    Intent i=new Intent(studentctx,UpdateActivity.class);
                    i.putExtra("key1",nn);
                    i.putExtra("key2",rr);
                    studentctx.startActivity(i);
                }
            });
        }
    }
}
