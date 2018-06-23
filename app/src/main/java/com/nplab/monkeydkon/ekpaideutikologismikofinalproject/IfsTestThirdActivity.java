package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class IfsTestThirdActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_ifs_test_third);

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase = FirebaseDatabase.getInstance().getReference();

        question =findViewById(R.id.question);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.clearCheck();


        radio1 = findViewById(R.id.first);
        radio2 = findViewById(R.id.second);
        radio3 = findViewById(R.id.third);

        mDatabase.child("questions").child("ifs").child("switch").child("first").addValueEventListener(new ValueEventListener() {
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

        mDatabase.child("users").child(username).child("ifsProgress").child("mistakes").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                getValue = Integer.parseInt(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId){
                    case R.id.first:
                        mDatabase.child("questions").child("ifs").child("switch").child("first").child("answers").child("correct").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (Integer.parseInt(dataSnapshot.getValue().toString()) != 1){
                                    getValue++;
                                    mDatabase.child("users").child(username).child("ifsProgress").child("mistakes").setValue(getValue);

                                    //check();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        break;

                    case R.id.second:
                        mDatabase.child("questions").child("ifs").child("switch").child("first").child("answers").child("correct").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (Integer.parseInt(dataSnapshot.getValue().toString()) != 2){
                                    getValue++;
                                    mDatabase.child("users").child(username).child("ifsProgress").child("mistakes").setValue(getValue);

                                    //check();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        break;
                    case R.id.third:
                        mDatabase.child("questions").child("ifs").child("switch").child("first").child("answers").child("correct").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (Integer.parseInt(dataSnapshot.getValue().toString()) != 3){
                                    getValue++;
                                    mDatabase.child("users").child(username).child("ifsProgress").child("mistakes").setValue(getValue);

                                    // check();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        break;
                }
                Intent intent = new Intent(getApplicationContext(),IfsTestFourthActivity.class);
                intent.putExtra("whoIsLoggedIn", username);
                startActivity(intent);

            }

        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"You first have to finish the test",Toast.LENGTH_SHORT).show();
    }
}
