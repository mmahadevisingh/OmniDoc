package com.example.myapplication;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class set2 {
    //String i;


   // public void rec(String i) {
        //this.i = i;
    //}

    public String uid1;
    public String pass1;
    public String age1;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Patient");


    //public Map<String, Boolean> stars = new HashMap<>();


    public set2(String uid1, String pass1,String age1) {
        this.uid1 = uid1;
        this.pass1 = pass1;
        this.age1=age1;
    }

    @Exclude
    public Map<String, Object> toMap1() {
        HashMap<String, Object> result1 = new HashMap<>();
        result1.put("uid", uid1);
        result1.put("password", pass1);
        result1.put("age",age1);
        return result1;
    }
}
