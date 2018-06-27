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

public class IfsTestFifthActivity extends AppCompatActivity {

    String username;

    private DatabaseReference mDatabase;
    boolean whiles;
    TextView question;

    public RadioGroup radioGroup;

    RadioButton radio1;
    RadioButton radio2;
    int extra;
    RadioButton radio3;

    Boolean correct = false;

    int getValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ifs_test_fifth);

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase = FirebaseDatabase.getInstance().getReference();

        question =findViewById(R.id.question);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        extra = 0;

        mDatabase.child("users").child(username).child("ifsProgress").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if((Boolean)dataSnapshot.child("forfalse").getValue()){
                    extra++;
                    if(extra == 1){
                        showMessage("Extra Question","For has to run a least once", false);
                    }
                    return;

                }
//                if((Boolean)dataSnapshot.child("inputfalse").getValue()){
//                    extra=2;
//                   if(extra == 2){
//                     // showMessage("Extra Question","You can take user input only from the keyboard", false);
//                      test2=true;
//                       // mDatabase.child("users").child(username).child("conceptsProgress").child("extra").setValue(extra);
//                        return;
//                    }
//               }
//
//                if((Boolean)dataSnapshot.child("introfalse").getValue()){
//                    extra=3;;
//                    if(extra == 3){
//                      //  showMessage("Extra Question","C# is a product of microsoft", true);
//                        test3=true;
//                       // mDatabase.child("users").child(username).child("conceptsextra").setValue(extra);
//                        return;
//                    }
//                }
//                if((Boolean)dataSnapshot.child("stringfalse").getValue()){
//                    extra=4;
//                    if(extra == 4){
//                       // showMessage("Extra Question","Strings are the same as characters", false);
//                        test4=true;
//                      //  mDatabase.child("users").child(username).child("conceptsextra").setValue(extra);
//                        return;
//                    }
//                }
//                if((Boolean)dataSnapshot.child("variablesfalse").getValue()){
//                    extra=5;
//                    if(extra == 5){
//                      //  showMessage("Extra Question","A variable can have more than one values at a time", false);
//                        test5=true;
//                      //  mDatabase.child("users").child(username).child("conceptsextra").setValue(extra);
//                        return;
//                    }
//                }

            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        radio1 = findViewById(R.id.first);
        radio2 = findViewById(R.id.second);
        radio3 = findViewById(R.id.third);
        mDatabase.child("users").child(username).child("ifsProgress").child("whilefalse").setValue(false); //reinitialize value
        mDatabase.child("users").child(username).child("ifsProgress").child("whilefalse").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                whiles=(boolean)dataSnapshot.getValue(); //get "false" value from firebase
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("questions").child("ifs").child("while").child("first").addValueEventListener(new ValueEventListener() {
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
                        mDatabase.child("questions").child("ifs").child("while").child("first").child("answers").child("correct").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (Integer.parseInt(dataSnapshot.getValue().toString()) != 1){
                                    getValue++;
                                    mDatabase.child("users").child(username).child("ifsProgress").child("mistakes").setValue(getValue);
                                    whiles=true;
                                    if(whiles)
                                    {
                                        mDatabase.child("users").child(username).child("ifsProgress").child("whilefalse").setValue(whiles);
                                    }
                                    //check();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        break;

                    case R.id.second:
                        mDatabase.child("questions").child("ifs").child("while").child("first").child("answers").child("correct").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (Integer.parseInt(dataSnapshot.getValue().toString()) != 2){
                                    getValue++;
                                    mDatabase.child("users").child(username).child("ifsProgress").child("mistakes").setValue(getValue);
                                    whiles=true;
                                    if(whiles)
                                    {
                                        mDatabase.child("users").child(username).child("ifsProgress").child("whilefalse").setValue(whiles);
                                    }
                                    //check();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        break;
                    case R.id.third:
                        mDatabase.child("questions").child("ifs").child("while").child("first").child("answers").child("correct").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (Integer.parseInt(dataSnapshot.getValue().toString()) != 3){
                                    getValue++;
                                    mDatabase.child("users").child(username).child("ifsProgress").child("mistakes").setValue(getValue);
                                    whiles=true;
                                    if(whiles)
                                    {
                                        mDatabase.child("users").child(username).child("ifsProgress").child("whilefalse").setValue(whiles);
                                    }
                                    // check();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        break;
                }
//                Intent intent = new Intent(getApplicationContext(),IfsTestFifthActivity.class);
//                intent.putExtra("whoIsLoggedIn", username);
//                startActivity(intent);


                if((getValue) > 2){
                    mDatabase.child("users").child(username).child("ifsProgress").child("mistakes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            mDatabase.child("users").child(username).child("ifsProgress").child("mistakes").setValue(0);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                    Toast.makeText(getApplicationContext(),"You failed the test. Study better and try again!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),MainContentActivity.class);
                    intent.putExtra("whoIsLoggedIn", username);
                    startActivity(intent);
                }else if((getValue) >= 1){
                    mDatabase.child("users").child(username).child("progress").child("statements").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            mDatabase.child("users").child(username).child("progress").child("statements").setValue(true);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                    mDatabase.child("users").child(username).child("ifsProgress").child("quiz").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            mDatabase.child("users").child(username).child("ifsProgress").child("quiz").setValue(true);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                    mDatabase.child("users").child(username).child("ifssProgress").child("pososto").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            mDatabase.child("users").child(username).child("ifsProgress").child("pososto").setValue(((5-getValue)*100)/5);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    Toast.makeText(getApplicationContext(),"You passed the test",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),MainContentActivity.class);
                    intent.putExtra("whoIsLoggedIn", username);
                    startActivity(intent);

                }else if (getValue == 0){
                    mDatabase.child("users").child(username).child("progress").child("statements").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            mDatabase.child("users").child(username).child("progress").child("statements").setValue(true);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                    mDatabase.child("users").child(username).child("ifsProgress").child("quiz").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            mDatabase.child("users").child(username).child("ifsProgress").child("quiz").setValue(true);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                    mDatabase.child("users").child(username).child("ifsProgress").child("pososto").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            mDatabase.child("users").child(username).child("ifsProgress").child("pososto").setValue(((5-getValue)*100)/5);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    Toast.makeText(getApplicationContext(),"You passed the test",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),MainContentActivity.class);
                    intent.putExtra("whoIsLoggedIn", username);
                    startActivity(intent);
                }
            }

        });
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
                    mDatabase.child("users").child(username).child("ifsProgress").child("mistakes").setValue(getValue);
                    Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();

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
                    mDatabase.child("users").child(username).child("ifsProgress").child("mistakes").setValue(getValue);
                    Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();

                }
                dialogInterface.cancel();
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}
