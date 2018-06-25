package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;

public class MainContentActivity extends AppCompatActivity {

    ImageView learnBasicConcepts, learnIfAndLoops,learnClassesAndObjects, takeCertificate, info;

    private DatabaseReference mDatabase;

    String username;

    Boolean conceptsProgress;
    Boolean certificateProgress;
    Boolean statementsProgress;
    Boolean classesProgress;

    Boolean allPerfect;

    int classesPososto,conceptsPososto,ifsPososto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        learnBasicConcepts = findViewById(R.id.learnBasicConcepts);
        learnIfAndLoops = findViewById(R.id.learnIfAndLoops);
        learnClassesAndObjects = findViewById(R.id.learnClassesAndObjects);
        takeCertificate = findViewById(R.id.takeCertificate);

        info = findViewById(R.id.info);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase.child("users").child(username).child("progress").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                conceptsProgress = (Boolean) dataSnapshot.child("concepts").getValue();
                statementsProgress = (Boolean) dataSnapshot.child("statements").getValue();
                classesProgress = (Boolean) dataSnapshot.child("classes").getValue();
                certificateProgress = (Boolean) dataSnapshot.child("certificate").getValue();

                if(conceptsProgress){
                    learnBasicConcepts.setImageDrawable(getResources().getDrawable(R.drawable.first_green));
                }else{
                    learnBasicConcepts.setImageDrawable(getResources().getDrawable(R.drawable.first_red));
                }

                if(statementsProgress){
                    learnIfAndLoops.setImageDrawable(getResources().getDrawable(R.drawable.second_green));
                }else{
                    learnIfAndLoops.setImageDrawable(getResources().getDrawable(R.drawable.second_red));
                }


                if(classesProgress){
                    learnClassesAndObjects.setImageDrawable(getResources().getDrawable(R.drawable.fourth_green));
                }else{
                    learnClassesAndObjects.setImageDrawable(getResources().getDrawable(R.drawable.fourth_red));
                }

                if(certificateProgress){
                    takeCertificate.setImageDrawable(getResources().getDrawable(R.drawable.fifth_green));
                }else{
                    takeCertificate.setImageDrawable(getResources().getDrawable(R.drawable.fifth_red));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabase.child("users").child(username).child("classesProgress").child("pososto").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(Integer.parseInt(dataSnapshot.getValue().toString()) == 100){
                    classesPososto=100;

                }else{
                    classesPososto = Integer.parseInt(dataSnapshot.getValue().toString());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabase.child("users").child(username).child("ifsProgress").child("pososto").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(Integer.parseInt(dataSnapshot.getValue().toString()) == 100){
                    ifsPososto=100;

                }else{
                    ifsPososto = Integer.parseInt(dataSnapshot.getValue().toString());
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabase.child("users").child(username).child("conceptsProgress").child("pososto").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(Integer.parseInt(dataSnapshot.getValue().toString()) == 100){
                    conceptsPososto = 100;
                }else{
                    conceptsPososto = Integer.parseInt(dataSnapshot.getValue().toString());
                }

                if(ifsPososto>=80 && conceptsPososto>=80 && classesPososto>=80){
                    info.setImageDrawable(getResources().getDrawable(R.drawable.info_black));
                    allPerfect=true;
                }else{
                    info.setImageDrawable(getResources().getDrawable(R.drawable.info_red));
                    allPerfect=false;
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });



        mDatabase.child("users").child(username).child("progress").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if((Boolean) dataSnapshot.child("concepts").getValue()){
                    mDatabase.child("users").child(username).child("conceptsProgress").child("pososto").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            conceptsPososto = Integer.parseInt(dataSnapshot.getValue().toString());
                            if(conceptsPososto < 80){
                                showMessage("Basic Concepts Test","Even though you passed the test, you didnt score more than 80%. Maybe you should study and try again! ",0);
                                return;
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                if((Boolean) dataSnapshot.child("statements").getValue()){
                    mDatabase.child("users").child(username).child("ifsProgress").child("pososto").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            ifsPososto = Integer.parseInt(dataSnapshot.getValue().toString());
                            if(ifsPososto < 80){
                                showMessage("Statements test","Even though you passed the test, you didnt score more than 80%. Maybe you should study and try again! ",1);
                                return;
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                if((Boolean) dataSnapshot.child("classes").getValue()){
                    mDatabase.child("users").child(username).child("classesProgress").child("pososto").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            classesPososto = Integer.parseInt(dataSnapshot.getValue().toString());
                            if(classesPososto < 80){
                                showMessage("Classes test","Even though you passed the test, you didnt score more than 80%. Maybe you should study and try again! ",2);
                                return;
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//        if(conceptsPososto <80){
//            showMessage("Basic concepts test","Even though you passed the test, you didnt score more than 80%. Maybe you should study and try again! ");
//        }

    }

    public void openInfo(View view){
        Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
        intent.putExtra("whoIsLoggedIn", username);
        startActivity(intent);
    }



    public void basicConcepts(View view){
        Intent intent = new Intent(getApplicationContext(),BasicConceptsActivity.class);
        intent.putExtra("whoIsLoggedIn", username);
        startActivity(intent);
    }

    public void ifStatementAndLoops(View view){
        if(!conceptsProgress){
            Toast.makeText(this, "You first have to complete all the previous chapters.", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(getApplicationContext(),StatementsActivity.class);
            intent.putExtra("whoIsLoggedIn", username);
            startActivity(intent);
        }
    }

    public void classesAndObjects(View view){
        if(!statementsProgress){
            Toast.makeText(this, "You first have to complete all the previous chapters.", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(getApplicationContext(),ClassesActivity.class);
            intent.putExtra("whoIsLoggedIn", username);
            startActivity(intent);
        }
    }

    public void certificate(View view){
        if(!classesProgress){
            Toast.makeText(this, "You first have to complete all the previous chapters.", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(getApplicationContext(), CertificateActivity.class);
            intent.putExtra("whoIsLoggedIn", username);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {

    }

    public void showMessage(String title, String text,final int where){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(text);
        builder.setPositiveButton("Go to theory again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (where == 0){
                    Intent intent = new Intent(getApplicationContext(),BasicConceptsActivity.class);
                    intent.putExtra("whoIsLoggedIn", username);
                    startActivity(intent);
                }else if(where == 1){
                    Intent intent = new Intent(getApplicationContext(),StatementsActivity.class);
                    intent.putExtra("whoIsLoggedIn", username);
                    startActivity(intent);
                }else if(where == 2){
                    Intent intent = new Intent(getApplicationContext(),ClassesActivity.class);
                    intent.putExtra("whoIsLoggedIn", username);
                    startActivity(intent);
                }
            }
        });
        builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }
}
