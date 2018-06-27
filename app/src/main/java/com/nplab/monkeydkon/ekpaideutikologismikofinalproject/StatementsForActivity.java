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

public class StatementsForActivity extends AppCompatActivity {
    String username;

    int times;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statements_for);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase.child("users").child(username).child("visited").child("statements").child("for").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                times = Integer.parseInt(dataSnapshot.getValue().toString());
                times++;
                mDatabase.child("users").child(username).child("visited").child("statements").child("for").setValue(times);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void done (View view){
        mDatabase.child("users").child(username).child("ifsProgress").child("for").setValue(true);
        Intent intent = new Intent(getApplicationContext(),StatementsActivity.class);
        intent.putExtra("whoIsLoggedIn", username);
        startActivity(intent);
    }
}
