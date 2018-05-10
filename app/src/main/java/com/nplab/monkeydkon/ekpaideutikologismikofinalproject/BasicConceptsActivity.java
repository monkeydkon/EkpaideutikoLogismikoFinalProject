package com.nplab.monkeydkon.ekpaideutikologismikofinalproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BasicConceptsActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    String username;

    boolean comments;
    boolean increment;
    boolean input;
    boolean intro;
    boolean quiz;
    boolean strings;
    boolean variables;

    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_concepts);

        cardView = findViewById(R.id.cardView);

        final RelativeLayout firstRelative = findViewById(R.id.firstRelative);
        final RelativeLayout secondRelative = findViewById(R.id.secondRelative);
        final RelativeLayout thirdRelative = findViewById(R.id.thirdRelative);
        final RelativeLayout fourthRelative = findViewById(R.id.fourthRelative);
        final RelativeLayout fifthRelative = findViewById(R.id.fifthRelative);
        final RelativeLayout sixthRelative = findViewById(R.id.sixthRelative);
        final RelativeLayout seventhRelative = findViewById(R.id.seventhRelative);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        username = intent.getStringExtra("whoIsLoggedIn");

        mDatabase.child("users").child(username).child("conceptsProgress").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                comments = (Boolean) dataSnapshot.child("comments").getValue();
                increment = (Boolean) dataSnapshot.child("increment").getValue();
                input = (Boolean) dataSnapshot.child("input").getValue();
                intro = (Boolean) dataSnapshot.child("intro").getValue();
                quiz = (Boolean) dataSnapshot.child("quiz").getValue();
                strings = (Boolean) dataSnapshot.child("strings").getValue();
                variables = (Boolean) dataSnapshot.child("variables").getValue();

                if(intro){
                    firstRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(comments){
                    secondRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(variables){
                    thirdRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(increment){
                    fourthRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(strings){
                    fifthRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(input){
                    sixthRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
                if(quiz){
                    seventhRelative.setBackgroundColor(Color.parseColor("#d1f59a"));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    
    public void introClick(View view){
        Intent intent = new Intent(getApplicationContext(),ConceptsIntroActivity.class);
        intent.putExtra("whoIsLoggedIn", username);
        startActivity(intent);
    }
    
    public void commentsClick(View view){
        if(!intro){
            Toast.makeText(this,"You first need to complete all other sections",Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(getApplicationContext(),ConceptsCommentsActivity.class);
            intent.putExtra("whoIsLoggedIn", username);
            startActivity(intent);
        }
    }
    
    public void variablesClick(View view){
        if(!comments){
            Toast.makeText(this,"You first need to complete all other sections",Toast.LENGTH_SHORT).show();
        }else{
            // TODO: 7/5/2018
        }
    }
    
    public void incrementClick(View view){
        if(!variables){
            Toast.makeText(this,"You first need to complete all other sections",Toast.LENGTH_SHORT).show();
        }else{
            // TODO: 7/5/2018
        }
    }
    
    public void stringsClick(View view){
        if(!increment){
            Toast.makeText(this,"You first need to complete all other sections",Toast.LENGTH_SHORT).show();
        }else{
            // TODO: 7/5/2018
        }
    }
    
    public void inputClick(View view){
        if(!strings){
            Toast.makeText(this,"You first need to complete all other sections",Toast.LENGTH_SHORT).show();
        }else{
            // TODO: 7/5/2018
        }
    }
    
    public void quizClick(View view){
        if(!input){
            Toast.makeText(this,"You first need to complete all other sections",Toast.LENGTH_SHORT).show();
        }else{
            // TODO: 7/5/2018
        }
    }
}
