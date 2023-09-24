package com.example.myapplication;

//import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText age = (EditText) findViewById(R.id.textView2);
        final EditText uid = (EditText) findViewById(R.id.textView4);
        final EditText password = (EditText) findViewById(R.id.textView5);
        final EditText conPassword =(EditText)findViewById(R.id.textView6);

         findViewById(R.id.button2).setOnClickListener(view -> {
            final String ageTxt = age.getText().toString();
            final String user = uid.getText().toString();
            final String passwordTxt = password.getText().toString();
            final String conPasswordTxt = conPassword.getText().toString();

            if(ageTxt.isEmpty() || user.isEmpty() || passwordTxt.isEmpty()){
                Toast.makeText(MainActivity2.this, "Please fill all fields", Toast.LENGTH_SHORT).show();

            }
            else if(!passwordTxt.equals(conPasswordTxt)){
                Toast.makeText(MainActivity2.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
            }
            else{




                            set2 pos = new set2(user, passwordTxt,ageTxt);
                            Map<String, Object> postV = pos.toMap1();

                            Map<String, Object> childUpdat = new HashMap<>();
                            childUpdat.put(user, postV);
                           // childUpdat.put("/Patient/" + emailTxt+ "/" +age, postV);
                            pos.databaseReference.updateChildren(childUpdat);
                            Toast.makeText(MainActivity2.this, "User Registered Successfully.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity2.this,Home.class));
                            //finish();
                            //finish();

            }

        });

    }
}