package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfChangeActivity extends AppCompatActivity {

    String question,first,second,third,correct,chapter,which,finalChosen;

    EditText editText5,editText6,editText7,editText8,editText9;

    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_change);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        Intent intent = getIntent();


        question = intent.getStringExtra("question");
        first = intent.getStringExtra("first");
        second = intent.getStringExtra("second");
        third = intent.getStringExtra("third");
        correct = intent.getStringExtra("correct");
        chapter = intent.getStringExtra("chapter");
        which = intent.getStringExtra("which");
        finalChosen = intent.getStringExtra("finalChosen");


        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);
        editText7 = findViewById(R.id.editText7);
        editText8 = findViewById(R.id.editText8);
        editText9 = findViewById(R.id.editText9);

        editText5.setText(question);
        editText6.setText(first);
        editText7.setText(second);
        editText8.setText(third);
        editText9.setText(correct);


    }


    public void done(View view){
        mDatabase.child("questions").child(chapter).child(which).child(finalChosen).child("answers").child("first").setValue(editText6.getText().toString());
        mDatabase.child("questions").child(chapter).child(which).child(finalChosen).child("answers").child("second").setValue(editText7.getText().toString());
        mDatabase.child("questions").child(chapter).child(which).child(finalChosen).child("answers").child("third").setValue(editText8.getText().toString());
        mDatabase.child("questions").child(chapter).child(which).child(finalChosen).child("answers").child("correct").setValue(Integer.parseInt(editText9.getText().toString()));
        mDatabase.child("questions").child(chapter).child(which).child(finalChosen).child("question").setValue(editText5.getText().toString());

        Intent intent = new Intent(this,ProfActivity.class);
        startActivity(intent);


    }
}
