package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Certificate16Activity extends AppCompatActivity {

    String username;

    private DatabaseReference mDatabase;

    TextView question;

    public RadioGroup radioGroup;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;

    Boolean correct = false;

    int getValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate16);

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase = FirebaseDatabase.getInstance().getReference();

        question =findViewById(R.id.question);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.clearCheck();


        radio1 = findViewById(R.id.first);
        radio2 = findViewById(R.id.second);
        radio3 = findViewById(R.id.third);

        mDatabase.child("questions").child("ifs").child("while").child("second").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                question.setText(dataSnapshot.child("question").getValue().toString());
                radio1.setText(dataSnapshot.child("answers").child("first").getValue().toString());
                radio2.setText(dataSnapshot.child("answers").child("second").getValue().toString());
                radio3.setText(dataSnapshot.child("answers").child("third").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabase.child("users").child(username).child("certificateProgress").child("mistakes").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                getValue = Integer.parseInt(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
    }
}
