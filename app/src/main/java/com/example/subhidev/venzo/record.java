package com.example.subhidev.venzo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class record extends AppCompatActivity {


    private RecyclerView employRview;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<SaveData> memployList=new ArrayList<>();
    private employAdapter memployAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        init();
    }

    private void init() {
         employRview = (RecyclerView) findViewById(R.id.rview);
         mLayoutManager=new LinearLayoutManager(this);
         employRview.setLayoutManager(mLayoutManager);
         memployAdapter=new employAdapter(this,memployList);
         employRview.setAdapter(memployAdapter);
         fetchData();
    }

    private void fetchData() {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myref=FirebaseDatabase.getInstance().getReference().child("users");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot employsnapshot: dataSnapshot.getChildren())
                {
                    SaveData item=employsnapshot.getValue(SaveData.class);
                    memployList.add(item);
                }
                memployAdapter.notifyDataSetChanged();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }}

