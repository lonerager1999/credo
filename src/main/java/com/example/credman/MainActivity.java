package com.example.credman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button user,details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.tred1);
        details=findViewById(R.id.tred2);
        viewuser();
        records();

    }
    public void viewuser(){
        user.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {startActivity(new Intent(MainActivity.this, userdata.class));
                    }
                }
        );
    }
    public void records(){
        details.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {startActivity(new Intent(MainActivity.this, records.class));
                    }
                }
        );
    }
}
