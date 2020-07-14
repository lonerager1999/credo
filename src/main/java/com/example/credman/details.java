package com.example.credman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class details extends AppCompatActivity {
    databasehelper db;
    TextView name,email,credit;
    Button cred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        db=new databasehelper(this);
        name=findViewById(R.id.tred24);
        email=findViewById(R.id.tred26);
        credit=findViewById(R.id.tred28);
        cred=findViewById(R.id.tred29);
        name.setText(getIntent().getStringExtra("name"));
        viewdata();
        trancred();

    }
    public void viewdata(){
        Cursor bes=db.display(name.getText().toString());
        if(bes.getCount()==0)
        {
            Toast.makeText(this,"No User to show",Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(bes.moveToNext()){
                email.setText(bes.getString(2));

                credit.setText(bes.getString(3));

            }
        }

    }
    public void trancred(){
        cred.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {startActivity(new Intent(details.this, transfer.class));
                    }
                }
        );
    }


}
