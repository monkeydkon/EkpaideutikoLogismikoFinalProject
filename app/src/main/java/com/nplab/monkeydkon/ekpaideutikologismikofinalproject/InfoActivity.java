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
    String comments,variables,intro,input,strings; //Strings for subchapters that need to be studied more
    String ifst,elseif,switchs,whiles,fors;
    String oops,classess,methodss,returntypess,getterss;
    boolean commentsfalse,inputfalse,introfalse,stringfalse,variablefalse; //booleans
    boolean iffalse,elseiffalse,switchfalse,whilefalse,forfalse;
    boolean oopfalse,classesfalse,methodsfalse,returntypesfalse,gettersfalse;
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
        //For 1ST CHAPTER
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
        //FOR 2ND CHAPTER
        mDatabase.child("users").child(username).child("ifsProgress").child("iffalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                iffalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(iffalse)
                {
                    ifst=" If Statements ";
                }
                else
                {
                    ifst="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("users").child(username).child("ifsProgress").child("elseiffalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                elseiffalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(elseiffalse)
                {
                    elseif=" Else If Statements ";
                }
                else
                {
                    elseif="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("users").child(username).child("ifsProgress").child("switchfalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                switchfalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(switchfalse)
                {
                    switchs=" Switch Case Statements ";
                }
                else
                {
                    switchs="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("users").child(username).child("ifsProgress").child("whilefalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                whilefalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(whilefalse)
                {
                    whiles=" While Loop Statements ";
                }
                else
                {
                    whiles="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("users").child(username).child("ifsProgress").child("forfalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               forfalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(forfalse)
                {
                    fors=" For Loop Statements ";
                }
                else
                {
                    fors="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
      //  3o test (classes)
        mDatabase.child("users").child(username).child("classesProgress").child("oopfalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                oopfalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(oopfalse)
                {
                    oops=" Object Oriented Programming ";
                }
                else
                {
                    oops="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("users").child(username).child("classesProgress").child("classesfalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                classesfalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(classesfalse)
                {
                    classess=" Classes ";
                }
                else
                {
                    classess="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("users").child(username).child("classesProgress").child("methodsfalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                methodsfalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(methodsfalse)
                {
                    methodss=" Methods ";
                }
                else
                {
                    methodss="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("users").child(username).child("classesProgress").child("returntypesfalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                returntypesfalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(returntypesfalse)
                {
                    returntypess=" Method_Return Types ";
                }
                else
                {
                    returntypess="";
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child("users").child(username).child("classesProgress").child("gettersfalse").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                gettersfalse=(boolean) dataSnapshot.getValue(); //get commentsfalse value
                if(gettersfalse)
                {
                   getterss=" Getters and Setters ";
                }
                else
                {
                    getterss="";
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
        textViewStatementsPososto.setOnClickListener(new View.OnClickListener() { //when click on basic concepts
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You Seem to be lacking the understanding of the following concepts:"+ifst+elseif+switchs+whiles+fors,Toast.LENGTH_SHORT).show();
            }
        });
        textViewClassesPososto.setOnClickListener(new View.OnClickListener() { //when click on basic concepts
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You Seem to be lacking the understanding of the following concepts:"+oops+classess+methodss+returntypess+getterss,Toast.LENGTH_SHORT).show();
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
