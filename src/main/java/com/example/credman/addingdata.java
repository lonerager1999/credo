package com.example.credman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addingdata extends AppCompatActivity {
    EditText name,email,credits;
    Button add;
    databasehelper medb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addingdata);
        medb=new databasehelper(this);
        name=findViewById(R.id.tred7);
        email=findViewById(R.id.tred9);
        add=findViewById(R.id.tred12);
        credits=findViewById(R.id.tred11);
        AddData();
    }
    public void AddData() {
        add.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        boolean sem= medb.insertData(name.getText().toString(),
                                email.getText().toString(),
                                credits.getText().toString());
                        if(sem==true){
                            Toast.makeText(addingdata.this,"USER ADDED",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(addingdata.this,"ERROR",Toast.LENGTH_LONG).show();
                        }
                        startActivity(new Intent(addingdata.this, userdata.class));
                    }
                }
        );
    }

}
