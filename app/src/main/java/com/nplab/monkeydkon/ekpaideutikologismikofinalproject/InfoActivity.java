package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InfoActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    String username;
    String comments,variables,intro,input,strings;
    boolean commentsfalse,inputfalse,introfalse,stringfalse,variablefalse;
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
        mDatabase.child("users").child(username).child("conceptsProgress").child("commentsfalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                commentsfalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(commentsfalse)
                {
                    comments=" comments ";
                }
                else
                {
                    comments="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("users").child(username).child("conceptsProgress").child("inputfalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                inputfalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(inputfalse)
                {
                    input=" inputs ";
                }
                else
                {
                    input="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("users").child(username).child("conceptsProgress").child("introfalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                introfalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(introfalse)
                {
                    intro=" intro ";
                }
                else
                {
                    intro="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("users").child(username).child("conceptsProgress").child("stringfalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                stringfalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(stringfalse)
                {
                    strings=" strings ";
                }
                else
                {
                    strings="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("users").child(username).child("conceptsProgress").child("variablesfalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                variablefalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(variablefalse)
                {
                    variables=" variables ";
                }
                else
                {
                    variables="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        textViewConceptsPososto.setOnClickListener(new View.OnClickListener() { //when click on basic concepts
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You Seem to be lacking the understanding of the following concepts:"+comments+input+intro+strings+variables,Toast.LENGTH_SHORT).show();
            }
        });

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
