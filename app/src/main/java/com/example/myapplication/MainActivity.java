package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://myapplication-bfef2-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText email = findViewById(R.id.username2);
        final EditText password = findViewById(R.id.password2);
        final Button  loginBtn = findViewById(R.id.button1);
        final Button signupBtn = findViewById(R.id.button);

        loginBtn.setOnClickListener(view -> {
            final String emailTxt = email.getText().toString();
            final String passwordTxt = password.getText().toString();

            if(emailTxt.isEmpty() || passwordTxt.isEmpty()){
                Toast.makeText(MainActivity.this, "Please enter your email and password", Toast.LENGTH_SHORT).show();
            }
            else{
                databaseReference .child("Patient").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(emailTxt)){
                            final String getPassword = snapshot.child(emailTxt).child("password").getValue(String.class);
                            if(getPassword.equals(passwordTxt)){
                                Toast.makeText(MainActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this,Home.class));
                                //finish();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Wrong Email", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }

        });
        signupBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,MainActivity2.class)));
    }
}