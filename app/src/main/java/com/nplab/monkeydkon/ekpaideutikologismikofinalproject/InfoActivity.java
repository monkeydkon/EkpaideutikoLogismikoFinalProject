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
    TextView textViewClasses, textViewClassesPososto, textViewStatements, textViewStatementsPososto, textViewConcepts, textViewConceptsPososto, introEpi,inputEpi,commentsEpi,stringsEpi,variablesEpi;
    TextView ifEpi,elseifEpi,forEpi,switchEpi,whileEpi;
    TextView classesEpi,gettersEpi,methodsEpi,oopEpi,returnEpi;

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

        introEpi = findViewById(R.id.introEpi);
        inputEpi = findViewById(R.id.inputEpi);
        variablesEpi = findViewById(R.id.variablesEpi);
        commentsEpi = findViewById(R.id.commentsEpi);
        stringsEpi = findViewById(R.id.stringsEpi);

        ifEpi = findViewById(R.id.ifEpi);
        elseifEpi = findViewById(R.id.elseifEpi);
        forEpi = findViewById(R.id.forEpi);
        switchEpi = findViewById(R.id.switchEpi);
        whileEpi = findViewById(R.id.whileEpi);

        classesEpi = findViewById(R.id.classesEpi);
        gettersEpi = findViewById(R.id.gettersEpi);
        methodsEpi = findViewById(R.id.methodsEpi);
        oopEpi = findViewById(R.id.oopEpi);
        returnEpi = findViewById(R.id.returnEpi);

        mDatabase.child("users").child(username).child("visited").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                introEpi.setText(dataSnapshot.child("concepts").child("intro").getValue().toString());
                inputEpi.setText(dataSnapshot.child("concepts").child("input").getValue().toString());
                variablesEpi.setText(dataSnapshot.child("concepts").child("variables").getValue().toString());
                commentsEpi.setText(dataSnapshot.child("concepts").child("comments").getValue().toString());
                stringsEpi.setText(dataSnapshot.child("concepts").child("strings").getValue().toString());

                ifEpi.setText(dataSnapshot.child("statements").child("if").getValue().toString());
                elseifEpi.setText(dataSnapshot.child("statements").child("elseif").getValue().toString());
                forEpi.setText(dataSnapshot.child("statements").child("for").getValue().toString());
                whileEpi.setText(dataSnapshot.child("statements").child("while").getValue().toString());
                switchEpi.setText(dataSnapshot.child("statements").child("switch").getValue().toString());

                classesEpi.setText(dataSnapshot.child("classes").child("classes").getValue().toString());
                gettersEpi.setText(dataSnapshot.child("classes").child("getters").getValue().toString());
                methodsEpi.setText(dataSnapshot.child("classes").child("methods").getValue().toString());
                oopEpi.setText(dataSnapshot.child("classes").child("oop").getValue().toString());
                returnEpi.setText(dataSnapshot.child("classes").child("return").getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

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
