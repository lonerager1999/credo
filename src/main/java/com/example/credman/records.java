package com.example.credman;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class records extends AppCompatActivity {
    databasehelper db;
    ListView e,b,c;
    ArrayList<String> listItems,listitem1,listitem2;
    ArrayAdapter adopter1,adapter2,adapter3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        db=new databasehelper(this);
        listItems=new ArrayList<>();
        listitem1=new ArrayList<>();
        listitem2=new ArrayList<>();
        e=findViewById(R.id.tred50);
        b=findViewById(R.id.tred51);
        c=findViewById(R.id.tred52);


        viewdata();

    }
    public void viewdata() {
        Cursor qes = db.showdata1();
        if (qes.getCount() == 0) {
                Toast.makeText(this, "No contacts to show", Toast.LENGTH_SHORT).show();
            } else {
                while (qes.moveToNext()) {
                    listItems.add(qes.getString(1));

                }
            }
        adopter1=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItems);
        e.setAdapter(adopter1);

        Cursor nes = db.showdata1();
        if (qes.getCount() == 0) {
            Toast.makeText(this, "No contacts to show", Toast.LENGTH_SHORT).show();
        } else {
            while (nes.moveToNext()) {
                listitem1.add(nes.getString(2));

            }
        }
        adapter2=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listitem1);
        b.setAdapter(adapter2);

        Cursor pes = db.showdata1();
        if (pes.getCount() == 0) {
            Toast.makeText(this, "No contacts to show", Toast.LENGTH_SHORT).show();
        } else {
            while (pes.moveToNext()) {
                listitem2.add(pes.getString(3));

            }
        }
        adapter3=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listitem2);
        c.setAdapter(adapter3);




     }


    }




