package com.example.subhidev.venzo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class employee extends AppCompatActivity {
    EditText username,password;
    ProgressBar bar;
  //  Button req;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        username=(EditText) findViewById(R.id.editTextEmail);
        password=(EditText) findViewById(R.id.editTextPassword);
        bar=(ProgressBar) findViewById(R.id.progressBar);
        /*req=(Button)findViewById(R.id.ad);
        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent man=new Intent(employee.this,board.class);
                startActivity(man);
            }
        });*/


       Button login=(Button) findViewById(R.id.buttonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.isEmpty()) {
                    Toast.makeText(employee.this, "Enter email",
                            Toast.LENGTH_SHORT).show();

                } else if (pass.isEmpty()) {
                    Toast.makeText(employee.this, "Enter password",
                            Toast.LENGTH_SHORT).show();

                } else {
                    FirebaseAuth auth = FirebaseAuth.getInstance();
                    bar.setVisibility(View.VISIBLE);
                    auth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                bar.setVisibility(View.GONE);
                                startActivity(new Intent(employee.this, details.class));
                                finish();
                            } else {
                                bar.setVisibility(View.GONE);
                                Toast.makeText(employee.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


    }



}
