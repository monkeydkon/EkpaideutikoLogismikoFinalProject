package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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

public class ConceptsTestFirstActivity extends AppCompatActivity {

    int extra;

    boolean commentsfalse;

    boolean test;

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
        setContentView(R.layout.activity_concepts_test_first);

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("users").child(username).child("conceptsProgress").child("extra").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                extra = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabase.child("users").child(username).child("conceptsProgress").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if((Boolean)dataSnapshot.child("commentsfalse").getValue()){
                    extra++;
                    if(extra == 1){
                        showMessage("Extra Question","You can only comment a single line at once", true);
                    }
                    return;

                }
//                if((Boolean)dataSnapshot.child("inputfalse").getValue()){
//                    extra=2;
//                   if(extra == 2){
//                      showMessage("Extra Question","You can take user input only from the keyboard", false);
//                       // mDatabase.child("users").child(username).child("conceptsProgress").child("extra").setValue(extra);
//                        return;
//                    }
//               }
//
//               return;
//                if((Boolean)dataSnapshot.child("introfalse").getValue()){
//                    extra++;
//                    if(extra == 3){
//                        showMessage("Extra Question","C# is a product of microsoft", true);
//                        mDatabase.child("users").child(username).child("conceptsProgress").child("extra").setValue(extra);
//                        return;
//                    }
//                }
//                if((Boolean)dataSnapshot.child("stringfalse").getValue()){
//                    extra++;
//                    if(extra == 4){
//                        showMessage("Extra Question","Strings are the same as characters", false);
//                        mDatabase.child("users").child(username).child("conceptsProgress").child("extra").setValue(extra);
//                        return;
//                    }
//                }
//                if((Boolean)dataSnapshot.child("variablesfalse").getValue()){
//                    extra++;
//                    if(extra == 5){
//                        showMessage("Extra Question","A variable can have more than one values at a time", false);
//                        mDatabase.child("users").child(username).child("conceptsProgress").child("extra").setValue(extra);
//                        return;
//                    }
//                }

            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        question =findViewById(R.id.question);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.clearCheck();


        radio1 = findViewById(R.id.first);
        radio2 = findViewById(R.id.second);
        radio3 = findViewById(R.id.third);

        mDatabase.child("users").child(username).child("conceptsProgress").child("mistakes").setValue(0);
        mDatabase.child("users").child(username).child("conceptsProgress").child("pososto").setValue(0);
        mDatabase.child("users").child(username).child("conceptsProgress").child("commentsfalse").setValue(false);
        mDatabase.child("users").child(username).child("conceptsProgress").child("commentsfalse").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                commentsfalse=(boolean)dataSnapshot.getValue(); //get "false" value from firebase
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


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

        mDatabase.child("users").child(username).child("conceptsProgress").child("mistakes").addListenerForSingleValueEvent(new ValueEventListener() {
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
                        mDatabase.child("questions").child("basic").child("comments").child("first").child("answers").child("correct").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (Integer.parseInt(dataSnapshot.getValue().toString()) != 1){
                                        getValue++;
                                        commentsfalse=true;
                                        mDatabase.child("users").child(username).child("conceptsProgress").child("mistakes").setValue(getValue);
                                    if(commentsfalse)
                                    {
                                        mDatabase.child("users").child(username).child("conceptsProgress").child("commentsfalse").setValue(commentsfalse);
                                    }

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        break;

                    case R.id.second:
                        mDatabase.child("questions").child("basic").child("comments").child("first").child("answers").child("correct").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (Integer.parseInt(dataSnapshot.getValue().toString()) != 2){
                                    getValue++;
                                    commentsfalse=true;
                                    mDatabase.child("users").child(username).child("conceptsProgress").child("mistakes").setValue(getValue);
                                    if(commentsfalse)
                                    {
                                        mDatabase.child("users").child(username).child("conceptsProgress").child("commentsfalse").setValue(commentsfalse);
                                    }

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        break;
                    case R.id.third:
                        mDatabase.child("questions").child("basic").child("comments").child("first").child("answers").child("correct").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (Integer.parseInt(dataSnapshot.getValue().toString()) != 3){
                                    getValue++;
                                    commentsfalse=true;
                                    mDatabase.child("users").child(username).child("conceptsProgress").child("mistakes").setValue(getValue);
                                    if(commentsfalse)
                                    {
                                        mDatabase.child("users").child(username).child("conceptsProgress").child("commentsfalse").setValue(commentsfalse);
                                    }

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        break;
                }


                goToSecond();
            }
        });


    }

    public void goToSecond(){
        Intent intent = new Intent(getApplicationContext(),ConceptsTestSecondActivity.class);
        intent.putExtra("whoIsLoggedIn", username);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"You first have to finish the test",Toast.LENGTH_SHORT).show();
    }

    public void showMessage(String title, String text, final boolean which){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(text);
        builder.setPositiveButton("TRUE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(!which){
                    getValue++;
                    mDatabase.child("users").child(username).child("conceptsProgress").child("mistakes").setValue(getValue);
                }

                dialogInterface.cancel();
                dialogInterface.dismiss();

            }
        });
        builder.setNegativeButton("FALSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(which){
                    getValue++;
                    mDatabase.child("users").child(username).child("conceptsProgress").child("mistakes").setValue(getValue);
                }
                dialogInterface.cancel();
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}
