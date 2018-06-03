package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ClassesActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    String username;

    boolean oop;
    boolean classes;
    boolean methods;
    boolean returnTypes;
    boolean getters;
    boolean quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        final RelativeLayout firstRelative = findViewById(R.id.firstRelative);
        final RelativeLayout secondRelative = findViewById(R.id.secondRelative);
        final RelativeLayout thirdRelative = findViewById(R.id.thirdRelative);
        final RelativeLayout fifthRelative = findViewById(R.id.fifthRelative);
        final RelativeLayout sixthRelative = findViewById(R.id.sixthRelative);
        final RelativeLayout seventhRelative = findViewById(R.id.seventhRelative);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase.child("users").child(username).child("classesProgress").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                oop = (Boolean) dataSnapshot.child("oop").getValue();
                classes = (Boolean) dataSnapshot.child("classes").getValue();
                methods = (Boolean) dataSnapshot.child("methods").getValue();
                returnTypes = (Boolean) dataSnapshot.child("returnTypes").getValue();
                getters = (Boolean) dataSnapshot.child("getters").getValue();
                quiz = (Boolean) dataSnapshot.child("quiz").getValue();

                if(oop){
                    firstRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(classes){
                    secondRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(methods){
                    thirdRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(returnTypes){
                    fifthRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(getters){
                    sixthRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(quiz){
                    seventhRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    
    public void oop(View view){
        Intent intent = new Intent(getApplicationContext(),ClassesOopActivity.class);
        intent.putExtra("whoIsLoggedIn", username);
        startActivity(intent);
    }
    
    public void classes(View view){
        if(!oop){
            Toast.makeText(this,"You first need to complete all other sections",Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(getApplicationContext(),ClassesClassesActivity.class);
            intent.putExtra("whoIsLoggedIn", username);
            startActivity(intent);
        }
    }
    
    public void methods(View view){
        if(!classes){
            Toast.makeText(this,"You first need to complete all other sections",Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(getApplicationContext(),ClassesMethodsActivity.class);
            intent.putExtra("whoIsLoggedIn", username);
            startActivity(intent);
        }
    }
    
    public void returnTypes(View view){
        if(!methods){
            Toast.makeText(this,"You first need to complete all other sections",Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(getApplicationContext(),ClassesMethodReturnTypesActivity.class);
            intent.putExtra("whoIsLoggedIn", username);
            startActivity(intent);
        }
    }
    
    public void getters(View view){
        if(!returnTypes){
            Toast.makeText(this,"You first need to complete all other sections",Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(getApplicationContext(),ClassesGettersActivity.class);
            intent.putExtra("whoIsLoggedIn", username);
            startActivity(intent);
        }
    }
    
    public void quiz(View view){
        if(!getters){
            Toast.makeText(this,"You first need to complete all other sections",Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(getApplicationContext(),ClassesTestFirstActivity.class);
            intent.putExtra("whoIsLoggedIn", username);
            startActivity(intent);
        }

    }
    
}
