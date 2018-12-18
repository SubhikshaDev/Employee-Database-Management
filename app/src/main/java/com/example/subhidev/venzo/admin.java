package com.example.subhidev.venzo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class admin extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText emailField,passwordField;
    private ProgressBar bar;
    private Button emp;
    //private TextView fetch;
    FirebaseDatabase ourbase;
    DatabaseReference refer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        auth=FirebaseAuth.getInstance();

        emp= (Button) findViewById(R.id.textViewEmpLogin);
        ourbase=FirebaseDatabase.getInstance();
        refer=ourbase.getReferenceFromUrl("https://venzo-a446f.firebaseio.com/role");
        emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),employee.class));
                finish();
            }
        });
        Button buttonLogin=(Button) findViewById(R.id.buttonLogin);

        emailField=(EditText) findViewById(R.id.editTextEmail);
        passwordField=(EditText) findViewById(R.id.editTextPassword);
        bar=(ProgressBar) findViewById(R.id.progressBar1);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bar.setVisibility(View.VISIBLE);
                String email=emailField.getText().toString();
                String password=passwordField.getText().toString();
                if(email.isEmpty()){
                    Toast.makeText(admin.this, "Enter email",
                            Toast.LENGTH_SHORT).show();

                }
                else if(password.isEmpty()){
                    Toast.makeText(admin.this, "Enter password",
                            Toast.LENGTH_SHORT).show();

                }
                else {
                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        //FirebaseUser role=FirebaseAuth.getInstance().getCurrentUser();
                                        isadmin(); //if admin user move to admin dashboard

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(admin.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                bar.setVisibility(View.GONE);

            }
        });
    }
    private void isadmin(){
       // String Role=user.getUid();

       DatabaseReference mchild=refer.child("-LTvb5EZEuwEhejejjiJ").child("role");
        mchild.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 String value = dataSnapshot.getValue(String.class);


                if (value.equals("admin")) {
                    // Sign in success
                    bar.setVisibility(View.GONE);
                    Intent intent = new Intent(getApplicationContext(),board.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(admin.this, "You are not an admin", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
