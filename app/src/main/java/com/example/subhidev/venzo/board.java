package com.example.subhidev.venzo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class board extends AppCompatActivity {
private ImageButton record,report;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

report= (ImageButton) findViewById(R.id.ib2);
record=(ImageButton) findViewById(R.id.ib1);


      record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mn=new Intent(getApplicationContext(),record.class);
                startActivity(mn);

            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exo=new Intent(getApplicationContext(),report.class);
                startActivity(exo);
            }
        });
    }
}
