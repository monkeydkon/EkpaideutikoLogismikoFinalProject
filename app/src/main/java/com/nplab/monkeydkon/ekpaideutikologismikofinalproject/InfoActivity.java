package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InfoActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    String username;

    TextView textViewClasses, textViewClassesPososto, textViewStatements, textViewStatementsPososto, textViewConcepts, textViewConceptsPososto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        textViewClassesPososto = findViewById(R.id.textViewClassesPososto);
        textViewConceptsPososto = findViewById(R.id.textViewConceptsPososto);
        textViewStatementsPososto = findViewById(R.id.textViewStatementsPososto);

        mDatabase.child("users").child(username).child("classesProgress").child("pososto").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                textViewClassesPososto.setText(dataSnapshot.getValue().toString()+"%");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabase.child("users").child(username).child("ifsProgress").child("pososto").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                textViewStatementsPososto.setText(dataSnapshot.getValue().toString()+"%");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabase.child("users").child(username).child("conceptsProgress").child("pososto").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                textViewConceptsPososto.setText(dataSnapshot.getValue().toString()+"%");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
