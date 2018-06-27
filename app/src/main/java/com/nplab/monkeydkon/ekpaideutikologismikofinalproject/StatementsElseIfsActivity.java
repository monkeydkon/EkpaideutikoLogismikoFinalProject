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

public class StatementsElseIfsActivity extends AppCompatActivity {

    String username;

    private DatabaseReference mDatabase;

    int times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statements_else_ifs);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase.child("users").child(username).child("visited").child("statements").child("elseif").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                times = Integer.parseInt(dataSnapshot.getValue().toString());
                times++;
                mDatabase.child("users").child(username).child("visited").child("statements").child("elseif").setValue(times);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void done (View view){
        mDatabase.child("users").child(username).child("ifsProgress").child("elseif").setValue(true);
        Intent intent = new Intent(getApplicationContext(),StatementsActivity.class);
        intent.putExtra("whoIsLoggedIn", username);
        startActivity(intent);

    }
}

