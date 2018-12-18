package com.example.subhidev.venzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class report extends AppCompatActivity {
private EditText Getid,Getreport;
 private Button submit2;
 FirebaseDatabase database;
 DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Getid = (EditText) findViewById(R.id.eID);
        Getreport = (EditText) findViewById(R.id.rep);
        submit2 = (Button) findViewById(R.id.but);
        database = FirebaseDatabase.getInstance();
        ref = FirebaseDatabase.getInstance().getReference().child("report");
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Generatereport();

            }
        });
    }
        public void Generatereport(){
            String EmployeeID1=Getid.getText().toString().trim();
            String Report=Getreport.getText().toString().trim();

        Writedata reportdata=new Writedata(EmployeeID1,Report);
        ref.push().setValue(reportdata);

    }
}
