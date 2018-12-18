package com.example.subhidev.venzo;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
 private EditText Role;
 private Button okay;
 FirebaseDatabase database;
 DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Role=(EditText)findViewById(R.id.rol);
        okay=(Button)findViewById(R.id.done);
        database = FirebaseDatabase.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("role");
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetData();

            }
        });
    }
    public void SetData(){
        String DataRole=Role.getText().toString().trim();

        GetData data=new GetData(DataRole);
        reference.push().setValue(data);
        if(DataRole.equals("admin")){
            Intent x=new Intent(getApplicationContext(),admin.class);
            startActivity(x);
        }
        else if(DataRole.equals("employee")){
            Intent y=new Intent(getApplicationContext(),employee.class);
            startActivity(y);
        }
    }

    }
