package com.example.credman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class transfer extends AppCompatActivity {
    databasehelper db;
    EditText from,to,credi;

    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        db=new databasehelper(this);
        from=findViewById(R.id.tred32);
        to=findViewById(R.id.tred34);
        credi=findViewById(R.id.tred36);
        send=findViewById(R.id.tred35);

        pdatedata();

    }
    public void pdatedata(){
        send.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Cursor ses=db.get(from.getText().toString());
                        while(ses.moveToNext()){
                            Integer a = Integer.parseInt(ses.getString(3));
                            Integer c=Integer.parseInt(credi.getText().toString());
                            Integer d=a-c;
                            db.updatedata(from.getText().toString(),
                                    d.toString());
                        }


                        Cursor kes=db.get1(to.getText().toString());
                        while(kes.moveToNext()){
                            Integer b = Integer.parseInt(kes.getString(3));
                            Integer c=Integer.parseInt(credi.getText().toString());
                            Integer d=b+c;
                            db.updatedata(to.getText().toString(),
                                    d.toString());
                        }
                        db.insertData1(from.getText().toString(), to.getText().toString(), credi.getText().toString());
                        startActivity(new Intent(transfer.this, userdata.class));

                    }
                }
        );
    }
}
