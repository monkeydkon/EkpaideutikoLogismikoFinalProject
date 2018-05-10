package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConceptsIntroActivity extends AppCompatActivity {

    String username;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concepts_intro);

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase = FirebaseDatabase.getInstance().getReference();

    }

    public void done(View view){

        mDatabase.child("users").child(username).child("conceptsProgress").child("intro").setValue(true);

        Intent intent = new Intent(getApplicationContext(),BasicConceptsActivity.class);
        intent.putExtra("whoIsLoggedIn", username);
        startActivity(intent);
    }
}