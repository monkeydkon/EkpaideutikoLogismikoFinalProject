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

import org.w3c.dom.Text;

public class ConceptCommentsTestActivitty extends AppCompatActivity {

    String username;

    private DatabaseReference mDatabase;

    TextView question;

    RadioGroup radioGroup;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept_comments_test_activitty);

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase = FirebaseDatabase.getInstance().getReference();

        question =findViewById(R.id.question);
        radioGroup = findViewById(R.id.radioGroup);

        radio1 = findViewById(R.id.radioButton2);
        radio2 = findViewById(R.id.radioButton3);
        radio3 = findViewById(R.id.radioButton4);

        mDatabase.child("questions").child("basic").child("comments").child("first").addValueEventListener(new ValueEventListener() {
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


    }
}
