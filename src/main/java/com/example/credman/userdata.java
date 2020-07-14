package com.example.credman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class userdata extends AppCompatActivity {
    databasehelper db;
    FloatingActionButton add, delete;
    ListView userlist;

    ArrayList<String> listItem;
    ArrayAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdata);
        db=new databasehelper(this);

        listItem=new ArrayList<>();

        add = findViewById(R.id.tred3);
        delete = findViewById(R.id.tred4);
        userlist=findViewById(R.id.tred13);

        viewdata();




        adddata();
        deletedata();
        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String namevalue;
                namevalue=userlist.getItemAtPosition(position).toString();
                Intent intent=new Intent(userdata.this,details.class);
                intent.putExtra("name",namevalue);
                startActivity(intent);

            }
        });

    }

    public void adddata() {
        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(userdata.this, addingdata.class));
                    }
                }
        );
    }

    public void deletedata() {
        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(userdata.this, deletedata.class));
                    }
                }
        );
    }
    private void viewdata(){
        Cursor cursor=db.viewdata();

        if(cursor.getCount()==0){
            Toast.makeText(this,"no data to show",Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1));
            }
            adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            userlist.setAdapter(adapter);
        }
    }
}