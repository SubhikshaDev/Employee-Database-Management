package com.example.subhidev.venzo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class details extends AppCompatActivity {
     EditText employeeid,employeename,education,university,passing,employer1,duration;
    private Button submit;
     FirebaseDatabase database;
    DatabaseReference mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        employeeid = (EditText) findViewById(R.id.empid);
        employeename = (EditText) findViewById(R.id.empname);
        education = (EditText) findViewById(R.id.degree);
        university = (EditText) findViewById(R.id.college);
        passing = (EditText) findViewById(R.id.year);
        employer1 = (EditText) findViewById(R.id.employer);
        duration = (EditText) findViewById(R.id.dur);
        submit = (Button) findViewById(R.id.submit);
        database = FirebaseDatabase.getInstance();
        mref = FirebaseDatabase.getInstance().getReference().child("users");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();
            }
        });
    }

    public void AddData() {
        String Empid = employeeid.getText().toString().trim();
        String Empname = employeename.getText().toString().trim();
        String Degree = education.getText().toString().trim();
        String College = university.getText().toString().trim();
        String Year = passing.getText().toString().trim();
        String Employer = employer1.getText().toString().trim();
        String Duration = duration.getText().toString().trim();

        SaveData saveData = new SaveData(Empid,Empname,Degree,College,Year,Employer,Duration);
        mref.push().setValue(saveData);
    }
}
