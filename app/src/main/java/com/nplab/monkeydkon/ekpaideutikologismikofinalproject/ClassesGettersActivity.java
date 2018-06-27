package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ClassesGettersActivity extends AppCompatActivity {

    String username;

    private DatabaseReference mDatabase;

    int times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_getters);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase.child("users").child(username).child("visited").child("classes").child("getters").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                times = Integer.parseInt(dataSnapshot.getValue().toString());
                times++;
                mDatabase.child("users").child(username).child("visited").child("classes").child("getters").setValue(times);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void done(View view){
        mDatabase.child("users").child(username).child("classesProgress").child("getters").setValue(true);
        Intent intent = new Intent(getApplicationContext(),ClassesActivity.class);
        intent.putExtra("whoIsLoggedIn", username);
        startActivity(intent);
    }
}
