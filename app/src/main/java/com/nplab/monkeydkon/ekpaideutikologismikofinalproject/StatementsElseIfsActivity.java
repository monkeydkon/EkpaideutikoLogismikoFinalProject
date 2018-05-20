package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StatementsElseIfsActivity extends AppCompatActivity {

    String username;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statements_else_ifs);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");
    }

    public void done (View view){
        mDatabase.child("users").child(username).child("ifsProgress").child("elseif").setValue(true);
        Intent intent = new Intent(getApplicationContext(),StatementsActivity.class);
        intent.putExtra("whoIsLoggedIn", username);
        startActivity(intent);

    }
}

