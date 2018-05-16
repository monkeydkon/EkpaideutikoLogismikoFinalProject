package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ConceptCommentsTestActivitty extends AppCompatActivity{

    String username;

    private DatabaseReference mDatabase;

    TextView question;

    public RadioGroup radioGroup;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;

    Boolean correct = false;

    int getValue = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept_comments_test_activitty);

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase = FirebaseDatabase.getInstance().getReference();

        question =findViewById(R.id.question);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.clearCheck();


        radio1 = findViewById(R.id.first);
        radio2 = findViewById(R.id.second);
        radio3 = findViewById(R.id.third);

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

        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId){
                    case R.id.first:
                        mDatabase.child("questions").child("basic").child("comments").child("first").child("answers").child("correct").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                switch (Integer.parseInt(dataSnapshot.getValue().toString())){
                                    case 1:
                                        break;
                                    case 2:
                                        mDatabase.child("questions").child("basic").child("comments").child("first").child("mistakes").addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {

                                                getValue = Integer.parseInt(dataSnapshot.getValue().toString());
                                                getValue++;

                                                mDatabase.child("users").child(username).child("conceptsProgress").child("mistakes").setValue(getValue);

                                                return;


                                            }

                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {

                                            }


                                        });

                                        break;


                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        break;

                    case R.id.second:
                        break;
                    case R.id.third:
                        break;
                }
            }
        });


    }

}
