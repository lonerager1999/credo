package com.example.credman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deletedata extends AppCompatActivity {
    databasehelper db;
    EditText name;
    Button remove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletedata);
        db=new databasehelper(this);

        name=findViewById(R.id.tred20);
        remove=findViewById(R.id.tred21);
        deletedata();
    }
    public void deletedata(){
        remove.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Integer del= db.deletedata(name.getText().toString());
                        if(del > 0){
                            Toast.makeText(deletedata.this,"selected data is deleted",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(deletedata.this,"ERROR ",Toast.LENGTH_LONG).show();
                        }
                        startActivity(new Intent(deletedata.this, userdata.class));
                    }
                }
        );
    }
}
