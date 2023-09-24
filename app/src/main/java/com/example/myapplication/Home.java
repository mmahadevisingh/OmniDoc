package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button button2 = findViewById(R.id.button5);
        //bt=findViewById(R.id.button4);
        //String i = getIntent().getStringExtra("message");

        button2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {


                //if(i.equals("1")) {

                    Intent intent = new Intent(Home.this, Choose.class);
                    startActivity(intent);
                /*}
                else
                {
                    Intent intent = new Intent(decide.this, Login.class);
                    startActivity(intent);
                }*/


            }
        });
    }
}